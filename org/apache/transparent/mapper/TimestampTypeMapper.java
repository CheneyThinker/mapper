package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TimestampTypeMapper extends BaseTypeMapper<Timestamp> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Timestamp parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, parameterValue);
	}

	public Timestamp getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getTimestamp(columnIndex);
	}

	public Timestamp getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getTimestamp(columnLabel);
	}

	public Timestamp getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getTimestamp(parameterIndex);
	}

	public Timestamp getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getTimestamp(parameterName);
	}

}
