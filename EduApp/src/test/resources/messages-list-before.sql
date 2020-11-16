delete from message;

insert into message(id, text, tag, user_id) values
(1, 'first', 'first-tag', 1),
(2, 'second', 'my-tag', 1),
(3, 'third', 'his-tag', 1),
(4, 'fourth', 'my-tag', 1);

alter sequence hibernate_sequence restart with 10;