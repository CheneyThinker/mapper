package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanTypeMapper extends BaseTypeMapper<Boolean> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Boolean parameterValue) throws SQLException {
		preparedStatement.setBoolean(parameterIndex, parameterValue);
	}

	public Boolean getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getBoolean(columnIndex);
	}

	public Boolean getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getBoolean(columnLabel);
	}

	public Boolean getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getBoolean(parameterIndex);
	}

	public Boolean getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getBoolean(parameterName);
	}

}
