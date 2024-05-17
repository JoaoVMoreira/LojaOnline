CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    user_email TEXT UNIQUE NOT NULL,
    user_password TEXT NOT NULL,
    user_name TEXT NOT NULL,
    user_surname TEXT NOT NULL,
    user_CPF TEXT UNIQUE NOT NULL,
    user_cel_number TEXT UNIQUE NOT NULL,
    user_role TEXT NOT NULL,
    user_actived BOOLEAN NOT NULL
);
