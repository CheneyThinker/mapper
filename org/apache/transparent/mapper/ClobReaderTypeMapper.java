package org.apache.transparent.mapper;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class ClobReaderTypeMapper extends BaseTypeMapper<Reader> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Reader parameterValue) throws SQLException {
		preparedStatement.setClob(parameterIndex, parameterValue);
	}

	public Reader getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getReader(resultSet.getClob(columnIndex));
	}

	public Reader getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getReader(resultSet.getClob(columnLabel));
	}

	public Reader getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getReader(callableStatement.getClob(parameterIndex));
	}

	public Reader getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getReader(callableStatement.getClob(parameterName));
	}

	public Reader getReader(Clob clob) throws SQLException {
		if (StringUtils.isEmpty(clob)) {
			return null;
		}
		return clob.getCharacterStream();
	}

}
