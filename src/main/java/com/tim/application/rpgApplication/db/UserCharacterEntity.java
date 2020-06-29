package com.tim.application.rpgApplication.db;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="USER_CHARACTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCharacterEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "race")
    private String race;

    @Column(name = "gold")
    private Integer gold;

    @Column(name = "questing")
    private boolean questing;

    @OneToOne
    @JoinColumn(name = "weapon")
    private WeaponEntity weaponEntity;

}