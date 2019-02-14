package org.postgresql.core.c60;

import org.postgresql.PGConnection;
import org.postgresql.core.Oid;

/**
 * Обеспечивает конвертацию данных определенного типа (с точки зрения Postgres) между уровнем Java и Postgres.
 * Изначально поддерживается текстовый формат обмена, но расширение дает возможность использовать бинарный формат.
 * Объект должен допускать работу в многопоточном режиме.
 * @author Юрин Роман @date 14.11.18
 **/
public interface JdbcConverter<JAVA_TYPE> {

	/**Тип данных Postgres, с которым работает данный преобразователь**/
	String pgType();

	/**Идентификатор преобразуемого типа данных**/
	default int oid(){
		return Oid.UNSPECIFIED;
	}

	/**Принять значение из БД для данного типа данных в текстовом формате**/
	JAVA_TYPE convertFromText(String textValue, PGConnection conn);

	/**Сериализовать значение для БД в текстовый формат**/
	String convertToText(JAVA_TYPE value, PGConnection conn);

	/**Тип возвращаемых значений**/
	Class<JAVA_TYPE> getReturnType();
}
