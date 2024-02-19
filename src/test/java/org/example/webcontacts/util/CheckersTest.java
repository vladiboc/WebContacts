package org.example.webcontacts.util;

import org.example.webcontacts.data.Contact;
import org.example.webcontacts.exception.IllegalFieldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckersTest {

  @Test
  void shouldThrowException() {
    Contact testContact = new Contact(1, "John", "Smith", "js@mail.r", "07");
    assertThrowsExactly(IllegalFieldException.class,
        () -> Checkers.checkHtmlInputFields(testContact));
    testContact.setPhone("+79990123456");
    assertThrowsExactly(IllegalFieldException.class,
        () -> Checkers.checkHtmlInputFields(testContact));
    testContact.setEmail("js@mail.ru");
    assertThrowsExactly(IllegalFieldException.class,
        () -> Checkers.checkHtmlInputFields(testContact));
    testContact.setLastName("Смит");
    assertThrowsExactly(IllegalFieldException.class,
        () -> Checkers.checkHtmlInputFields(testContact));
    testContact.setFirstName("Джон");
    try {
      Checkers.checkHtmlInputFields(testContact);
    } catch (IllegalFieldException e) {
      throw new Error(e);
    }
  }

}
