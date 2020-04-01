package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;

public class IntMonthTypeMapper extends BaseTypeMapper<Month> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Month parameterValue) throws SQLException {
		preparedStatement.setInt(parameterIndex, parameterValue.getValue());
	}

	public Month getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.wasNull() ? null : getMonth(resultSet.getInt(columnIndex));
	}

	public Month getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.wasNull() ? null : getMonth(resultSet.getInt(columnLabel));
	}

	public Month getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.wasNull() ? null : getMonth(callableStatement.getInt(parameterIndex));
	}

	public Month getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.wasNull() ? null : getMonth(callableStatement.getInt(parameterName));
	}

	public Month getMonth(Integer month) {
		if (month == 0) {
			return null;
		}
		return Month.of(month);
	}

}
