CREATE TABLE supermarket_item
(
    id BIGINT  NOT NULL PRIMARY KEY,
    item_name TEXT,
    price decimal(18, 2) NOT NULL,
    weight decimal(18, 2) NOT NULL,
    item_type TEXT
);

create sequence hibernate_sequence;