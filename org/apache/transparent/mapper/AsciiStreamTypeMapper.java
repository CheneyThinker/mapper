package org.apache.transparent.mapper;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsciiStreamTypeMapper extends BaseTypeMapper<InputStream> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, InputStream parameterValue) throws SQLException {
		preparedStatement.setAsciiStream(parameterIndex, parameterValue);
	}

	public InputStream getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getAsciiStream(columnIndex);
	}

	public InputStream getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getAsciiStream(columnLabel);
	}

	public InputStream getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getClob(parameterIndex).getAsciiStream();
	}

	public InputStream getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getClob(parameterName).getAsciiStream();
	}

}
