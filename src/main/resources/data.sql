INSERT INTO USER(username, password, enabled) values ('admin', '{noop}admin', true);
INSERT INTO USER(username, password, enabled) values ('user', '{noop}user', true);
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');

INSERT INTO blog_post(title, content) VALUES('Jem zupe', 'Cześć, witam wszystkich, właśnie jem zupę. Pomidorową.');
INSERT INTO blog_post(title, content) VALUES('Uczę się Javy', 'Lekko nie jest, ale już niedługo koniec. Na szczęście programowanie to czysta przyjemność');
INSERT INTO blog_post(title, content) VALUES('Korpo fraszka', 'To moja droga z taska do taska, W trybie agile do przodu gnam, Nikt nie rewiduje nikt nie prześwietla, Znaczenie spagetti tylko ja znam.');