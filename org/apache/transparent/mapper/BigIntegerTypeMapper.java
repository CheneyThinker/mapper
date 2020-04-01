package org.apache.transparent.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class BigIntegerTypeMapper extends BaseTypeMapper<BigInteger> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, BigInteger parameterValue) throws SQLException {
		preparedStatement.setBigDecimal(parameterIndex, new BigDecimal(parameterValue));
	}

	public BigInteger getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getBigInteger(resultSet.getBigDecimal(columnIndex));
	}

	public BigInteger getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getBigInteger(resultSet.getBigDecimal(columnLabel));
	}

	public BigInteger getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getBigInteger(callableStatement.getBigDecimal(parameterIndex));
	}

	public BigInteger getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getBigInteger(callableStatement.getBigDecimal(parameterName));
	}

	public BigInteger getBigInteger(BigDecimal bigDecimal) {
		if (StringUtils.isEmpty(bigDecimal)) {
			return null;
		}
		return bigDecimal.toBigInteger();
	}

}
