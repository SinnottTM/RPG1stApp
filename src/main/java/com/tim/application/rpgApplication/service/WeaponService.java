package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.db.WeaponEntity;
import com.tim.application.rpgApplication.db.WeaponsRepository;
import com.tim.application.rpgApplication.service.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    @Autowired
    private WeaponsRepository weaponsRepository;

    @Autowired
    private WeaponFactory weaponFactory;

    public void addWeapon(Weapon weapon) {

        WeaponEntity weaponEntity = weaponFactory.fromModel(weapon);

        weaponsRepository.save(weaponEntity);
    }

    public WeaponEntity getWeaponByName(String weaponName) {
        return weaponsRepository.findByWeaponName(weaponName);
    }

    public void deleteWeaponByName(String weaponName) {
        WeaponEntity weaponToBeDeleted = weaponsRepository.findByWeaponName(weaponName);
        weaponsRepository.delete(weaponToBeDeleted);
    }

}
