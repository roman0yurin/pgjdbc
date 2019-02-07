package org.postgresql.core.c60;

import org.postgresql.PGConnection;;

/**
 * Конвертер данных, поддерживающий бинарный формат обмена
 * @author Юрин Роман @date 14.11.18
 **/
public interface JdbcBinaryConverter<JAVA_TYPE> extends JdbcConverter<JAVA_TYPE> {

	/**Принять значение из БД для данного типа данных в бинарном формате**/
	JAVA_TYPE convertFromBinary(byte[] buffer, int offset, PGConnection conn);

	/**Сколько байт потребуется на запись значения**/
	int binaryLength(JAVA_TYPE value, PGConnection conn);

	/**Сериализовать значение для БД в бинарный формат**/
	void convertToBinary(JAVA_TYPE value, byte[] buffer, int offset, PGConnection conn);
}
