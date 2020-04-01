package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import org.apache.transparent.util.StringUtils;

public class TimestampInstantTypeMapper extends BaseTypeMapper<Instant> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Instant parameterValue) throws SQLException {
		preparedStatement.setTimestamp(parameterIndex, Timestamp.from(parameterValue));
	}

	public Instant getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getInstant(resultSet.getTimestamp(columnIndex));
	}

	public Instant getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getInstant(resultSet.getTimestamp(columnLabel));
	}

	public Instant getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getInstant(callableStatement.getTimestamp(parameterIndex));
	}

	public Instant getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getInstant(callableStatement.getTimestamp(parameterName));
	}

	public Instant getInstant(Timestamp timestamp) {
		if (StringUtils.isEmpty(timestamp)) {
			return null;
		}
		return timestamp.toInstant();
	}

}
