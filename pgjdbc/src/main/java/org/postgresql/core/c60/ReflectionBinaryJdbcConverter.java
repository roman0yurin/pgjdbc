package org.postgresql.core.c60;

import org.postgresql.util.PGBinaryObject;
import org.postgresql.util.PGobject;

/**
 * Соответствует прежнему механизму работы JDBC с вызовом конвертора через рефлексивный конструктор
 * @author Юрин Роман @date 14.11.18
 **/
public class ReflectionBinaryJdbcConverter extends ReflectionJdbcConverter implements JdbcBinaryConverter<PGobject>{
	public ReflectionBinaryJdbcConverter(String tp, Class<? extends PGobject> cls) {
		super(tp, cls);
	}

	@Override
	public PGobject convertFromBinary(byte[] buffer, int offset) {
		try {
			PGobject bo = cls.newInstance();
			bo.setType(pgType());
			((PGBinaryObject)bo).setByteValue(buffer, offset);
			return bo;
		}catch (Exception ex){
			throw new RuntimeException("Ошибка при конвертации " + pgType() + " из бинарного значения");
		}
	}

	@Override
	public int binaryLength(PGobject value) {
		return ((PGBinaryObject)value).lengthInBytes();
	}

	@Override
	public void convertToBinary(PGobject value, byte[] buffer, int offset) {
		((PGBinaryObject)value).toBytes(buffer, offset);
	}
}
