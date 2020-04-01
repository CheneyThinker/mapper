package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import org.apache.transparent.util.StringUtils;

public class OffsetDateTimeTypeMapper extends BaseTypeMapper<OffsetDateTime> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, OffsetDateTime parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, Timestamp.from(parameterValue.toInstant()));
	}

	public OffsetDateTime getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getOffsetDateTime(resultSet.getTimestamp(columnIndex));
	}

	public OffsetDateTime getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getOffsetDateTime(resultSet.getTimestamp(columnLabel));
	}

	public OffsetDateTime getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getOffsetDateTime(callableStatement.getTimestamp(parameterIndex));
	}

	public OffsetDateTime getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getOffsetDateTime(callableStatement.getTimestamp(parameterName));
	}

	public OffsetDateTime getOffsetDateTime(Timestamp timestamp) {
		if (StringUtils.isEmpty(timestamp)) {
			return null;
		}
		return OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
	}

}
