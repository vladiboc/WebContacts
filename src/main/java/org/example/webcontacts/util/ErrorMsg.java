package org.example.webcontacts.util;
public class ErrorMsg {
  public static final String RED_START = "<font color='#F48'>";
  public static final String RED_FINISH = "</font>";
  public static final String ILLEGAL_NAME = RED_START +
      "Имя должно быть русскими буквами, первая заглавная!"+ RED_FINISH;
  public static final String ILLEGAL_SURNAME = RED_START +
      "Фамилия должна быть русскими буквами, первая заглавная!"+ RED_FINISH;
  public static final String ILLEGAL_EMAIL = RED_START +
      "Емейл задан некорректно!" + RED_FINISH;
  public static final String ILLEGAL_PHONE = RED_START +
      "Телефон должен начинаться с +7 и содержать дополнительно только 10 цифр!" + RED_FINISH;
  public static final String CONTACT_NOT_FOUND = "Не найден контакт с номером: ";

  private ErrorMsg() {}

}
