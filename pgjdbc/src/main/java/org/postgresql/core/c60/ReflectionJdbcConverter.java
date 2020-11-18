package org.postgresql.core.c60;

import org.postgresql.PGConnection;
import org.postgresql.jdbc.PgConnection;
import org.postgresql.util.PGobject;

/**
 * Конвертер основанный на вызове конструктора через рефлексию.
 * Соответствует старому мехинизму работы JDBC
 * @author Юрин Роман @date 14.11.18
 **/
public class ReflectionJdbcConverter implements JdbcConverter<PGobject>{
	public final String tp;
	public final Class<? extends PGobject> cls;

	public ReflectionJdbcConverter(String tp, Class<? extends  PGobject> cls) {
		this.tp = tp;
		this.cls = cls;
	}

	@Override
	public String pgType() {
		return tp;
	}

	@Override
	public PGobject convertFromText(String textValue, PGConnection conn) {
		try {
			PGobject pGobject = cls.newInstance();
			pGobject.setType(tp);
			pGobject.setValue(textValue);
			return pGobject;
		}catch (Exception ex){
			throw new RuntimeException("Ошибка при конвертации значения " + textValue, ex);
		}
	}

	@Override
	public String convertToText(PGobject value, PGConnection conn) {
		return  value != null ? value.getValue(): null;
	}

	@Override
	public Class<PGobject> getReturnType() {
		return (Class)cls;
	}
}