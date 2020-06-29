package com.tim.application.rpgApplication.service;

import com.tim.application.rpgApplication.db.UserCharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingService {

    @Autowired
    private UserCharacterService userCharacterService;

    public int countAllGold(){
        List<UserCharacterEntity> allUsers = userCharacterService.getAll();
        int goldTotal = 0;
        for (UserCharacterEntity userCharacterEntity: allUsers){
            int gold = userCharacterEntity.getGold();
            goldTotal = goldTotal + gold;
        }
        return goldTotal;
    }

    public int countClassGold() {
        List<UserCharacterEntity> allUsers = userCharacterService.getAll();
        int goldTotal = 0;
        for (UserCharacterEntity userCharacterEntity: allUsers){
            int gold = userCharacterEntity.getGold();
            goldTotal = goldTotal + gold;
        }
        return goldTotal;
    }
}
