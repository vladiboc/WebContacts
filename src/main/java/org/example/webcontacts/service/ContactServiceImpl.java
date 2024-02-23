package org.example.webcontacts.service;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.webcontacts.data.Contact;
import org.example.webcontacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {
  private final ContactRepository contactRepository;

  @Override
  public List<Contact> findAll() {
    log.debug("Call contactServiceImpl.findAll()");
    return this.contactRepository.findAll();
  }

  @Override
  public @Nullable Contact findById(int id) {
    log.debug("Call contactServiceImpl.findById({})", id);
    return this.contactRepository.findById(id).orElse(null);
  }

  @Override
  public Contact save(Contact contact) {
    log.debug("Call contactServiceImpl.save({})", contact);
    return this.contactRepository.save(contact);
  }

  @Override
  public @Nullable Contact update(Contact contact) {
    log.debug("Call contactServiceImpl.update({})", contact);
    return this.contactRepository.update(contact);
  }

  @Override
  public void deleteById(int id) {
    log.debug("Call contactServiceImpl.deleteById({})", id);
    this.contactRepository.deleteById(id);
  }

}
