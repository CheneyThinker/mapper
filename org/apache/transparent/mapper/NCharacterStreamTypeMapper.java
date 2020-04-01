package org.apache.transparent.mapper;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NCharacterStreamTypeMapper extends BaseTypeMapper<Reader> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Reader parameterValue) throws SQLException {
		preparedStatement.setNCharacterStream(parameterIndex, parameterValue);
	}

	public Reader getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getNCharacterStream(columnIndex);
	}

	public Reader getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getNCharacterStream(columnLabel);
	}

	public Reader getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getNCharacterStream(parameterIndex);
	}

	public Reader getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getNCharacterStream(parameterName);
	}

}
