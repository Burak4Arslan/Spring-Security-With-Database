INSERT into user_table (user_id, password, username) values (0,'b','burak');
INSERT into role (role_id, role) values (1,'ADMIN');
INSERT into role (role_id, role) values (2,'USER');
INSERT into user_role (user_id,role_id) values (0,1);