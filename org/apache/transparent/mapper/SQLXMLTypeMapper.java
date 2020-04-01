package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

public class SQLXMLTypeMapper extends BaseTypeMapper<SQLXML> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, SQLXML parameterValue) throws SQLException {
		preparedStatement.setSQLXML(parameterIndex, parameterValue);
	}

	public SQLXML getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getSQLXML(columnIndex);
	}

	public SQLXML getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getSQLXML(columnLabel);
	}

	public SQLXML getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getSQLXML(parameterIndex);
	}

	public SQLXML getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getSQLXML(parameterName);
	}

}
