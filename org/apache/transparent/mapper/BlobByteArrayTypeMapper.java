package org.apache.transparent.mapper;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class BlobByteArrayTypeMapper extends BaseTypeMapper<byte[]> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, byte[] parameterValue) throws SQLException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(parameterValue);
		//preparedStatement.setBinaryStream(parameterIndex, inputStream, parameterValue.length);
		preparedStatement.setBlob(parameterIndex, inputStream);
	}

	public byte[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getByteArray(resultSet.getBlob(columnIndex));
	}

	public byte[] getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getByteArray(resultSet.getBlob(columnLabel));
	}

	public byte[] getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getByteArray(callableStatement.getBlob(parameterIndex));
	}

	public byte[] getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getByteArray(callableStatement.getBlob(parameterName));
	}

	public byte[] getByteArray(Blob blob) throws SQLException {
		if (StringUtils.isEmpty(blob)) {
			return null;
		}
		try {
			return blob.getBytes(1, (int) blob.length());
		} finally {
			try {
				blob.free();
			} catch (SQLException e) {
			}
		}
	}

}
