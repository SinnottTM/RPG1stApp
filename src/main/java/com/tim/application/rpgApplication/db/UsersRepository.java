package com.tim.application.rpgApplication.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserCharacterEntity, Integer> {

    // UsersRepository findByRace(String raceName);

}