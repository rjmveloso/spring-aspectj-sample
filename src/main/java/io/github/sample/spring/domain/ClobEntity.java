package io.github.sample.spring.domain;

import java.sql.Clob;

import io.github.sample.spring.jdbc.support.ClobConverterAware;
import io.github.sample.spring.jdbc.support.ClobConverter;

public class ClobEntity implements ClobConverterAware {

	private Clob field;

	public String getField() {
		return getClobConverter().read(field);
	}

	public void setField(String field) {
		this.field = getClobConverter().create(field);
	}

	private transient ClobConverter cconverter;

	private ClobConverter getClobConverter() {
		return cconverter;
	}

	public void setClobConverter(ClobConverter converter) {
		this.cconverter = converter;
	}

}
