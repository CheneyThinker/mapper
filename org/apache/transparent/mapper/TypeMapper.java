package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TypeMapper<T> {

	void setParameter(PreparedStatement preparedStatement, int parameterIndex, T parameterValue, JDBCType jdbcType) throws SQLException;
	T getResult(ResultSet resultSet, int columnIndex) throws SQLException;
	T getResult(ResultSet resultSet, String columnLabel) throws SQLException;
	T getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException;
	T getResult(CallableStatement callableStatement, String parameterName) throws SQLException;

}
