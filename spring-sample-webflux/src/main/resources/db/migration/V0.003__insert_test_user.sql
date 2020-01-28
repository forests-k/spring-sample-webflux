insert into "public".users(id, mail, gender, password, birthdate, created_at) values
 (1, 'test@gmail.com', 1, 'e3aa8d3418597b69e42c2145a6ba458ebbbdefa948c12aafca6d4163da4717c917e888a23ca3547b', '1990-01-01', current_timestamp)
;

insert into "public".users_history(id, user_id, mail, gender, password, birthdate, note, created_at) values
 (1, 1, 'test@gmail.com', 1, 'e3aa8d3418597b69e42c2145a6ba458ebbbdefa948c12aafca6d4163da4717c917e888a23ca3547b', '1990-01-01', 'CREATE', current_timestamp)
;