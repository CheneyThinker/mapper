package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class TimestampCalendarTypeMapper extends BaseTypeMapper<Timestamp> {

	private Calendar calendar;

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Timestamp parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, parameterValue, calendar);
	}

	public Timestamp getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getTimestamp(columnIndex, calendar);
	}

	public Timestamp getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getTimestamp(columnLabel, calendar);
	}

	public Timestamp getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getTimestamp(parameterIndex, calendar);
	}

	public Timestamp getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getTimestamp(parameterName, calendar);
	}

}
