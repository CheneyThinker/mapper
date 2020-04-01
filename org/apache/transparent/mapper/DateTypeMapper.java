package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateTypeMapper extends BaseTypeMapper<Date> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Date parameterValue) throws SQLException {
		preparedStatement.setDate(parameterIndex, parameterValue);
	}

	public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getDate(columnIndex);
	}

	public Date getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getDate(columnLabel);
	}

	public Date getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getDate(parameterIndex);
	}

	public Date getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getDate(parameterName);
	}

}
