package com.ahirajustice.drones.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "files")
public class File extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String reference;

    @Column(nullable = false)
    private int url;;

}
