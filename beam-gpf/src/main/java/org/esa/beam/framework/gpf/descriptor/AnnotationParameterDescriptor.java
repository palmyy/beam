package org.esa.beam.framework.gpf.descriptor;

import com.bc.ceres.binding.Converter;
import com.bc.ceres.binding.Validator;
import com.bc.ceres.binding.dom.DomConverter;
import com.bc.ceres.core.Assert;
import org.esa.beam.framework.datamodel.RasterDataNode;
import org.esa.beam.framework.gpf.annotations.Parameter;

/**
 * A {@link ParameterDescriptor} implementation for the
 * {@link org.esa.beam.framework.gpf.annotations.Parameter Parameter} annotation.
 *
 * @author Norman Fomferra
 * @since BEAM 5
 */
public class AnnotationParameterDescriptor implements ParameterDescriptor {
    private final String name;
    private final Class<?> dataType;
    private final Parameter annotation;

    public AnnotationParameterDescriptor(String name, Class<?> dataType, Parameter annotation) {
        Assert.notNull(name, "name");
        Assert.notNull(dataType, "dataType");
        Assert.notNull(annotation, "annotation");
        this.annotation = annotation;
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getDataType() {
        return dataType;
    }

    public Parameter getAnnotation() {
        return annotation;
    }

    @Override
    public String getAlias() {
        return getNonEmptyStringOrNull(annotation.alias());
    }

    @Override
    public String getItemAlias() {
        return getNonEmptyStringOrNull(annotation.itemAlias());
    }

    @Override
    public boolean areItemsInlined() {
        return annotation.itemsInlined();
    }

    @Override
    public String getDefaultValue() {
        return getNonEmptyStringOrNull(annotation.defaultValue());
    }

    @Override
    public String getLabel() {
        return getNonEmptyStringOrNull(annotation.label());
    }

    @Override
    public String getUnit() {
        return getNonEmptyStringOrNull(annotation.unit());
    }

    @Override
    public String getDescription() {
        return getNonEmptyStringOrNull(annotation.description());
    }

    @Override
    public String[] getValueSet() {
        return annotation.valueSet();
    }

    @Override
    public String getInterval() {
        return getNonEmptyStringOrNull(annotation.interval());
    }

    @Override
    public String getCondition() {
        return getNonEmptyStringOrNull(annotation.condition());
    }

    @Override
    public String getPattern() {
        return getNonEmptyStringOrNull(annotation.pattern());
    }

    @Override
    public String getFormat() {
        return getNonEmptyStringOrNull(annotation.format());
    }

    @Override
    public boolean isNotNull() {
        return annotation.notNull();
    }

    @Override
    public boolean isNotEmpty() {
        return annotation.notEmpty();
    }

    @Override
    public Class<? extends Validator> getValidator() {
        return annotation.validator();
    }

    @Override
    public Class<? extends Converter> getConverter() {
        return annotation.converter();
    }

    @Override
    public Class<? extends DomConverter> getDomConverter() {
        return annotation.domConverter();
    }

    @Override
    public Class<? extends RasterDataNode> getRasterDataNodeType() {
        return annotation.rasterDataNodeType();
    }

    private static String getNonEmptyStringOrNull(String label) {
        return label == null || label.isEmpty() ? null : label;
    }
}