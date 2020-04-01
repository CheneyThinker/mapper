package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefTypeMapper extends BaseTypeMapper<Ref> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Ref parameterValue) throws SQLException {
		preparedStatement.setRef(parameterIndex, parameterValue);
	}

	public Ref getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getRef(columnIndex);
	}

	public Ref getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getRef(columnLabel);
	}

	public Ref getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getRef(parameterIndex);
	}

	public Ref getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getRef(parameterName);
	}

}
