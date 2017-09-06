package io.github.sample.spring.jdbc.support;

import java.sql.Clob;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

@Configurable
public class ClobConverterImpl implements ClobConverter {

	@PersistenceContext
	private EntityManager emanager;

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

	@Transactional // use this to force a transaction context otherwise a exception will be raised
	public Clob create(String string) {
		if (string == null) {
			return null;
		}

		Session session = emanager.unwrap(Session.class);
		LobCreator lcreator = Hibernate.getLobCreator(session);
		//LobHelper lcreator = session.getLobHelper();
		return lcreator.createClob(string);
	}
}
