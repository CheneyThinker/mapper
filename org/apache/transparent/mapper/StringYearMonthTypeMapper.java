package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;

import org.apache.transparent.util.StringUtils;

public class StringYearMonthTypeMapper extends BaseTypeMapper<YearMonth> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, YearMonth parameterValue) throws SQLException {
		preparedStatement.setString(parameterIndex, parameterValue.toString());
	}

	public YearMonth getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getYearMonth(resultSet.getString(columnIndex));
	}

	public YearMonth getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getYearMonth(resultSet.getString(columnLabel));
	}

	public YearMonth getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getYearMonth(callableStatement.getString(parameterIndex));
	}

	public YearMonth getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getYearMonth(callableStatement.getString(parameterName));
	}

	public YearMonth getYearMonth(String yearMonth) {
		if (StringUtils.isEmpty(yearMonth)) {
			return null;
		}
		return YearMonth.parse(yearMonth);
	}

}
