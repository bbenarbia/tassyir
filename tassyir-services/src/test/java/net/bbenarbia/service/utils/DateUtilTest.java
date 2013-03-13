package net.bbenarbia.service.utils;


import net.bbenarbia.utils.DateUtil;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testAreEqualsWithEquality() {

        // 1 - Arrange:
        final LocalDateTime first = new LocalDateTime(2012, 2, 3, 12, 0, 0);
        final LocalDateTime second = new LocalDateTime(2012, 2, 3, 12, 0, 0);

        // 2 - Act:
        final boolean result = DateUtil.areEquals(first, second);

        // 3 - Assert:
        Assert.assertTrue(result);
    }
//
//    @Test
//    public void testAreEqualsWithFirstDateLowerThanSecond() {
//
//        // 1 - Arrange:
//        final LocalDateTime first = new LocalDateTime(2011, 2, 3, 12, 0, 0);
//        final LocalDateTime second = new LocalDateTime(2012, 2, 3, 12, 0, 0);
//
//        // 2 - Act:
//        final boolean result = DateUtil.areEquals(first, second);
//
//        // 3 - Assert:
//        assertFalse(result);
//    }
//
//   
//    @Test
//    public void testAreEqualsWithSecondDateLowerThanFirst() {
//
//        // 1 - Arrange:
//        final LocalDateTime first = new LocalDateTime(2011, 2, 3, 12, 0, 0);
//        final LocalDateTime second = new LocalDateTime(2010, 2, 3, 12, 0, 0);
//
//        // 2 - Act:
//        final boolean result = DateUtil.areEquals(first, second);
//
//        // 3 - Assert:
//        assertFalse(result);
//    }
//
//    
//    @Test
//    public void testGetDateWithoutTime() {
//
//        // 1 - Arrange:
//        final LocalDateTime date = new LocalDateTime(2012, 2, 2, 12, 12, 23, 21);
//
//        // 2 - Act:
//        final LocalDateTime updatedDate = DateUtil.getDateWithoutTime(date);
//
//        // 3 - Assert:
//        assertEquals(0, updatedDate.getMillisOfSecond());
//        assertEquals(0, updatedDate.getSecondOfMinute());
//        assertEquals(0, updatedDate.getMinuteOfHour());
//        assertEquals(0, updatedDate.getHourOfDay());
//    }
//
//    // DateUtil.areEqual
//
//    @Test
//    public void equalityWithSameDateTime() {
//        LocalDateTime now = new LocalDateTime();
//        assertTrue(DateUtil.areEqual(now, now));
//    }
//
//    @Test
//    public void equalityWithDifferentTime() {
//        LocalDateTime now = new LocalDateTime(2000, 2, 12, 12, 30);
//        LocalDateTime later = now.plusHours(1);
//        assertFalse(now.equals(later));
//        assertTrue(DateUtil.areEqual(now, later));
//    }
//
//    @Test
//    public void equalityWithDifferentDate() {
//        LocalDateTime now = new LocalDateTime();
//        LocalDateTime tomorrow = now.plusDays(1);
//        assertFalse(now.equals(tomorrow));
//        assertFalse(DateUtil.areEqual(now, tomorrow));
//    }
//
//    @Test
//    public void equalityWithNullParameters() {
//        try {
//            DateUtil.areEqual(null,  new LocalDateTime());
//            fail("Should throw null pointer exception.");
//        } catch (NullPointerException e) {
//        }
//        try {
//            DateUtil.areEqual( new LocalDateTime(), null);
//            fail("Should throw null pointer exception.");
//        } catch (NullPointerException e) {
//        }
//        try {
//            DateUtil.areEqual(null, null);
//            fail("Should throw null pointer exception.");
//        } catch (NullPointerException e) {
//        }
//    }
//
//    // DateUtil.daysBetween
//
//    @Test
//    public void diffBetweenSameDateTime() {
//        LocalDateTime now = new LocalDateTime();
//        assertEquals(0, DateUtil.daysBetween(now, now));
//    }
//
//    @Test
//    public void diffBetweenSameDate() {
//        LocalDateTime now = new LocalDateTime();
//        LocalDateTime later = now.plusHours(1);
//        assertEquals(0, DateUtil.daysBetween(now, later));
//    }
//
//    @Test
//    public void diffBetweenTodayAndTomorrow() {
//        LocalDateTime now = new LocalDateTime();
//        LocalDateTime tomorrow = now.plusDays(1);
//        assertEquals(1, DateUtil.daysBetween(now, tomorrow));
//    }
//
//    @Test
//    public void diffBetweenTomorrowAndToday() {
//        LocalDateTime now = new LocalDateTime();
//        LocalDateTime tomorrow = now.plusDays(1);
//        assertEquals(-1, DateUtil.daysBetween(tomorrow, now));
//    }
//
//    @Test
//    public void diffBetweenTodayAndTomorrowMinusOneSecond() {
//        LocalDateTime now = new LocalDateTime();
//        LocalDateTime tomorrow = now.plusDays(1).minusSeconds(1);
//        assertEquals(0, DateUtil.daysBetween(now, tomorrow));
//    }
//
//    @Test
//    public void diffAtMidnight() {
//        LocalDateTime now = new LocalDateTime().withTime(0, 0, 0, 0);
//        LocalDateTime yestarday = now.minusSeconds(1);
//        assertEquals(0, DateUtil.daysBetween(yestarday, now));
//    }
//
//    @Test
//    public void diffForNewYear() {
//        LocalDateTime newYear = new LocalDateTime(2011, 1, 1, 0, 0, 0);
//        LocalDateTime newYearEve = newYear.minusSeconds(1);
//        assertEquals(0, DateUtil.daysBetween(newYear, newYearEve));
//    }
//
//    @Test
//    public void getNextMonday() {
//        LocalDateTime date1 = new LocalDateTime(2011, 12, 13, 0, 0, 0);
//        LocalDateTime date2 = new LocalDateTime(2011, 12, 30, 0, 0, 0);
//        LocalDateTime date3 = new LocalDateTime(2012, 12, 24, 10, 0, 0);
//        LocalDateTime date4 = new LocalDateTime(2012, 12, 31, 0, 0, 0);
//        LocalDateTime date5 = new LocalDateTime(2013, 1, 1, 0, 0, 0);
//        LocalDateTime date6 = new LocalDateTime(2013, 12, 31, 0, 0, 0);
//        LocalDateTime date7 = new LocalDateTime(2017, 12, 31, 0, 0, 0);
//        LocalDateTime date8 = new LocalDateTime(2013, 02, 28, 0, 0, 0);
//        assertEquals(new LocalDateTime(2011, 12, 19, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date1));
//        assertEquals(new LocalDateTime(2012, 1, 2, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date2));
//        assertEquals(new LocalDateTime(2012, 12, 31, 10, 0, 0), DateUtil.getTheDateOfTheNextMonday(date3));
//        assertEquals(new LocalDateTime(2013, 1, 7, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date4));
//        assertEquals(new LocalDateTime(2013, 1, 7, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date5));
//        assertEquals(new LocalDateTime(2014, 1, 6, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date6));
//        assertEquals(new LocalDateTime(2018, 1, 1, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date7));
//        assertEquals(new LocalDateTime(2013, 3, 4, 0, 0, 0), DateUtil.getTheDateOfTheNextMonday(date8));
//    }
//
//    @Test
//    public void conversions() throws DatatypeConfigurationException {
//        LocalDateTime now = new LocalDateTime();
//        XMLGregorianCalendar nowXML = DateUtil.toXMLGregorianCalendar(now);
//        assertEquals(now, DateUtil.toLocalDateTime(nowXML));
//    }
//
//    @Test
//    public void conversionFromNull() throws DatatypeConfigurationException {
//        LocalDateTime now = null;
//        assertEquals(null, DateUtil.toXMLGregorianCalendar(now));
//    }
}
