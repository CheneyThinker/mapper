package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

public class RowIdTypeMapper extends BaseTypeMapper<RowId> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, RowId parameterValue) throws SQLException {
		preparedStatement.setRowId(parameterIndex, parameterValue);
	}

	public RowId getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return resultSet.getRowId(columnIndex);
	}

	public RowId getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return resultSet.getRowId(columnLabel);
	}

	public RowId getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return callableStatement.getRowId(parameterIndex);
	}

	public RowId getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return callableStatement.getRowId(parameterName);
	}

}
