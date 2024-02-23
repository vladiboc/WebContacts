package org.example.webcontacts.repository;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.ContactRowMapper;
import org.example.webcontacts.data.Contact;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Slf4j
@RequiredArgsConstructor
public class DbContactRepository implements ContactRepository {
  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Contact> findAll() {
    log.debug("Call dbContactRepository.findAll()");

    final String sql = "SELECT * FROM contacts";

    return this.jdbcTemplate.query(sql, new ContactRowMapper());
  }

  @Override
  public Optional<Contact> findById(int id) {
    log.debug("Call dbContactRepository.findById({})", id);

    final String sql = "SELECT * FROM contacts WHERE id = ?";
    final Contact contact = DataAccessUtils.singleResult(
        jdbcTemplate.query(
            sql,
            new ArgumentPreparedStatementSetter(new Object[] {id}),
            new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
        )
    );
    return Optional.ofNullable(contact);
  }

  @Override
  public Contact save(Contact contact) {
    log.debug("Call dbContactRepository.save({})", contact);

    final String sql = "INSERT INTO contacts (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
    return contact;
  }

  @Override
  public @Nullable Contact update(Contact contact) {
    log.debug("Call dbContactRepository.update({})", contact);

    final Contact targetContact = this.findById(contact.getId()).orElse(null);
    if (targetContact != null) {
      final String sql = "UPDATE contacts SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
      jdbcTemplate.update(
          sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), contact.getId()
      );
    }
    log.warn("dbContactRepository.update({}): Contact with id:{} not found!", contact, contact.getId());

    return targetContact;
  }

  @Override
  public void deleteById(int id) {
    log.debug("Call dbContactRepository.deleteById({})", id);

    final String sql = "DELETE FROM contacts WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

}
