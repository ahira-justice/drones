CREATE TABLE files
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    created_on datetime NOT NULL,
    last_modified_on datetime NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    last_modified_by VARCHAR(255) NOT NULL,
    is_deleted BIT(1) NOT NULL,
    version INT NOT NULL,
    `reference` VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    CONSTRAINT pk_files PRIMARY KEY (id),
    CONSTRAINT uc_files_reference UNIQUE (`reference`)
);