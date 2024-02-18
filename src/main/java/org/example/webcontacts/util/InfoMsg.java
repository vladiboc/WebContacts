package org.example.webcontacts.util;

public class InfoMsg {
  public static final String CREATION_FORM = "Создание контакта";
  public static final String EDITING_FORM = "Редактирование контакта";
  public static final String FILL = "Заполните ";
  public static final String EDIT = "Отредактируйте ";
  public static final String ALL_FIELDS = "все поля формы ";
  public static final String PRESS_READY = "и нажмите зелёную кнопку 'Готово'.<br>";
  public static final String RULES =
      "Правила заполнения полей формы:<br>" +
          "&emsp;- имя и фамилия - русскими буквами, только первая заглавная<br>" +
          "&emsp;- емейл - по правилам написания емейлов<br>" +
          "&emsp;- телефон - начинается на +7, далее десять цифр";
  public static final String CREATE_CONTACT = FILL + ALL_FIELDS + PRESS_READY + RULES;
  public static final String EDIT_CONTACT = EDIT + ALL_FIELDS + PRESS_READY + RULES;

  private InfoMsg() {}

}
