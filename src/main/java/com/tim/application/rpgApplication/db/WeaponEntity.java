package com.tim.application.rpgApplication.db;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="WEAPON")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String weaponName;

    @Column(name = "race")
    private String weaponRace;

    @Column(name = "cost")
    private int cost;

}

