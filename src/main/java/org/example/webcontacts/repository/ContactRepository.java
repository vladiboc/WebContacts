package org.example.webcontacts.repository;

import jakarta.annotation.Nullable;
import org.example.webcontacts.data.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
  List<Contact> findAll();
  Optional<Contact> findById(int id);
  Contact save(Contact contact);
  Contact update(Contact contact);
  void deleteById(int id);

}
