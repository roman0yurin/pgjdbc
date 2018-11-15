package org.postgresql.core.c60;

import org.postgresql.util.PGobject;

/**
 * Обеспечивает конвертацию данных определенного типа (с точки зрения Postgres) между уровнем Java и Postgres.
 * Изначально поддерживается текстовый формат обмена, но расширение дает возможность использовать бинарный формат.
 * Объект должен допускать работу в многопоточном режиме.
 * @author Юрин Роман @date 14.11.18
 **/
public interface JdbcConverter<JAVA_TYPE> {

	/**Тип данных Postgres, с которым работает данный преобразователь**/
	String pgType();

	/**Принять значение из БД для данного типа данных в текстовом формате**/
	JAVA_TYPE convertFromText(String textValue);

	/**Сериализовать значение для БД в текстовый формат**/
	String convertToText(JAVA_TYPE value);
}
