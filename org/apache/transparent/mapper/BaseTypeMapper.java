package org.apache.transparent.mapper;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseTypeMapper<T> implements TypeMapper<T> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, T parameterValue, JDBCType jdbcType) throws SQLException {
		if (parameterValue == null) {
			preparedStatement.setNull(parameterIndex, jdbcType.ordinal(), jdbcType.name());
		} else {
			setParameter(preparedStatement, parameterIndex, parameterValue);
		}
	}

	public abstract void setParameter(PreparedStatement preparedStatement, int parameterIndex, T parameterValue) throws SQLException;

}
