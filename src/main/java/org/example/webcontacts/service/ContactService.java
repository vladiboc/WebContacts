package org.example.webcontacts.service;

import jakarta.annotation.Nullable;
import org.example.webcontacts.data.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
  private final List<Contact> contacts = new ArrayList<>();

  // TODO убрать этот блок инициалицации после подключения БД
  {
    this.contacts.add(new Contact(0, "Иван", "Иванов", "ivanov@mail.ru", "+70001234567"));
    this.contacts.add(new Contact(1, "Ия", "Обст", "ia@mail.ru", "+70001234567"));
  }

  public List<Contact> findAll() {
    return this.contacts;
  }

  public void add(Contact contact) {
    this.contacts.add(contact);
  }

  public @Nullable Contact findById(int id) {
    return this.contacts.stream()
        .filter(contact -> (contact.getId() == id))
        .findFirst()
        .orElse(null);
  }

  public void update(Contact contact, Contact targetContact) {
    targetContact.setFirstName(contact.getFirstName());
    targetContact.setLastName(contact.getLastName());
    targetContact.setEmail(contact.getEmail());
    targetContact.setPhone(contact.getPhone());
  }

  public void delete(Contact contact) {
    this.contacts.remove(contact);
  }

}
