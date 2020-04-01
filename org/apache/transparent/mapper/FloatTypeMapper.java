package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FloatTypeMapper extends BaseTypeMapper<Float> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Float parameterValue) throws SQLException {
		preparedStatement.setFloat(parameterIndex, parameterValue);
	}

	public Float getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getFloat(columnIndex);
	}

	public Float getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getFloat(columnLabel);
	}

	public Float getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getFloat(parameterIndex);
	}

	public Float getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getFloat(parameterName);
	}

}
