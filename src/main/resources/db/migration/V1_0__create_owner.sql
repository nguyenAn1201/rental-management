CREATE TABLE IF NOT EXISTS owners (
    id serial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    created_at timestamp,
    updated_at timestamp
)