package io.github.sample.spring.jdbc.support;

import java.sql.Clob;

public interface ClobConverter {

	String read(Clob clob);

	Clob create(String str);

}
