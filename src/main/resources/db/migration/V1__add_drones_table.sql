CREATE TABLE drones
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    created_on datetime NOT NULL,
    last_modified_on datetime NOT NULL,
    created_by VARCHAR(255)NOT NULL,
    last_modified_by VARCHAR(255)NOT NULL,
    is_deleted BIT(1) NOT NULL,
    version INT NOT NULL,
    serial_number VARCHAR(100)NOT NULL,
    model INT NOT NULL,
    weight_limit INT NOT NULL,
    weight_limit_unit INT NOT NULL,
    battery_percentage INT NOT NULL,
    state INT NOT NULL,
    CONSTRAINT pk_drones PRIMARY KEY (id),
    CONSTRAINT uc_drones_serialnumber UNIQUE (serial_number)
);