package org.postgresql.core.v3;

/**
 * @author Юрин Роман @date 21.03.19
 **/
public interface IJdbcParam2Function<P1, P2, V> {
	public V invoke(P1 p1, P2 p2);
}

