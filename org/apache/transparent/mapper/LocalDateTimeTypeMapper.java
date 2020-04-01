package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.apache.transparent.util.StringUtils;

public class LocalDateTimeTypeMapper extends BaseTypeMapper<LocalDateTime> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, LocalDateTime parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, Timestamp.valueOf(parameterValue));
	}

	public LocalDateTime getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getLocalDateTime(resultSet.getTimestamp(columnIndex));
	}

	public LocalDateTime getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getLocalDateTime(resultSet.getTimestamp(columnLabel));
	}

	public LocalDateTime getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getLocalDateTime(callableStatement.getTimestamp(parameterIndex));
	}

	public LocalDateTime getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getLocalDateTime(callableStatement.getTimestamp(parameterName));
	}

	public LocalDateTime getLocalDateTime(Timestamp timestamp) {
		if (StringUtils.isEmpty(timestamp)) {
			return null;
		}
		return timestamp.toLocalDateTime();
	}

}
