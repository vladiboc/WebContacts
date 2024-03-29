package org.example.webcontacts.service;

import org.example.webcontacts.data.Contact;

import java.util.List;

public interface ContactService {
  List<Contact> findAll();
  Contact findById(int id);
  Contact save(Contact contact);
  Contact update(Contact contact);
  void deleteById(int id);

}
