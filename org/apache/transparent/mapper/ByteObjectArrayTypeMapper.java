package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.ByteUtils;

public class ByteObjectArrayTypeMapper extends BaseTypeMapper<Byte[]> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Byte[] parameterValue) throws SQLException {
		preparedStatement.setBytes(parameterIndex, ByteUtils.getByteArray(parameterValue));
	}

	public Byte[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return ByteUtils.getByteObjectArray(resultSet.getBytes(columnIndex));
	}

	public Byte[] getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return ByteUtils.getByteObjectArray(resultSet.getBytes(columnLabel));
	}

	public Byte[] getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return ByteUtils.getByteObjectArray(callableStatement.getBytes(parameterIndex));
	}

	public Byte[] getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return ByteUtils.getByteObjectArray(callableStatement.getBytes(parameterName));
	}

}
