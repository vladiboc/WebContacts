package org.example.webcontacts.repository;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.example.webcontacts.data.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class RamContactRepository implements ContactRepository {
  private final List<Contact> contacts = new ArrayList<>();
  private int lastId = 1;

  @Override
  public List<Contact> findAll() {
    log.debug("Call ramContactRepository.findAll()");
    return this.contacts;
  }

  @Override
  public Optional<Contact> findById(int id) {
    log.debug("Call ramContactRepository.findById({}).", id);
    return this.contacts.stream()
        .filter(contact -> (contact.getId() == id))
        .findFirst();
  }

  @Override
  public Contact save(Contact contact) {
    log.debug("Call ramContactRepository.save({})", contact);
    contact.setId(this.lastId++);
    this.contacts.add(contact);
    return contact;
  }

  @Override
  public @Nullable Contact update(Contact contact) {
    log.debug("Call ramContactRepository.update({})", contact);
    Contact targetContact = this.findById(contact.getId()).orElse(null);
    if (targetContact != null) {
      targetContact.setFirstName(contact.getFirstName());
      targetContact.setLastName(contact.getLastName());
      targetContact.setEmail(contact.getEmail());
      targetContact.setPhone(contact.getPhone());
    }
    return targetContact;
  }

  @Override
  public void deleteById(int id) {
    log.debug("Call ramContactRepository.deleteById({})", id);
    this.findById(id).ifPresent(this.contacts::remove);
  }

}
