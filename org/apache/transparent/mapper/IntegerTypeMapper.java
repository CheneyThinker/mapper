package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerTypeMapper extends BaseTypeMapper<Integer> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Integer parameterValue) throws SQLException {
		preparedStatement.setInt(parameterIndex, parameterValue);
	}

	public Integer getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getInt(columnIndex);
	}

	public Integer getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getInt(columnLabel);
	}

	public Integer getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getInt(parameterIndex);
	}

	public Integer getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getInt(parameterName);
	}

}
