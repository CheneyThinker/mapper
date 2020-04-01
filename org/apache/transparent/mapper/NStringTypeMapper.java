package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NStringTypeMapper extends BaseTypeMapper<String> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
		preparedStatement.setNString(parameterIndex, parameterValue);
	}

	public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getNString(columnIndex);
	}

	public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getNString(columnLabel);
	}

	public String getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getNString(parameterIndex);
	}

	public String getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getNString(parameterName);
	}

}
