package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NClobTypeMapper extends BaseTypeMapper<NClob> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, NClob parameterValue) throws SQLException {
		preparedStatement.setNClob(parameterIndex, parameterValue);
	}

	public NClob getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getNClob(columnIndex);
	}

	public NClob getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getNClob(columnLabel);
	}

	public NClob getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getNClob(parameterIndex);
	}

	public NClob getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getNClob(parameterName);
	}

}
