package com.tim.application.rpgApplication.service.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCharacter {

    private int id;
    private String name;
    private String race;
    private Integer gold;
    private boolean questing;
    private Weapon weapon;

    public boolean isWizard() {
        return "Wizard".equalsIgnoreCase(race);
    }

    public boolean isBarbarian() {
        return "Barbarian".equalsIgnoreCase(race);
    }

    public boolean isRouge() {
        return "Rouge".equalsIgnoreCase(race);
    }

    public boolean isDruid() {
        return "Druid".equalsIgnoreCase(race);
    }

}
