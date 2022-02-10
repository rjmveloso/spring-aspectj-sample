package io.github.sample.spring.jdbc.support;

public abstract class ClobConverterAdapter implements ClobConverterAware {

    private transient ClobConverter converter;

    protected ClobConverter getClobConverter() {
        return converter;
    }

    public void setClobConverter(ClobConverter converter) {
        this.converter = converter;
    }
}
