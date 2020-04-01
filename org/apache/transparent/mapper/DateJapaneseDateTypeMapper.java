package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;

import org.apache.transparent.util.StringUtils;

public class DateJapaneseDateTypeMapper extends BaseTypeMapper<JapaneseDate> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, JapaneseDate parameterValue) throws SQLException {
		preparedStatement.setDate(parameterIndex, Date.valueOf(LocalDate.ofEpochDay(parameterValue.toEpochDay())));
	}

	public JapaneseDate getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getJapaneseDate(resultSet.getDate(columnIndex));
	}

	public JapaneseDate getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getJapaneseDate(resultSet.getDate(columnLabel));
	}

	public JapaneseDate getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getJapaneseDate(callableStatement.getDate(parameterIndex));
	}

	public JapaneseDate getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getJapaneseDate(callableStatement.getDate(parameterName));
	}

	public JapaneseDate getJapaneseDate(Date date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return JapaneseDate.from(date.toLocalDate());
	}

}
