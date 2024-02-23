CREATE SCHEMA IF NOT EXISTS contacts_schema AUTHORIZATION contacts;

CREATE TABLE IF NOT EXISTS contacts_schema.contacts (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);

ALTER TABLE contacts_schema.contacts OWNER TO contacts;
