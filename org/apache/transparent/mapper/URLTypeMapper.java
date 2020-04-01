package org.apache.transparent.mapper;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class URLTypeMapper extends BaseTypeMapper<URL> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, URL parameterValue) throws SQLException {
		preparedStatement.setURL(parameterIndex, parameterValue);
	}

	public URL getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getURL(columnIndex);
	}

	public URL getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getURL(columnLabel);
	}

	public URL getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getURL(parameterIndex);
	}

	public URL getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getURL(parameterName);
	}

}
