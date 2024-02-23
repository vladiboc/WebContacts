INSERT INTO contacts_schema.contacts
    (first_name, last_name, email, phone)
VALUES
    ('Иван', 'Иванов', 'ivan@mail.ru', '+79990123456'),
    ('Петр', 'Петров', 'petr@mail.ru', '+78880123456'),
    ('Ия', 'Обст', 'iya@mail.ru', '+77770123456')
RETURNING *;
