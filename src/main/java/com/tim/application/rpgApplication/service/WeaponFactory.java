package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.db.WeaponEntity;
import com.tim.application.rpgApplication.service.model.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponFactory {

    public WeaponEntity fromModel(Weapon weapon) {
        return WeaponEntity.builder()
                .id(weapon.getId())
                .cost(weapon.getCost())
                .weaponName(weapon.getName())
                .weaponRace(weapon.getRace())
                .build();
    }

    public Weapon fromEntity(WeaponEntity weaponEntity) {
        return Weapon.builder()
                .id(weaponEntity.getId())
                .cost(weaponEntity.getCost())
                .name(weaponEntity.getWeaponName())
                .race(weaponEntity.getWeaponRace())
                .build();
    }

    public Weapon fromUserRequest(int id, String weaponName, String weaponRace, int cost) {
        return Weapon.builder()
                .id(id)
                .race(weaponRace)
                .cost(cost)
                .name(weaponName)
                .build();
    }
}
