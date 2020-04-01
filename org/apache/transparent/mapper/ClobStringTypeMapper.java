package org.apache.transparent.mapper;

import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class ClobStringTypeMapper extends BaseTypeMapper<String> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
		StringReader reader = new StringReader(parameterValue);
		//preparedStatement.setCharacterStream(parameterIndex, reader, parameterValue.length());
		preparedStatement.setClob(parameterIndex, reader);
	}

	public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getString(resultSet.getClob(columnIndex));
	}

	public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getString(resultSet.getClob(columnLabel));
	}

	public String getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getString(callableStatement.getClob(parameterIndex));
	}

	public String getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getString(callableStatement.getClob(parameterName));
	}

	public String getString(Clob clob) throws SQLException {
		if (StringUtils.isEmpty(clob)) {
			return null;
		}
		return clob.getSubString(1, (int) clob.length());
	}

}
