package org.apache.transparent.mapper;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.JDBCType;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLXML;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.transparent.util.StringUtils;

@SuppressWarnings("unchecked")
public final class TypeMapperRegistry {

	private static final ObjectTypeMapper OBJECT_TYPE_MAPPER = new ObjectTypeMapper();
	private static final Map<Class<?>, Object> CLAZZ_TYPE_MAPPER = new HashMap<Class<?>, Object>();
	private static final Map<JDBCType, Object> JDBC_TYPE_MAPPER = new HashMap<JDBCType, Object>();
	private static final Map<Class<?>, Map<JDBCType, Object>> CLAZZ_JDBC_TYPE_MAPPER = new HashMap<Class<?>, Map<JDBCType, Object>>();

	static {
		final BooleanTypeMapper booleanTypeMapper = new BooleanTypeMapper();
		register(boolean.class, booleanTypeMapper);
		register(Boolean.class, booleanTypeMapper);
		register(JDBCType.BIT, booleanTypeMapper);
		register(JDBCType.BOOLEAN, booleanTypeMapper);

		final ByteTypeMapper byteTypeMapper = new ByteTypeMapper();
		register(byte.class, byteTypeMapper);
		register(Byte.class, byteTypeMapper);
		register(JDBCType.TINYINT, byteTypeMapper);

		final ShortTypeMapper shortTypeMapper = new ShortTypeMapper();
		register(short.class, shortTypeMapper);
		register(Short.class, shortTypeMapper);
		register(JDBCType.SMALLINT, shortTypeMapper);

    final IntegerTypeMapper integerTypeMapper = new IntegerTypeMapper();
		register(int.class, integerTypeMapper);
		register(Integer.class, integerTypeMapper);
		register(JDBCType.INTEGER, integerTypeMapper);

		final LongTypeMapper longTypeMapper = new LongTypeMapper();
		register(long.class, longTypeMapper);
		register(Long.class, longTypeMapper);
		register(JDBCType.BIGINT, longTypeMapper);

		final FloatTypeMapper floatTypeMapper = new FloatTypeMapper();
		register(float.class, floatTypeMapper);
		register(Float.class, floatTypeMapper);
		register(JDBCType.FLOAT, floatTypeMapper);
		register(float.class, JDBCType.REAL, floatTypeMapper);
		register(Float.class, JDBCType.REAL, floatTypeMapper);

		final DoubleTypeMapper doubleTypeMapper = new DoubleTypeMapper();
		register(double.class, doubleTypeMapper);
		register(Double.class, doubleTypeMapper);
		register(JDBCType.DOUBLE, doubleTypeMapper);

		final BigDecimalTypeMapper bigDecimalTypeMapper = new BigDecimalTypeMapper();
		register(BigDecimal.class, bigDecimalTypeMapper);
		register(JDBCType.REAL, bigDecimalTypeMapper);
		register(JDBCType.DECIMAL, bigDecimalTypeMapper);
		register(JDBCType.NUMERIC, bigDecimalTypeMapper);

		final BigIntegerTypeMapper bigIntegerTypeMapper = new BigIntegerTypeMapper();
		register(BigInteger.class, bigIntegerTypeMapper);

		final StringTypeMapper stringTypeMapper = new StringTypeMapper();
		register(String.class, stringTypeMapper);
		register(JDBCType.VARCHAR, stringTypeMapper);
		register(String.class, JDBCType.CHAR, stringTypeMapper);
		register(String.class, JDBCType.LONGVARCHAR, stringTypeMapper);
		final SQLXMLStringTypeMapper sqlxmlStringTypeMapper = new SQLXMLStringTypeMapper();
		register(String.class, JDBCType.SQLXML, sqlxmlStringTypeMapper);
		final NStringTypeMapper nStringTypeMapper = new NStringTypeMapper();
		register(String.class, JDBCType.NCHAR, nStringTypeMapper);
		register(String.class, JDBCType.NVARCHAR, nStringTypeMapper);
		register(String.class, JDBCType.LONGNVARCHAR, nStringTypeMapper);
		final ClobStringTypeMapper clobStringTypeMapper = new ClobStringTypeMapper();
		register(String.class, JDBCType.CLOB, clobStringTypeMapper);
		final NClobStringTypeMapper nClobStringTypeMapper = new NClobStringTypeMapper();
		register(String.class, JDBCType.NCLOB, nClobStringTypeMapper);

		final DateTypeMapper dateTypeMapper = new DateTypeMapper();
		register(java.sql.Date.class, dateTypeMapper);
		register(JDBCType.DATE, dateTypeMapper);

		final TimeTypeMapper timeTypeMapper = new TimeTypeMapper();
		register(java.sql.Time.class, timeTypeMapper);
		register(JDBCType.TIME, timeTypeMapper);
		register(JDBCType.TIME_WITH_TIMEZONE, timeTypeMapper);

		final TimestampTypeMapper timestampTypeMapper = new TimestampTypeMapper();
		register(java.sql.Timestamp.class, timestampTypeMapper);
		register(JDBCType.TIMESTAMP, timestampTypeMapper);
		register(JDBCType.TIMESTAMP_WITH_TIMEZONE, timestampTypeMapper);

		//multiple start
		final ByteArrayTypeMapper byteArrayTypeMapper = new ByteArrayTypeMapper();
		register(byte[].class, byteArrayTypeMapper);
		register(byte[].class, JDBCType.BLOB, byteArrayTypeMapper);
		register(byte[].class, JDBCType.BINARY, byteArrayTypeMapper);
		register(byte[].class, JDBCType.VARBINARY, byteArrayTypeMapper);
		register(byte[].class, JDBCType.LONGVARBINARY, byteArrayTypeMapper);
		final BlobByteArrayTypeMapper blobByteArrayTypeMapper = new BlobByteArrayTypeMapper();
		register(byte[].class, JDBCType.BLOB, blobByteArrayTypeMapper);
    register(byte[].class, JDBCType.BINARY, blobByteArrayTypeMapper);
    register(byte[].class, JDBCType.VARBINARY, blobByteArrayTypeMapper);
    register(byte[].class, JDBCType.LONGVARBINARY, blobByteArrayTypeMapper);

    final ByteObjectArrayTypeMapper byteObjectArrayTypeMapper = new ByteObjectArrayTypeMapper();
		register(Byte[].class, byteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.BLOB, byteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.BINARY, byteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.VARBINARY, byteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.LONGVARBINARY, byteObjectArrayTypeMapper);
		final BlobByteObjectArrayTypeMapper blobByteObjectArrayTypeMapper = new BlobByteObjectArrayTypeMapper();
		register(Byte[].class, JDBCType.BLOB, blobByteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.BINARY, blobByteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.VARBINARY, blobByteObjectArrayTypeMapper);
		register(Byte[].class, JDBCType.LONGVARBINARY, blobByteObjectArrayTypeMapper);
		//multiple end

		final TimestampInstantTypeMapper timestampInstantTypeMapper = new TimestampInstantTypeMapper();
		register(Instant.class, timestampInstantTypeMapper);

		final LocalDateTimeTypeMapper localDateTimeTypeMapper = new LocalDateTimeTypeMapper();
		register(LocalDateTime.class, localDateTimeTypeMapper);
		final LocalDateTypeMapper localDateTypeMapper = new LocalDateTypeMapper();
		register(LocalDate.class, localDateTypeMapper);
		final LocalTimeTypeMapper localTimeTypeMapper = new LocalTimeTypeMapper();
		register(LocalTime.class, localTimeTypeMapper);
		final OffsetDateTimeTypeMapper offsetDateTimeTypeMapper = new OffsetDateTimeTypeMapper();
		register(OffsetDateTime.class, offsetDateTimeTypeMapper);
		final OffsetTimeTypeMapper offsetTimeTypeMapper = new OffsetTimeTypeMapper();
		register(OffsetTime.class, offsetTimeTypeMapper);
		final ZonedDateTimeTypeMapper zonedDateTimeTypeMapper = new ZonedDateTimeTypeMapper();
		register(ZonedDateTime.class, zonedDateTimeTypeMapper);
		/*
		final ObjectClazzTypeMapper localDateTimeTypeMapper = new ObjectClazzTypeMapper(LocalDateTime.class);
		register(LocalDateTime.class, localDateTimeTypeMapper);
		final ObjectClazzTypeMapper localDateTypeMapper = new ObjectClazzTypeMapper(LocalDate.class);
    register(LocalDate.class, localDateTypeMapper);
    final ObjectClazzTypeMapper localTimeTypeMapper = new ObjectClazzTypeMapper(LocalTime.class);
    register(LocalTime.class, localTimeTypeMapper);
    final ObjectClazzTypeMapper offsetDateTimeTypeMapper = new ObjectClazzTypeMapper(OffsetDateTime.class);
    register(OffsetDateTime.class, offsetDateTimeTypeMapper);
    final ObjectClazzTypeMapper offsetTimeTypeMapper = new ObjectClazzTypeMapper(OffsetTime.class);
    register(OffsetTime.class, offsetTimeTypeMapper);
    final ObjectClazzTypeMapper zonedDateTimeTypeMapper = new ObjectClazzTypeMapper(ZonedDateTime.class);
    register(ZonedDateTime.class, zonedDateTimeTypeMapper);
    */

    final IntMonthTypeMapper intMonthTypeMapper = new IntMonthTypeMapper();
    register(Month.class, intMonthTypeMapper);
    final IntYearTypeMapper intYearTypeMapper = new IntYearTypeMapper();
    register(Year.class, intYearTypeMapper);
    final StringYearMonthTypeMapper stringYearMonthTypeMapper = new StringYearMonthTypeMapper();
    register(YearMonth.class, stringYearMonthTypeMapper);
    final DateJapaneseDateTypeMapper dateJapaneseDateTypeMapper = new DateJapaneseDateTypeMapper();
    register(JapaneseDate.class, dateJapaneseDateTypeMapper);

    //multiple start
    final DateDateTypeMapper dateDateTypeMapper = new DateDateTypeMapper();
    register(java.util.Date.class, dateDateTypeMapper);
    register(java.util.Date.class, JDBCType.DATE, dateDateTypeMapper);

    final TimestampDateTypeMapper timestampDateTypeMapper = new TimestampDateTypeMapper();
    register(java.util.Date.class, timestampDateTypeMapper);
    register(java.util.Date.class, JDBCType.TIMESTAMP, timestampDateTypeMapper);
    register(java.util.Date.class, JDBCType.TIMESTAMP_WITH_TIMEZONE, timestampDateTypeMapper);

    final TimeDateTypeMapper timeDateTypeMapper = new TimeDateTypeMapper();
    register(java.util.Date.class, timeDateTypeMapper);
    register(java.util.Date.class, JDBCType.TIME, timeDateTypeMapper);
    register(java.util.Date.class, JDBCType.TIME_WITH_TIMEZONE, timeDateTypeMapper);
    //multiple end

    final CharacterTypeMapper characterTypeMapper = new CharacterTypeMapper();
    register(char.class, characterTypeMapper);
    register(Character.class, characterTypeMapper);
    register(JDBCType.CHAR, characterTypeMapper);

    final URLTypeMapper urlTypeMapper = new URLTypeMapper();
    register(URL.class, urlTypeMapper);
    register(JDBCType.DATALINK, urlTypeMapper);

    final RowIdTypeMapper rowIdTypeMapper = new RowIdTypeMapper();
    register(RowId.class, rowIdTypeMapper);
    register(JDBCType.ROWID, rowIdTypeMapper);

    final RefTypeMapper refTypeMapper = new RefTypeMapper();
    register(Ref.class, refTypeMapper);
    register(JDBCType.REF, refTypeMapper);

    final ArrayTypeMapper arrayTypeMapper = new ArrayTypeMapper();
    register(Array.class, arrayTypeMapper);
    register(JDBCType.ARRAY, arrayTypeMapper);

    final SQLXMLTypeMapper sqlxmlTypeMapper = new SQLXMLTypeMapper();
    register(SQLXML.class, sqlxmlTypeMapper);
    register(JDBCType.SQLXML, sqlxmlTypeMapper);

    final BlobTypeMapper blobTypeMapper = new BlobTypeMapper();
    register(Blob.class, blobTypeMapper);
    register(JDBCType.BLOB, blobTypeMapper);

    final ClobTypeMapper clobTypeMapper = new ClobTypeMapper();
    register(Clob.class, clobTypeMapper);
    register(JDBCType.CLOB, clobTypeMapper);

    final NClobTypeMapper nClobTypeMapper = new NClobTypeMapper();
    register(NClob.class, nClobTypeMapper);
    register(JDBCType.NCLOB, nClobTypeMapper);

    final BlobInputStreamTypeMapper blobInputStreamTypeMapper = new BlobInputStreamTypeMapper();
    register(InputStream.class, blobInputStreamTypeMapper);
    final AsciiStreamTypeMapper asciiStreamTypeMapper = new AsciiStreamTypeMapper();
    register(InputStream.class, JDBCType.LONGVARCHAR, asciiStreamTypeMapper);
    final BinaryStreamTypeMapper binaryStreamTypeMapper = new BinaryStreamTypeMapper();
    register(InputStream.class, JDBCType.LONGVARBINARY, binaryStreamTypeMapper);

    //multiple start
    register(JDBCType.BINARY, byteArrayTypeMapper);
		register(JDBCType.BINARY, blobByteArrayTypeMapper);
		register(JDBCType.BINARY, byteObjectArrayTypeMapper);
		register(JDBCType.BINARY, blobByteObjectArrayTypeMapper);
		register(JDBCType.BINARY, binaryStreamTypeMapper);

		register(JDBCType.VARBINARY, byteArrayTypeMapper);
		register(JDBCType.VARBINARY, blobByteArrayTypeMapper);
		register(JDBCType.VARBINARY, byteObjectArrayTypeMapper);
		register(JDBCType.VARBINARY, blobByteObjectArrayTypeMapper);
		register(JDBCType.VARBINARY, binaryStreamTypeMapper);

		register(JDBCType.LONGVARBINARY, byteArrayTypeMapper);
    register(JDBCType.LONGVARBINARY, blobByteArrayTypeMapper);
		register(JDBCType.LONGVARBINARY, byteObjectArrayTypeMapper);
		register(JDBCType.LONGVARBINARY, blobByteObjectArrayTypeMapper);
		register(JDBCType.LONGVARBINARY, binaryStreamTypeMapper);
		//multiple end

		final ClobReaderTypeMapper clobReaderTypeMapper = new ClobReaderTypeMapper();
    register(Reader.class, clobReaderTypeMapper);
    final CharacterStreamTypeMapper characterStreamTypeMapper = new CharacterStreamTypeMapper();
    register(Reader.class, JDBCType.LONGVARCHAR, characterStreamTypeMapper);
    final NCharacterStreamTypeMapper nCharacterStreamTypeMapper = new NCharacterStreamTypeMapper();
    register(Reader.class, JDBCType.NCHAR, nCharacterStreamTypeMapper);
    register(Reader.class, JDBCType.NVARCHAR, nCharacterStreamTypeMapper);
    register(Reader.class, JDBCType.LONGNVARCHAR, nCharacterStreamTypeMapper);

    //multiple start
    register(JDBCType.LONGVARCHAR, characterStreamTypeMapper);
    register(JDBCType.LONGVARCHAR, asciiStreamTypeMapper);
    //multiple end

    register(JDBCType.NCHAR, nCharacterStreamTypeMapper);
    register(JDBCType.NVARCHAR, nCharacterStreamTypeMapper);
    register(JDBCType.LONGNVARCHAR, nCharacterStreamTypeMapper);

    register(JDBCType.NULL, OBJECT_TYPE_MAPPER);
    register(JDBCType.OTHER, OBJECT_TYPE_MAPPER);
    register(JDBCType.STRUCT, OBJECT_TYPE_MAPPER);
    register(JDBCType.DISTINCT, OBJECT_TYPE_MAPPER);
    register(JDBCType.REF_CURSOR, OBJECT_TYPE_MAPPER);
    register(JDBCType.JAVA_OBJECT, OBJECT_TYPE_MAPPER);

    //register(Enum.class, new IntEnumTypeMapper<>());
		//register(Enum.class, new StringEnumTypeMapper<>());
	}

