package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ObjectMapTypeMapper extends BaseTypeMapper<Object> {

	private Map<String, Class<?>> map;

	public void setMap(Map<String, Class<?>> map) {
		this.map = map;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Object parameterValue) throws SQLException {
		preparedStatement.setObject(parameterIndex, parameterValue);
	}

	public Object getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getObject(columnIndex, map);
	}

	public Object getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getObject(columnLabel, map);
	}

	public Object getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getObject(parameterIndex, map);
	}

	public Object getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getObject(parameterName, map);
	}

}
