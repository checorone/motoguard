DROP TABLE IF EXISTS devices;

CREATE TABLE devices (
  device_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  type             VARCHAR(50) NOT NULL,
  owner_username   VARCHAR(100) NOT NULL);


INSERT INTO devices (device_id, type, owner_username)
VALUES ('abcd1234-efgh', false, 'Стандартное устроиство', 'admin@gmail.com');