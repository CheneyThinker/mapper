package org.apache.transparent.mapper;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BigDecimalTypeMapper extends BaseTypeMapper<BigDecimal> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, BigDecimal parameterValue) throws SQLException {
		preparedStatement.setBigDecimal(parameterIndex, parameterValue);
	}

	public BigDecimal getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getBigDecimal(columnIndex);
	}

	public BigDecimal getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getBigDecimal(columnLabel);
	}

	public BigDecimal getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getBigDecimal(parameterIndex);
	}

	public BigDecimal getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getBigDecimal(parameterName);
	}

}
