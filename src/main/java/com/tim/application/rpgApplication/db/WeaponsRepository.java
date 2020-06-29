package com.tim.application.rpgApplication.db;

import com.tim.application.rpgApplication.db.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponsRepository extends JpaRepository<WeaponEntity, Integer> {

    public static final String DEFAULT_WEAPON_NAME = "Bare Hands";

    WeaponEntity findByWeaponName(String weaponName);
}
