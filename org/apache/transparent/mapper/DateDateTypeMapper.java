package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.util.Date;

import org.apache.transparent.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateDateTypeMapper extends BaseTypeMapper<Date> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Date parameterValue) throws SQLException {
		preparedStatement.setDate(parameterIndex, new java.sql.Date(parameterValue.getTime()));
	}

	public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getDate(resultSet.getDate(columnIndex));
	}

	public Date getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getDate(resultSet.getDate(columnLabel));
	}

	public Date getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getDate(callableStatement.getDate(parameterIndex));
	}

	public Date getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getDate(callableStatement.getDate(parameterName));
	}

	public Date getDate(java.sql.Date sqlDate) {
		if (StringUtils.isEmpty(sqlDate)) {
			return null;
		}
		return new Date(sqlDate.getTime());
	}

}
