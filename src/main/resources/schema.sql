
create table user
(
    id       INTEGER not null
        primary key autoincrement,
    name     varchar(20),
    password varchar(254)
);

create table "bridge-report"
(
    id                  INTEGER,
    name                TEXT,
    create_by           TEXT,
    create_time         TIMESTAMP default CURRENT_TIMESTAMP,
    is_generate_reports INTEGER
);

create table role
(
    id
        primary key,
    name        TEXT,
    create_by   TEXT,
    create_time TIMESTAMP default CURRENT_TIMESTAMP,
    data_range  INTEGER,
    value       TEXT
);

create table role_user
(
    id      INTEGER
        primary key autoincrement,
    role_id INTEGER,
    user_id INTEGER
);

