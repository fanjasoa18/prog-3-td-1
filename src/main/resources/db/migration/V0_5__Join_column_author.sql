ater table book
drop
column author;
alter table book add column id_author integer
alter table book add constraint id_book_author_fk
    foreign key(id_author) references author (id);

