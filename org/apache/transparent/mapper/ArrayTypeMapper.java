package org.apache.transparent.mapper;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayTypeMapper extends BaseTypeMapper<Array> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Array parameterValue) throws SQLException {
		preparedStatement.setArray(parameterIndex, parameterValue);
	}

	public Array getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getArray(columnIndex);
	}

	public Array getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getArray(columnLabel);
	}

	public Array getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getArray(parameterIndex);
	}

	public Array getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getArray(parameterName);
	}

}
