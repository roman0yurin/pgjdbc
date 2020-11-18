package org.postgresql.core.c60

import java.sql.Connection
import java.util.Calendar

/**
* Обертка для работы с подключением к БД
	*
	* @author Юрин Роман @date 07.02.19.
*/
trait IJdbcConnContainer {

	/**
		* Jdbc подключение, на котором можно использовать выражения из кеша данного объекта
		**/
	def getConnection():Connection
}
