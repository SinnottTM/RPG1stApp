package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.db.UserCharacterEntity;
import com.tim.application.rpgApplication.db.WeaponEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tim.application.rpgApplication.db.WeaponsRepository.DEFAULT_WEAPON_NAME;

@Service
public class AdministrationService {

    @Autowired
    private WeaponService weaponService;

    @Autowired
    private UserCharacterService userCharacterService;


    public int resetCharacterWeaponThenDelete(String weaponName){
        WeaponEntity defaultWeapon = weaponService.getWeaponByName(DEFAULT_WEAPON_NAME);
        List<UserCharacterEntity> allUsers = userCharacterService.getAll();

        int numberOfUsersChanged = 0;
        for (UserCharacterEntity userCharacterEntity: allUsers){
            WeaponEntity weaponOfUser = userCharacterEntity.getWeaponEntity();
            if (weaponOfUser.getWeaponName().equalsIgnoreCase(weaponName)){
                userCharacterEntity.setWeaponEntity(defaultWeapon);
                numberOfUsersChanged++;
            }
        }

        weaponService.deleteWeaponByName(weaponName);

        return numberOfUsersChanged;
    }
}
