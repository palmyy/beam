package org.esa.beam.dataio.modis.attribute;

import org.esa.beam.dataio.modis.ModisGlobalAttributes;
import org.esa.beam.dataio.modis.hdf.HdfDataField;
import org.esa.beam.dataio.modis.netcdf.NetCDFVariables;
import org.esa.beam.framework.dataio.ProductIOException;
import org.esa.beam.framework.datamodel.GeoCoding;
import org.esa.beam.util.io.FileUtils;
import org.esa.beam.util.logging.BeamLogManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ucar.nc2.Variable;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.logging.Logger;

public class ImappAttributes implements ModisGlobalAttributes {

    private final File inputFile;
    private final Logger logger;
    private final NetCDFVariables netCDFVariables;

    public ImappAttributes(File inputFile, NetCDFVariables netCDFVariables) {
        this.inputFile = inputFile;
        this.netCDFVariables = netCDFVariables;

        logger = BeamLogManager.getSystemLogger();
    }

    @Override
    public String getProductName() {
        return FileUtils.getFilenameWithoutExtension(inputFile);
    }

    @Override
    public String getProductType() {
        final String inputFileName = FileUtils.getFilenameWithoutExtension(inputFile);
        final int dotIndex = inputFileName.indexOf(".");
        if (dotIndex > 0) {
            return inputFileName.substring(0, dotIndex);
        } else {
            logger.warning("Unable to retrieve the product type from the file name.");
            return "unknown";
        }
    }

    @Override
    public Dimension getProductDimensions() {
        throw new NotImplementedException();
    }

    @Override
    public Dimension getProductDimensions(java.util.List<ucar.nc2.Dimension> netcdfFileDimensions) {
        int width = 0;
        int height = 0;
        final Variable[] all = netCDFVariables.getAll();
        for (int i = 0; i < all.length; i++) {
            final Variable variable = all[i];
            final int rank = variable.getRank();
            if (rank == 2) {
                // @todo 1 tb/tb continue here
            } else if (rank == 3) {
                // @todo 1 tb/tb continue here
            }
        }
        throw new NotImplementedException();
    }

    @Override
    public HdfDataField getDatafield(String name) throws ProductIOException {
        throw new NotImplementedException();
    }

    @Override
    public Date getSensingStart() {
        throw new NotImplementedException();
    }

    @Override
    public Date getSensingStop() {
        throw new NotImplementedException();
    }

    @Override
    public int[] getSubsamplingAndOffset(String dimensionName) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isImappFormat() {
        return true;
    }

    @Override
    public String getEosType() {
        return null;
    }

    @Override
    public GeoCoding createGeocoding() {
        return null;
    }
}