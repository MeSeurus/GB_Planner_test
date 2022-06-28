create table if not exists pets
(id bigserial primary key, title varchar(100), score int);

insert into pets(title, score)
values  ('Dog', 100),
        ('Cat', 100),
        ('Mouse', 100);