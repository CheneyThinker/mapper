package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class TimeTypeMapper extends BaseTypeMapper<Time> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Time parameterValue) throws SQLException {
		preparedStatement.setTime(parameterIndex, parameterValue);
	}

	public Time getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getTime(columnIndex);
	}

	public Time getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getTime(columnLabel);
	}

	public Time getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getTime(parameterIndex);
	}

	public Time getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getTime(parameterName);
	}

}
