package net.bbenarbia.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * The Class DateUtil is an utility class that provides functions for
 * {@link LocalDateTime} and {@link XMLGregorianCalendar}.
 */
public class DateUtil {

	public static String datePattern = "dd/MM/yyyy";
	public static String datePatternWithHour = "dd/MM/yyyy HH:mm";
	public static final String datePatternYyyyMmDd = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YYYMMDD = "yyyyMMdd";

	public static LocalDateTime getCurrentDate() {
		return truncateDate(getCurrentDateTime());
	}

	public static LocalDateTime getCurrentDateTime() {
		return new LocalDateTime();
	}

	public static LocalDateTime truncateDate(final LocalDateTime date) {
		final int year = date.getYear(), month = date.getMonthOfYear(), day = date
				.getDayOfMonth();

		return new LocalDateTime(year, month, day, 0, 0, 0, 0);
	}

	public static boolean areEqual(LocalDateTime date1, LocalDateTime date2) {
		return date1.withTime(0, 0, 0, 0).isEqual(date2.withTime(0, 0, 0, 0));
	}

	public static boolean areEquals(final LocalDateTime first,
			final LocalDateTime second) {
		return first.compareTo(second) == 0;
	}

	public static LocalDateTime toLocalDateTime(XMLGregorianCalendar gregCal) {
		return new DateTime(gregCal.toGregorianCalendar().getTime())
				.toLocalDateTime();
	}

	public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDateTime date)
			throws DatatypeConfigurationException {
		if (date == null) {
			return null;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date.toDateTime().toDate());
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	}

	public static LocalDateTime getDateWithoutTime(final LocalDateTime date) {
		return date.withTime(0, 0, 0, 0);
	}

	public static Date convertDateToGMTDate(LocalDateTime date) {
		return convertDateToGMTDate(date, true);
	}

	public static Date convertDateToGMTDate(LocalDateTime date, boolean offset) {
		long dateInMiliseconds = date.toDateTime().getMillis();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(dateInMiliseconds);
		if (offset) {
			dateInMiliseconds = dateInMiliseconds
					- calendar.get(Calendar.ZONE_OFFSET)
					- calendar.get(Calendar.DST_OFFSET);
		}
		Date gmtDate = new Date(dateInMiliseconds);
		return gmtDate;
	}

	public static String convertDateToGMTString(LocalDateTime date,
			String format) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		return formatter.print(date);
	}

	public static int daysBetween(LocalDateTime startDate, LocalDateTime endDate) {
		return Days.daysBetween(startDate, endDate).getDays();
	}

	public static LocalDateTime toLocalDateTime(Date date) {
		return new DateTime(date).toLocalDateTime();
	}

	public static LocalDateTime toLocalDateTime(String dateTimeString,
			String dateTimePattern) {
		DateTimeFormatter formatter = DateTimeFormat
				.forPattern(dateTimePattern);
		return formatter.parseDateTime(dateTimeString)
				.withZone(DateTimeZone.getDefault()).toLocalDateTime();
	}

	public static String formatDate(LocalDateTime localDateTime, String format) {
		return new SimpleDateFormat(format).format(localDateTime.toDateTime()
				.toDate());
	}

	public static String formatDate(LocalDateTime localDateTime, String format,
			Locale locale) {
		return new SimpleDateFormat(format, locale).format(localDateTime
				.toDateTime().toDate());
	}

	public static XMLGregorianCalendar forceLocalDateTimeToUTCXMLGregorianCalendar(
			final LocalDateTime date) throws DatatypeConfigurationException {

		final GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date.toDateTime(DateTimeZone.UTC).toDate());

		return convertGregorianCalendarToUTCXMLGregorianCalendar(cal);
	}

	public static XMLGregorianCalendar convertLocalDateTimeToUTCXMLGregorianCalendar(
			final LocalDateTime date) throws DatatypeConfigurationException {
		final GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date.toDateTime().toDate());

		return convertGregorianCalendarToUTCXMLGregorianCalendar(cal);
	}

	private static XMLGregorianCalendar convertGregorianCalendarToUTCXMLGregorianCalendar(
			final GregorianCalendar gregorianCalendar)
			throws DatatypeConfigurationException {
		final DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		final XMLGregorianCalendar dateXMLGreogorian = datatypeFactory
				.newXMLGregorianCalendar(gregorianCalendar);

		final XMLGregorianCalendar convertUTC = dateXMLGreogorian.normalize();
		return convertUTC;
	}

	public static LocalDateTime getTheDateOfTheLastDayOfthePreviousMonth() {
		// date du jour
		LocalDateTime now = new LocalDateTime();

		LocalDateTime firstDayOfMonth = now.dayOfMonth().withMinimumValue();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(firstDayOfMonth.toDateTime().getMillis());
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		LocalDateTime ld = new LocalDateTime(calendar.getTime());
		LocalDateTime lastDayOfThePreviousMonthAtMidNight = new LocalDateTime(
				ld.getYear(), ld.getMonthOfYear(), ld.getDayOfMonth(), 23, 59,
				59);
		return lastDayOfThePreviousMonthAtMidNight;
	}

	public static LocalDateTime getTheDateOfTheNextMonday(LocalDateTime date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.toDateTime().getMillis());
		// On calcule le nombre de jour entre la date et le lundi suivant
		int aAjouter = 8 - date.getDayOfWeek();
		calendar.add(Calendar.DAY_OF_YEAR, aAjouter);
		LocalDateTime nextMonday = new LocalDateTime(calendar.getTime());

		return nextMonday;
	}

	public static String formatDateMidnight(DateMidnight date, String format) {
		return new SimpleDateFormat(format).format(date.toDateTime().toDate());

	}

}
