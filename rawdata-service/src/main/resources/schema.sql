DROP TABLE IF EXISTS rawdata;

CREATE TABLE rawdata (
  device_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  message_id   		TEXT NOT NULL,
  latitude      	REAL NOT NULL,
  longitude      	REAL NOT NULL,
  speed		      	REAL NOT NULL,
  vibration      	REAL NOT NULL,
  gx		      	REAL NOT NULL,
  gy		      	REAL NOT NULL,
  gz		      	REAL NOT NULL,
  degx		      	REAL NOT NULL,
  degy		      	REAL NOT NULL,
  degz		      	REAL NOT NULL,
  dop      			REAL NOT NULL);
