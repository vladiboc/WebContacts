package org.example.webcontacts.exception;

public class IllegalFieldException extends WebContactsException {
  public IllegalFieldException() {
  }

  public IllegalFieldException(String message) {
    super(message);
  }

  public IllegalFieldException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalFieldException(Throwable cause) {
    super(cause);
  }

  public IllegalFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
