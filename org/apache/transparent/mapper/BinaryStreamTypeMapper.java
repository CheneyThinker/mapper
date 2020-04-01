package org.apache.transparent.mapper;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BinaryStreamTypeMapper extends BaseTypeMapper<InputStream> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, InputStream parameterValue) throws SQLException {
		preparedStatement.setBinaryStream(parameterIndex, parameterValue);
	}

	public InputStream getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getBinaryStream(columnIndex);
	}

	public InputStream getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getBinaryStream(columnLabel);
	}

	public InputStream getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getBlob(parameterIndex).getBinaryStream();
	}

	public InputStream getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getBlob(parameterName).getBinaryStream();
	}

}
