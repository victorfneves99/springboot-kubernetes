create table bookmarks (
    id bigint DEFAULT nextval ('bm_id_seq') not null,
    created_at timestamp(6),
    title varchar(255) not null,
    url varchar(255) not null,
    primary key (id)
);

create sequence bm_id_seq start with 1 increment by 50