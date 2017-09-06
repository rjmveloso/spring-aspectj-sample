package io.github.sample.spring.jdbc.support;

import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * This class can be used if SessionFactory is available for injection
 * 
 * @author rveloso
 *
 */
@Configurable
public class ClobConverterImpl2 implements ClobConverter {

	@Autowired
	private SessionFactory sfactory;

	public String read(Clob clob) {
		if (clob == null) {
			return null;
		}

		try {
			int length = (int) clob.length();
			return clob.getSubString(1, length);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Clob create(String string) {
		if (string == null) {
			return null;
		}

		Session session = sfactory.getCurrentSession();
		LobCreator lcreator = Hibernate.getLobCreator(session);
		return lcreator.createClob(string);
	}

}
