package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class DateCalendarTypeMapper extends BaseTypeMapper<Date> {

	private Calendar calendar;

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Date parameterValue) throws SQLException {
		preparedStatement.setDate(parameterIndex, parameterValue, calendar);
	}

	public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getDate(columnIndex, calendar);
	}

	public Date getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getDate(columnLabel, calendar);
	}

	public Date getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getDate(parameterIndex, calendar);
	}

	public Date getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getDate(parameterName, calendar);
	}

}
