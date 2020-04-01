package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.transparent.util.StringUtils;

public class TimestampDateTypeMapper extends BaseTypeMapper<Date> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Date parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, new Timestamp(parameterValue.getTime()));
	}

	public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getDate(resultSet.getTimestamp(columnIndex));
	}

	public Date getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getDate(resultSet.getTimestamp(columnLabel));
	}

	public Date getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getDate(callableStatement.getTimestamp(parameterIndex));
	}

	public Date getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getDate(callableStatement.getTimestamp(parameterName));
	}

	public Date getDate(Timestamp timestamp) {
		if (StringUtils.isEmpty(timestamp)) {
			return null;
		}
		return new Date(timestamp.getTime());
	}

}
