package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ByteTypeMapper extends BaseTypeMapper<Byte> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Byte parameterValue) throws SQLException {
		preparedStatement.setByte(parameterIndex, parameterValue);
	}

	public Byte getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getByte(columnIndex);
	}

	public Byte getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : resultSet.getByte(columnLabel);
	}

	public Byte getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getByte(parameterIndex);
	}

	public Byte getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : callableStatement.getByte(parameterName);
	}

}
