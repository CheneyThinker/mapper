package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

public class IntYearTypeMapper extends BaseTypeMapper<Year> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Year parameterValue) throws SQLException {
		preparedStatement.setInt(parameterIndex, parameterValue.getValue());
	}

	public Year getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : getYear(resultSet.getInt(columnIndex));
	}

	public Year getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : getYear(resultSet.getInt(columnLabel));
	}

	public Year getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : getYear(callableStatement.getInt(parameterIndex));
	}

	public Year getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : getYear(callableStatement.getInt(parameterName));
	}

	public Year getYear(Integer year) {
		if (year == 0) {
			return null;
		}
		return Year.of(year);
	}

}
