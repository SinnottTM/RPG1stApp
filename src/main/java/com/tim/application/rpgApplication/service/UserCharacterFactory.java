package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.db.UserCharacterEntity;
import com.tim.application.rpgApplication.db.WeaponsRepository;
import com.tim.application.rpgApplication.service.WeaponFactory;
import com.tim.application.rpgApplication.service.model.UserCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCharacterFactory {

    @Autowired
    private WeaponsRepository weaponsRepository;

    @Autowired
    private WeaponFactory weaponFactory;

    public UserCharacterEntity fromModel(UserCharacter userCharacter) {
        return UserCharacterEntity.builder()
                .id(userCharacter.getId())
                .name(userCharacter.getName())
                .race(userCharacter.getRace())
                .gold(userCharacter.getGold())
                .questing(userCharacter.isQuesting())
                .weaponEntity(weaponsRepository.findById(userCharacter.getWeapon().getId()).get())
                .build();
    }

    public UserCharacter fromUserCharacterRequest(int id, String name, String race, int gold, boolean questing, int weapon) {
        return UserCharacter.builder()
                .id(id)
                .name(name)
                .race(race)
                .gold(gold)
                .questing(questing)
                .weapon(
                        weaponFactory.fromEntity(
                                weaponsRepository.findById(weapon).get()
                        )
                )
                .build();

    }
}