	public static void register(Class<?> clazz, TypeMapper<?> typeMapper) {
		Object clazzTypeMapper = CLAZZ_TYPE_MAPPER.get(clazz);
		if (StringUtils.isEmpty(clazzTypeMapper)) {
			CLAZZ_TYPE_MAPPER.put(clazz, typeMapper);
		} else {
			Set<TypeMapper<?>> set;
			if (clazzTypeMapper instanceof TypeMapper<?>) {
				set = new HashSet<TypeMapper<?>>();
				set.add((TypeMapper<?>) clazzTypeMapper);
				CLAZZ_TYPE_MAPPER.replace(clazz, set);
			} else {
				set = (Set<TypeMapper<?>>) clazzTypeMapper;
			}
			set.add(typeMapper);
		}
	}

	public static void register(JDBCType jdbcType, TypeMapper<?> typeMapper) {
		Object jdbcTypeMapper = JDBC_TYPE_MAPPER.get(jdbcType);
		if (StringUtils.isEmpty(jdbcTypeMapper)) {
			JDBC_TYPE_MAPPER.put(jdbcType, typeMapper);
		} else {
			Set<TypeMapper<?>> set;
			if (jdbcTypeMapper instanceof TypeMapper<?>) {
				set = new HashSet<TypeMapper<?>>();
				set.add((TypeMapper<?>) jdbcTypeMapper);
				JDBC_TYPE_MAPPER.replace(jdbcType, set);
			} else {
				set = (Set<TypeMapper<?>>) jdbcTypeMapper;
			}
			set.add(typeMapper);
		}
	}

