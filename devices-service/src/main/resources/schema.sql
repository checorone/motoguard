DROP TABLE IF EXISTS devices;

CREATE TABLE devices (
  device_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  artik_id		   VARCHAR(155) NOT NULL,
  type             VARCHAR(50) NOT NULL,
  owner_username   VARCHAR(100) NOT NULL);


INSERT INTO devices (device_id, artik_id, type, owner_username)
VALUES ('abcd1234-efgh', '3dcc6661784f4bd2b21dc0a8ccf47084' ,'Стандартное устроиство', 'admin@gmail.com');