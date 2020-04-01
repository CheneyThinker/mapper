package org.apache.transparent.mapper;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobTypeMapper extends BaseTypeMapper<Blob> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Blob parameterValue) throws SQLException {
		preparedStatement.setBlob(parameterIndex, parameterValue);
	}

	public Blob getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getBlob(columnIndex);
	}

	public Blob getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getBlob(columnLabel);
	}

	public Blob getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getBlob(parameterIndex);
	}

	public Blob getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getBlob(parameterName);
	}

}
