package org.apache.transparent.mapper;

import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class NClobStringTypeMapper extends BaseTypeMapper<String> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
		StringReader reader = new StringReader(parameterValue);
		//preparedStatement.setCharacterStream(parameterIndex, reader, parameterValue.length());
		preparedStatement.setNClob(parameterIndex, reader);
	}

	public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getString(resultSet.getNClob(columnIndex));
	}

	public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getString(resultSet.getNClob(columnLabel));
	}

	public String getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getString(callableStatement.getNClob(parameterIndex));
	}

	public String getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getString(callableStatement.getNClob(parameterName));
	}

	public String getString(NClob nClob) throws SQLException {
		if (StringUtils.isEmpty(nClob)) {
			return null;
		}
		return nClob.getSubString(1, (int) nClob.length());
	}

}
