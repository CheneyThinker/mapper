package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.OffsetTime;

import org.apache.transparent.util.StringUtils;

public class OffsetTimeTypeMapper extends BaseTypeMapper<OffsetTime> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, OffsetTime parameterValue) throws SQLException {
		preparedStatement.setTime(parameterIndex, Time.valueOf(parameterValue.toLocalTime()));
	}

	public OffsetTime getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getOffsetTime(resultSet.getTime(columnIndex));
	}

	public OffsetTime getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getOffsetTime(resultSet.getTime(columnLabel));
	}

	public OffsetTime getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getOffsetTime(callableStatement.getTime(parameterIndex));
	}

	public OffsetTime getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getOffsetTime(callableStatement.getTime(parameterName));
	}

	public OffsetTime getOffsetTime(Time time) {
		if (StringUtils.isEmpty(time)) {
			return null;
		}
		return time.toLocalTime().atOffset(OffsetTime.now().getOffset());
	}

}
