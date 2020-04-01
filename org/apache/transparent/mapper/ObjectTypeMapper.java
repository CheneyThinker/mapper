package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectTypeMapper extends BaseTypeMapper<Object> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Object parameterValue) throws SQLException {
		preparedStatement.setObject(parameterIndex, parameterValue);
	}

	public Object getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getObject(columnIndex);
	}

	public Object getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getObject(columnLabel);
	}

	public Object getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getObject(parameterIndex);
	}

	public Object getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getObject(parameterName);
	}

}
