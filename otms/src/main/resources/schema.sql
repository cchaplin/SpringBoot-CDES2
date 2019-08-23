CREATE TABLE IF NOT EXISTS trip (
    tripId  INTEGER  NOT NULL,
    empId   INTEGER NOT NULL,
    startTime  TIMESTAMP NOT NULL,
    endTime    TIMESTAMP NOT NULL,
    distance    INTEGER NOT NULL,
    cost    FLOAT NOT NULL,
    PRIMARY KEY (tripId)
);
