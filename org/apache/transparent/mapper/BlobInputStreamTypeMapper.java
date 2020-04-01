package org.apache.transparent.mapper;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class BlobInputStreamTypeMapper extends BaseTypeMapper<InputStream> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, InputStream parameterValue) throws SQLException {
		preparedStatement.setBlob(parameterIndex, parameterValue);
	}

	public InputStream getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getInputStream(resultSet.getBlob(columnIndex));
	}

	public InputStream getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getInputStream(resultSet.getBlob(columnLabel));
	}

	public InputStream getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getInputStream(callableStatement.getBlob(parameterIndex));
	}

	public InputStream getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getInputStream(callableStatement.getBlob(parameterName));
	}

	public InputStream getInputStream(Blob blob) throws SQLException {
		if (StringUtils.isEmpty(blob)) {
			return null;
		}
		return blob.getBinaryStream();
	}

}
