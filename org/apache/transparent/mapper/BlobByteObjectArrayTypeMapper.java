package org.apache.transparent.mapper;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.ByteUtils;
import org.apache.transparent.util.StringUtils;

public class BlobByteObjectArrayTypeMapper extends BaseTypeMapper<Byte[]> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Byte[] parameterValue) throws SQLException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(ByteUtils.getByteArray(parameterValue));
		//preparedStatement.setBinaryStream(parameterIndex, inputStream, parameterValue.length);
		preparedStatement.setBlob(parameterIndex, inputStream);
	}

	public Byte[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getByteArray(resultSet.getBlob(columnIndex));
	}

	public Byte[] getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getByteArray(resultSet.getBlob(columnLabel));
	}

	public Byte[] getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getByteArray(callableStatement.getBlob(parameterIndex));
	}

	public Byte[] getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getByteArray(callableStatement.getBlob(parameterName));
	}

	public Byte[] getByteArray(Blob blob) throws SQLException {
		if (StringUtils.isEmpty(blob)) {
			return null;
		}
		try {
			return ByteUtils.getByteObjectArray(blob.getBytes(1, (int) blob.length()));
		} finally {
			try {
				blob.free();
			} catch (SQLException e) {
			}
		}
	}

}
