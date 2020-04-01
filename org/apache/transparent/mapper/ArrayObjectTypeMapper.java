package org.apache.transparent.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.transparent.util.StringUtils;

public class ArrayObjectTypeMapper extends BaseTypeMapper<Object> {

	private static final Map<Class<?>, String> STANDARD_MAPPING;

	static {
		STANDARD_MAPPING = new ConcurrentHashMap<Class<?>, String>();
		STANDARD_MAPPING.put(BigDecimal.class, JDBCType.NUMERIC.name());
    STANDARD_MAPPING.put(BigInteger.class, JDBCType.BIGINT.name());
    STANDARD_MAPPING.put(boolean.class, JDBCType.BOOLEAN.name());
    STANDARD_MAPPING.put(Boolean.class, JDBCType.BOOLEAN.name());
    STANDARD_MAPPING.put(byte[].class, JDBCType.VARBINARY.name());
    STANDARD_MAPPING.put(byte.class, JDBCType.TINYINT.name());
    STANDARD_MAPPING.put(Byte.class, JDBCType.TINYINT.name());
    STANDARD_MAPPING.put(Calendar.class, JDBCType.TIMESTAMP.name());
    STANDARD_MAPPING.put(java.sql.Date.class, JDBCType.DATE.name());
    STANDARD_MAPPING.put(java.util.Date.class, JDBCType.TIMESTAMP.name());
    STANDARD_MAPPING.put(double.class, JDBCType.DOUBLE.name());
    STANDARD_MAPPING.put(Double.class, JDBCType.DOUBLE.name());
    STANDARD_MAPPING.put(float.class, JDBCType.REAL.name());
    STANDARD_MAPPING.put(Float.class, JDBCType.REAL.name());
    STANDARD_MAPPING.put(int.class, JDBCType.INTEGER.name());
    STANDARD_MAPPING.put(Integer.class, JDBCType.INTEGER.name());
    STANDARD_MAPPING.put(LocalDate.class, JDBCType.DATE.name());
    STANDARD_MAPPING.put(LocalDateTime.class, JDBCType.TIMESTAMP.name());
    STANDARD_MAPPING.put(LocalTime.class, JDBCType.TIME.name());
    STANDARD_MAPPING.put(long.class, JDBCType.BIGINT.name());
    STANDARD_MAPPING.put(Long.class, JDBCType.BIGINT.name());
    STANDARD_MAPPING.put(OffsetDateTime.class, JDBCType.TIMESTAMP_WITH_TIMEZONE.name());
    STANDARD_MAPPING.put(OffsetTime.class, JDBCType.TIME_WITH_TIMEZONE.name());
    STANDARD_MAPPING.put(Short.class, JDBCType.SMALLINT.name());
    STANDARD_MAPPING.put(String.class, JDBCType.VARCHAR.name());
    STANDARD_MAPPING.put(Time.class, JDBCType.TIME.name());
    STANDARD_MAPPING.put(Timestamp.class, JDBCType.TIMESTAMP.name());
    STANDARD_MAPPING.put(URL.class, JDBCType.DATALINK.name());
  }

  public void setParameter(PreparedStatement preparedStatement, int parameterIndex, Object parameterValue) throws SQLException {
  	if (parameterValue.getClass().isArray()) {
  		Array array = null;
    	try {
  			Class<?> componentType = parameterValue.getClass().getComponentType();
  			array = preparedStatement.getConnection().createArrayOf(STANDARD_MAPPING.getOrDefault(componentType, JDBCType.JAVA_OBJECT.name()), (Object[]) parameterValue);
  			preparedStatement.setArray(parameterIndex, array);
  		} finally {
  			array.free();
  		}
  	}
	}

	public Object getResult(ResultSet resultSet, int columnIndex) throws SQLException {
		return getObject(resultSet.getArray(columnIndex));
	}

	public Object getResult(ResultSet resultSet, String columnLabel) throws SQLException {
		return getObject(resultSet.getArray(columnLabel));
	}

	public Object getResult(CallableStatement callableStatement, int parameterIndex) throws SQLException {
		return getObject(callableStatement.getArray(parameterIndex));
	}

	public Object getResult(CallableStatement callableStatement, String parameterName) throws SQLException {
		return getObject(callableStatement.getArray(parameterName));
	}

	public Object getObject(Array array) throws SQLException {
		if (StringUtils.isEmpty(array)) {
			return null;
    }
		Object result = array.getArray();
		array.free();
		return result;
  }

}
