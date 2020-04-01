package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectClazzTypeMapper extends BaseTypeMapper<Object> {

	private Class<?> clazz;

	public ObjectClazzTypeMapper(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Object parameterValue) throws SQLException {
		preparedStatement.setObject(parameterIndex, parameterValue);
	}

	public Object getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getObject(columnIndex, clazz);
	}

	public Object getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getObject(columnLabel, clazz);
	}

	public Object getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getObject(parameterIndex, clazz);
	}

	public Object getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getObject(parameterName, clazz);
	}

}
