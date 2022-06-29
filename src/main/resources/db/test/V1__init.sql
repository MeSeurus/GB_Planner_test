create table events (
    id          bigserial primary key,
    title       varchar(255),
    event_start datetime,
    event_end   datetime
);

insert into events (title, event_start, event_end) values
('testevent1', '2022-06-24 01:00:00', '2022-06-24 07:00:00'),
('testevent2', '2022-06-24 02:00:00', '2022-06-25 07:00:00');