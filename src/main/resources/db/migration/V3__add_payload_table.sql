CREATE TABLE payload
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    created_on datetime NOT NULL,
    last_modified_on datetime NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    last_modified_by VARCHAR(255) NOT NULL,
    is_deleted BIT(1) NOT NULL,
    version INT NOT NULL,
    drone_id BIGINT NULL,
    name VARCHAR(255) NOT NULL,
    weight INT NOT NULL,
    weight_unit VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    payload_type VARCHAR(255) NOT NULL,
    image_id BIGINT NOT NULL,
    CONSTRAINT pk_payload PRIMARY KEY (id),
    CONSTRAINT uc_payload_code UNIQUE (code),
    CONSTRAINT uc_payload_name UNIQUE (name),
    CONSTRAINT FK_PAYLOAD_ON_DRONE FOREIGN KEY (drone_id) REFERENCES drones (id),
    CONSTRAINT FK_PAYLOAD_ON_IMAGE FOREIGN KEY (image_id) REFERENCES files (id)
);