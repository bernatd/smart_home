DROP TABLE IF EXISTS sensors;

CREATE TABLE sensors (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    type VARCHAR(250),
    pin INTEGER,
    units VARCHAR(250),
    desc VARCHAR(250)
);

DROP TABLE IF EXISTS data;

CREATE TABLE data (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    sensor_id LONG,
    val REAL,
    PRIMARY KEY(id),
    FOREIGN KEY(sensor_id) REFERENCES sensors(id)
);