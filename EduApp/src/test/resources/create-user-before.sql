delete from user_role;
delete from usr;

insert into usr(id, active, password, username)
values (1, true, '$2a$08$HMyFC2JG6Mke/aacF5rjhO5yu5YPvOPFZsQXzF6i9SBWLyFMd3CPO', 'admin'), (2, true, '', 'Aidar');

insert into user_role(user_id, roles)
values (1, 'USER'), (1, 'ADMIN'),
(2, 'USER');