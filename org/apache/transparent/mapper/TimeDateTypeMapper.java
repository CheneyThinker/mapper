package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.transparent.util.StringUtils;

public class TimeDateTypeMapper extends BaseTypeMapper<Date> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Date parameterValue) throws SQLException {
		preparedStatement.setTime(parameterIndex, new Time(parameterValue.getTime()));
	}

	public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getDate(resultSet.getTime(columnIndex));
	}

	public Date getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getDate(resultSet.getTime(columnLabel));
	}

	public Date getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getDate(callableStatement.getTime(parameterIndex));
	}

	public Date getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getDate(callableStatement.getTime(parameterName));
	}

	public Date getDate(Time time) {
		if (StringUtils.isEmpty(time)) {
			return null;
		}
		return new Date(time.getTime());
	}

}
