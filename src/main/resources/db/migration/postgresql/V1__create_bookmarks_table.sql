CREATE TABLE bookmarks (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    created_at TIMESTAMP(6) WITH TIME ZONE,
    title VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL
);
