CREATE TABLE common (
    id IDENTITY ,
    preamble VARCHAR (12) ,
    mt VARCHAR(4) ,
    messageType VARCHAR (50) ,
    country VARCHAR (100) ,
    provider VARCHAR (20) ,
    severity VARCHAR (150) ,
    guidance VARCHAR (200) ,
    latitude DOUBLE ,
    longitude DOUBLE ,
    eventOnset DATETIME ,
    semiMajorAxisLength BIGINT ,
    semiMinorAxisLength BIGINT ,
    azimuthAngle DOUBLE
);