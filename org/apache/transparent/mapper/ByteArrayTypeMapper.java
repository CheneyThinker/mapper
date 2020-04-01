package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ByteArrayTypeMapper extends BaseTypeMapper<byte[]> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, byte[] parameterValue) throws SQLException {
		preparedStatement.setBytes(parameterIndex, parameterValue);
	}

	public byte[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getBytes(columnIndex);
	}

	public byte[] getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getBytes(columnLabel);
	}

	public byte[] getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getBytes(parameterIndex);
	}

	public byte[] getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getBytes(parameterName);
	}

}
