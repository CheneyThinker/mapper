package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntEnumTypeMapper<E extends Enum<E>> extends BaseTypeMapper<E> {

	private E[] enums;

	public void setEnumType(Class<E> enumType) {
		this.enums = enumType.getEnumConstants();
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, E parameterValue) throws SQLException {
		preparedStatement.setInt(parameterIndex, parameterValue.ordinal());
	}

	public E getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : enums[resultSet.getInt(columnIndex)];
	}

	public E getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : enums[resultSet.getInt(columnLabel)];
	}

	public E getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : enums[callableStatement.getInt(parameterIndex)];
	}

	public E getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : enums[callableStatement.getInt(parameterName)];
	}

}
