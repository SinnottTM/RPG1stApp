package com.tim.application.rpgApplication.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Weapon {

    private int id;
    private String name;
    private String race;
    private int cost;

    public boolean isWizardWeapon() {
        return "Wizard".equalsIgnoreCase(race);
    }

    public boolean isBarbarianWeapon() {
        return "Barbarian".equalsIgnoreCase(race);
    }

    public boolean isRougeWeapon() {
        return "Rouge".equalsIgnoreCase(race);
    }

    public boolean isDruidWeapon() {
        return "Druid".equalsIgnoreCase(race);
    }

}
