package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortTypeMapper extends BaseTypeMapper<Short> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Short parameterValue) throws SQLException {
		preparedStatement.setShort(parameterIndex, parameterValue);
	}

	public Short getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getShort(columnIndex);
	}

	public Short getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getShort(columnLabel);
	}

	public Short getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getShort(parameterIndex);
	}

	public Short getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getShort(parameterName);
	}

}
