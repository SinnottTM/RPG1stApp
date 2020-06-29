package com.tim.application.rpgApplication;

import com.tim.application.rpgApplication.db.UserCharacterEntity;
import com.tim.application.rpgApplication.db.WeaponEntity;
import com.tim.application.rpgApplication.service.*;
import com.tim.application.rpgApplication.service.model.UserCharacter;
import com.tim.application.rpgApplication.service.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/hero")
public class Controller {

    @Autowired
    UserCharacterService userCharacterService;

    @Autowired
    UserCharacterFactory userCharacterFactory;

    @Autowired
    ReportingService reportingService;

    @Autowired
    WeaponFactory weaponFactory;

    @Autowired
    AdministrationService administrationService;

    @GetMapping(value = "/revealAll")
    public List<UserCharacterEntity> getAll() {
        return userCharacterService.getAll();
    }

    /*

    @GetMapping(value = "/revealRace")
    public List<UserCharacterEntity> getRace() { return userCharacterService.race.getAll(); }


     */


    @GetMapping(value = "/addC")
    public void addCharacter(@RequestParam int id, @RequestParam String name, @RequestParam String race, @RequestParam int gold, @RequestParam boolean questing, @RequestParam int weapon) {
        if (validateString(name) && validateString(race)) {
            UserCharacter userCharacter = userCharacterFactory.fromUserCharacterRequest(id, name, race, gold, questing, weapon);
            userCharacterService.addCharacter(userCharacter);
        }
    }

    @GetMapping(value = "/deleteC")
    public void deleteCharacter(@RequestParam int id) {
        userCharacterService.deleteCharacter(id);
    }

    @GetMapping(value = "/deleteW")
    public int deleteWeapon(@RequestParam String weaponName) {
        return administrationService.resetCharacterWeaponThenDelete(weaponName);
    }

    @GetMapping(value = "/allGold")
    public int countAllGold() {
        return reportingService.countAllGold();
    }

    @GetMapping(value = "/classGold")
    public int countsClassGold() {
        return reportingService.countClassGold();
    }

    @Autowired
    private WeaponService weaponService;

    @GetMapping(value = "/addW")
    public void addWeapon(@RequestParam int id, @RequestParam String weaponName, @RequestParam String weaponRace, @RequestParam int cost) {
        if (validateString(weaponName) && validateString(weaponRace)) {
            Weapon weapon = weaponFactory.fromUserRequest(id, weaponName, weaponRace, cost);
            weaponService.addWeapon(weapon);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------


    public boolean validateString(String input) {
        if (input.length() < 1) {
            return false;
        }
        return true;
    }

    //-----------------------------------------------------------------------------------------------------------------

}