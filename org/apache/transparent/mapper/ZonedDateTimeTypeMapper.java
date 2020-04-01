package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.apache.transparent.util.StringUtils;

public class ZonedDateTimeTypeMapper extends BaseTypeMapper<ZonedDateTime> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, ZonedDateTime parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, Timestamp.from(parameterValue.toInstant()));
	}

	public ZonedDateTime getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getZonedDateTime(resultSet.getTimestamp(columnIndex));
	}

	public ZonedDateTime getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getZonedDateTime(resultSet.getTimestamp(columnLabel));
	}

	public ZonedDateTime getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getZonedDateTime(callableStatement.getTimestamp(parameterIndex));
	}

	public ZonedDateTime getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getZonedDateTime(callableStatement.getTimestamp(parameterName));
	}

	public ZonedDateTime getZonedDateTime(Timestamp timestamp) {
		if (StringUtils.isEmpty(timestamp)) {
			return null;
		}
		return ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
	}

}