	public static void register(Class<?> clazz, JDBCType jdbcType, TypeMapper<?> typeMapper) {
		Map<JDBCType, Object> clazzJdbcTypeMapper = CLAZZ_JDBC_TYPE_MAPPER.get(clazz);
		if (StringUtils.isEmpty(clazzJdbcTypeMapper)) {
			clazzJdbcTypeMapper = new HashMap<JDBCType, Object>();
			clazzJdbcTypeMapper.put(jdbcType, typeMapper);
			CLAZZ_JDBC_TYPE_MAPPER.put(clazz, clazzJdbcTypeMapper);
		} else {
			Object jdbcTypeMapper = clazzJdbcTypeMapper.get(jdbcType);
			if (StringUtils.isEmpty(jdbcTypeMapper)) {
				clazzJdbcTypeMapper.put(jdbcType, typeMapper);
			} else {
				Set<TypeMapper<?>> set;
				if (jdbcTypeMapper instanceof TypeMapper<?>) {
					set = new HashSet<TypeMapper<?>>();
					set.add((TypeMapper<?>) jdbcTypeMapper);
					clazzJdbcTypeMapper.replace(jdbcType, set);
				} else {
					set = (Set<TypeMapper<?>>) jdbcTypeMapper;
				}
				set.add(typeMapper);
			}
		}
	}

