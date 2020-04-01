package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringTypeMapper extends BaseTypeMapper<String> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
		preparedStatement.setString(parameterIndex, parameterValue);
	}

	public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getString(columnIndex);
	}

	public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getString(columnLabel);
	}

	public String getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getString(parameterIndex);
	}

	public String getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getString(parameterName);
	}

}
