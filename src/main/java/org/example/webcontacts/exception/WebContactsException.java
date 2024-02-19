package org.example.webcontacts.exception;

public class WebContactsException extends Exception {
  public WebContactsException() {
  }

  public WebContactsException(String message) {
    super(message);
  }

  public WebContactsException(String message, Throwable cause) {
    super(message, cause);
  }

  public WebContactsException(Throwable cause) {
    super(cause);
  }

  public WebContactsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
