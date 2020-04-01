package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import org.apache.transparent.util.StringUtils;

public class LocalTimeTypeMapper extends BaseTypeMapper<LocalTime> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, LocalTime parameterValue) throws SQLException {
		preparedStatement.setTime(parameterIndex, Time.valueOf(parameterValue));
	}

	public LocalTime getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getLocalTime(resultSet.getTime(columnIndex));
	}

	public LocalTime getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getLocalTime(resultSet.getTime(columnLabel));
	}

	public LocalTime getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getLocalTime(callableStatement.getTime(parameterIndex));
	}

	public LocalTime getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getLocalTime(callableStatement.getTime(parameterName));
	}

	public LocalTime getLocalTime(Time time) {
		if (StringUtils.isEmpty(time)) {
			return null;
		}
		return time.toLocalTime();
	}

}
