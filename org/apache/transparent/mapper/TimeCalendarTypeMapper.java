package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

public class TimeCalendarTypeMapper extends BaseTypeMapper<Time> {

	private Calendar calendar;

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Time parameterValue) throws SQLException {
		preparedStatement.setTime(parameterIndex, parameterValue, calendar);
	}

	public Time getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getTime(columnIndex, calendar);
	}

	public Time getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getTime(columnLabel, calendar);
	}

	public Time getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getTime(parameterIndex, calendar);
	}

	public Time getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getTime(parameterName, calendar);
	}

}
