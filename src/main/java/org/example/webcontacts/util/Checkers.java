package org.example.webcontacts.util;

import org.example.webcontacts.data.Contact;
import org.example.webcontacts.exception.IllegalFieldException;
import org.example.webcontacts.exception.WebContactsException;

public class Checkers {
  private static final String NAME_REGEX = "^[А-ЯЁ][а-яё]+((-[А-ЯЁ])?[а-яё]+)?$";
  private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  private static final String PHONE_REGEX = "^[+]7[0-9]{10}$";
  private static final String HTML_LINE_SEPARATOR = "<br>";

  public static void checkHtmlInputFields(Contact contact) throws IllegalFieldException {
    StringBuilder htmlErrorMsgBuilder = new StringBuilder();
    addHtmlErrorMsg(htmlErrorMsgBuilder, contact.getFirstName(), Checkers::checkName);
    addHtmlErrorMsg(htmlErrorMsgBuilder, contact.getLastName(), Checkers::checkSurname);
    addHtmlErrorMsg(htmlErrorMsgBuilder, contact.getEmail(), Checkers::checkEmail);
    addHtmlErrorMsg(htmlErrorMsgBuilder, contact.getPhone(), Checkers::checkPhone);
    if (!htmlErrorMsgBuilder.isEmpty()) {
      throw new IllegalFieldException(htmlErrorMsgBuilder.toString());
    }
  }

  public static void checkName(String name) throws IllegalFieldException {
    checkStringField(name, NAME_REGEX, ErrorMsg.ILLEGAL_NAME);
  }

  public static void checkSurname(String surname) throws IllegalFieldException {
    checkStringField(surname, NAME_REGEX, ErrorMsg.ILLEGAL_SURNAME);
  }

  public static void checkEmail(String email) throws IllegalFieldException {
    checkStringField(email, EMAIL_REGEX, ErrorMsg.ILLEGAL_EMAIL);
  }

  public static void checkPhone(String phone) throws IllegalFieldException {
    checkStringField(phone, PHONE_REGEX, ErrorMsg.ILLEGAL_PHONE);
  }

  private static <T> void addHtmlErrorMsg(StringBuilder builder, T object, Checker<T> checker) {
    try {
      checker.check(object);
    } catch (WebContactsException e) {
      builder.append(e.getMessage()).append(HTML_LINE_SEPARATOR);
    }
  }

  private static void checkStringField(String field, String regex, String errorMsg) throws IllegalFieldException {
    if (!field.matches(regex)) {
      throw new IllegalFieldException(errorMsg);
    }
  }

  private Checkers() {}

  @FunctionalInterface
  private interface Checker<T> {
    void check(T object) throws WebContactsException;
  }

}
