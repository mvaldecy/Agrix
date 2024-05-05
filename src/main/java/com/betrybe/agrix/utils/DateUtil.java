package com.betrybe.agrix.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DateUtil.
 */
public abstract class DateUtil {

  /**
   * .
   */
  public static LocalDate conversor(String date) {
    // date format reference: https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
    // convertString to CharSeuence reference: https://stackoverflow.com/questions/1391970/how-to-convert-a-string-to-charsequence
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    CharSequence csDate = date;
    LocalDate dateResponse = LocalDate.parse(csDate, formatter);
    return dateResponse;
  }
}
