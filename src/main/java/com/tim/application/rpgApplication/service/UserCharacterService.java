package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.Controller;
import com.tim.application.rpgApplication.InvalidCharacterStateException;
import com.tim.application.rpgApplication.db.UserCharacterEntity;
import com.tim.application.rpgApplication.db.UsersRepository;
import com.tim.application.rpgApplication.service.model.UserCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCharacterService {

    // public Controller race;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    UserCharacterFactory userCharacterFactory;


    public List<UserCharacterEntity> getAll() {
        return userRepository.findAll();
    }


    // public List<UserCharacterEntity> getRace() { return userRepository.findByRace(); }


    public void addCharacter(UserCharacter userCharacter) {

        validateCharacter(userCharacter);

        UserCharacterEntity userCharacterEntity = userCharacterFactory.fromModel(userCharacter);

        userRepository.save(userCharacterEntity);
    }

    private void validateCharacter(UserCharacter userCharacter) {
        if (userCharacter.isWizard() && userCharacter.getRace().equalsIgnoreCase("wizards")) {
            throw new InvalidCharacterStateException("Only those who train all their lives can be wizards");
        }
        if (userCharacter.isBarbarian() && userCharacter.isQuesting()) {
            throw new InvalidCharacterStateException("Barbarians cannot quest, too much time spent not killing");
        }
        if (userCharacter.isRouge() && userCharacter.getGold() > 1000) {
            throw new InvalidCharacterStateException("Rouges cannot have more than 1000 gold, they are no good at saving");
        }
        if (userCharacter.isDruid() && userCharacter.getName().equalsIgnoreCase("Bob")) {
            throw new InvalidCharacterStateException("There are no druids named Bob!");
        }

        validateWeapon(userCharacter);
    }

    private void validateWeapon(UserCharacter userCharacter) {
        if (userCharacter.isWizard()) {
            validateWizardWeapon(userCharacter);
        } else if (userCharacter.isBarbarian()) {
            validateBarbarianWeapon(userCharacter);
        } else if (userCharacter.isRouge()) {
            validateRougeWeapon(userCharacter);
        } else if (userCharacter.isDruid()) {
            validateDruidWeapon(userCharacter);
        }
    }

    private void validateWizardWeapon(UserCharacter userCharacter) {
        if (userCharacter.isWizard() && userCharacter.getWeapon().isWizardWeapon()) {
            System.out.println("Ah, a weapon fit for a true Wizard");
        } else {
            throw new RuntimeException("Bad Weapon choice for Wizards");
        }
    }

    private void validateBarbarianWeapon(UserCharacter userCharacter) {
        if (userCharacter.isBarbarian() && userCharacter.getWeapon().isBarbarianWeapon()) {
            System.out.println("Ah, a weapon fit for a ferocious Barbarian");
        } else {
            throw new RuntimeException("Bad Weapon choice for Barbarians");
        }
    }

    private void validateRougeWeapon(UserCharacter userCharacter) {
        if (userCharacter.isRouge() && userCharacter.getWeapon().isRougeWeapon()) {
            System.out.println("Ah, a weapon fit for a dangerous Rouge");
        } else {
            throw new RuntimeException("Bad Weapon choice for Rouges");
        }
    }

    private void validateDruidWeapon(UserCharacter userCharacter) {
        if (userCharacter.isDruid() && userCharacter.getWeapon().isDruidWeapon()) {
            System.out.println("Ah, a weapon fit for a wise Druid");
        } else {
            throw new RuntimeException("Bad Weapon choice for Druids");
        }
    }

    public void deleteCharacter(int id) {
        Optional<UserCharacterEntity> userInDatabase = userRepository.findById(id);
        if(userInDatabase.isPresent()){
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("That Character does not exist, please try again");
        }
    }

}