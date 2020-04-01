package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoubleTypeMapper extends BaseTypeMapper<Double> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Double parameterValue) throws SQLException {
		preparedStatement.setDouble(parameterIndex, parameterValue);
	}

	public Double getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getDouble(columnIndex);
	}

	public Double getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getDouble(columnLabel);
	}

	public Double getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getDouble(parameterIndex);
	}

	public Double getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getDouble(parameterName);
	}

}
