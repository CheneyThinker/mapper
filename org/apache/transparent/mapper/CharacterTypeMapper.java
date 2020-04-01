package org.apache.transparent.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.transparent.util.StringUtils;

public class CharacterTypeMapper extends BaseTypeMapper<Character> {

	public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Character parameterValue) throws SQLException {
		preparedStatement.setString(parameterIndex, parameterValue.toString());
	}

	public Character getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getCharacter(resultSet.getString(columnIndex));
	}

	public Character getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getCharacter(resultSet.getString(columnLabel));
	}

	public Character getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getCharacter(callableStatement.getString(parameterIndex));
	}

	public Character getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getCharacter(callableStatement.getString(parameterName));
	}

	public Character getCharacter(String result) {
		if (StringUtils.isEmpty(result)) {
			return null;
		}
		return result.charAt(0);
	}

}
