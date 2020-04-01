package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

import org.apache.transparent.util.StringUtils;

public class SQLXMLStringTypeMapper extends BaseTypeMapper<String> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
		SQLXML sqlxml = preparedStatement.getConnection().createSQLXML();
		try {
			sqlxml.setString(parameterValue);
			preparedStatement.setSQLXML(parameterIndex, sqlxml);
		} finally {
			sqlxml.free();
		}
	}

	public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getString(resultSet.getSQLXML(columnIndex));
	}

	public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getString(resultSet.getSQLXML(columnLabel));
	}

	public String getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getString(callableStatement.getSQLXML(parameterIndex));
	}

	public String getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getString(callableStatement.getSQLXML(parameterName));
	}

	public String getString(SQLXML sqlxml) throws SQLException {
		if (StringUtils.isEmpty(sqlxml)) {
			return null;
		}
		try {
			return sqlxml.getString();
		} finally {
			sqlxml.free();
		}
	}

}
