CREATE TABLE loan_request
(
    id                     varchar(50) PRIMARY KEY,
    client_id              varchar(50)    NOT NULL,
    amount                 numeric(19, 2) NOT NULL,
    kyc_validation_result  varchar(255)   NOT NULL,
    approved               boolean        NOT NULL,

    creation_timestamp     TIMESTAMP      NOT NULL,
    modification_timestamp TIMESTAMP      NOT NULL
);