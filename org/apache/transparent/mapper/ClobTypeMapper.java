package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobTypeMapper extends BaseTypeMapper<Clob> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Clob parameterValue) throws SQLException {
		preparedStatement.setClob(parameterIndex, parameterValue);
	}

	public Clob getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getClob(columnIndex);
	}

	public Clob getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getClob(columnLabel);
	}

	public Clob getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getClob(parameterIndex);
	}

	public Clob getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getClob(parameterName);
	}

}
