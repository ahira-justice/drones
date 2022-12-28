package com.ahirajustice.drones.common.entities;

import com.ahirajustice.drones.common.enums.PayloadType;
import com.ahirajustice.drones.common.enums.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "payload")
public class Payload extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PayloadType payloadType;

    @OneToOne
    @JoinColumn(nullable = false)
    private File image;

}
