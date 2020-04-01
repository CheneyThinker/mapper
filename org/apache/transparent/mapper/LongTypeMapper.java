package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LongTypeMapper extends BaseTypeMapper<Long> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Long parameterValue) throws SQLException {
		preparedStatement.setLong(parameterIndex, parameterValue);
	}

	public Long getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getLong(columnIndex);
	}

	public Long getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getLong(columnLabel);
	}

	public Long getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getLong(parameterIndex);
	}

	public Long getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getLong(parameterName);
	}

}
