package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.transparent.util.StringUtils;

public class LocalDateTypeMapper extends BaseTypeMapper<LocalDate> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, LocalDate parameterValue) throws SQLException {
		preparedStatement.setDate(parameterIndex, Date.valueOf(parameterValue));
	}

	public LocalDate getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getLocalDate(resultSet.getDate(columnIndex));
	}

	public LocalDate getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getLocalDate(resultSet.getDate(columnLabel));
	}

	public LocalDate getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getLocalDate(callableStatement.getDate(parameterIndex));
	}

	public LocalDate getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getLocalDate(callableStatement.getDate(parameterName));
	}

	public LocalDate getLocalDate(Date date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return date.toLocalDate();
	}

}
