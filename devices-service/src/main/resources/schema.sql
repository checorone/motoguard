DROP TABLE IF EXISTS devices;

CREATE TABLE devices (
  device_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  connected        boolean NOT NULL,
  type             VARCHAR(50) NOT NULL,
  owner_username   VARCHAR(100) NOT NULL);


INSERT INTO devices (device_id, connected, type, owner_username)
VALUES ('1234abcd-efgh', false, 'Standard', 'admin@gmail.com');