	public static TypeMapper<?> getTypeMapper(Class<?> clazz) {
		return getTypeMapper(CLAZZ_TYPE_MAPPER.get(clazz));
	}

	public static TypeMapper<?> getTypeMapper(JDBCType jdbcType) {
		return getTypeMapper(JDBC_TYPE_MAPPER.get(jdbcType));
	}

	public static TypeMapper<?> getTypeMapper(Class<?> clazz, JDBCType jdbcType) {
		Map<JDBCType, Object> clazzJdbcTypeMap = CLAZZ_JDBC_TYPE_MAPPER.get(clazz);
		if (StringUtils.isEmpty(clazzJdbcTypeMap)) {
			return OBJECT_TYPE_MAPPER;
		} else {
			return getTypeMapper(clazzJdbcTypeMap.get(jdbcType));
		}
	}

	private static TypeMapper<?> getTypeMapper(Object clazzJdbcTypeMapper) {
		if (StringUtils.isEmpty(clazzJdbcTypeMapper)) {
			return OBJECT_TYPE_MAPPER;
		} else {
			if (clazzJdbcTypeMapper instanceof TypeMapper<?>) {
				return (TypeMapper<?>) clazzJdbcTypeMapper;
			} else {
				Set<TypeMapper<?>> set = (Set<TypeMapper<?>>) clazzJdbcTypeMapper;
				return (TypeMapper<?>) set.toArray()[0];
			}
		}
	}

}
