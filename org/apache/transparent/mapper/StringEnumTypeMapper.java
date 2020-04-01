package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class StringEnumTypeMapper<E extends Enum<E>> extends BaseTypeMapper<E> {

	private Class<E> enumType;

	public void setEnumType(Class<E> enumType) {
		this.enumType = enumType;
	}

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, E parameterValue) throws SQLException {
		preparedStatement.setString(parameterIndex, parameterValue.name());
	}

	public E getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getEnum(resultSet.getString(columnIndex));
	}

	public E getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getEnum(resultSet.getString(columnLabel));
	}

	public E getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getEnum(callableStatement.getString(parameterIndex));
	}

	public E getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getEnum(callableStatement.getString(parameterName));
	}

	public E getEnum(String result) {
		if (StringUtils.isEmpty(result)) {
			return null;
		}
		return Enum.valueOf(enumType, result);
	}

}
