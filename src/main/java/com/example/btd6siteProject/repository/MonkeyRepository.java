package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.Monkey;
import com.example.btd6siteProject.model.entity.MonkeyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface MonkeyRepository extends JpaRepository<Monkey, Integer> {
    @Query("SELECT m FROM Monkey m WHERE m.type = :type")
    List<Monkey> findByMonkeyType(MonkeyType type);
    @Query("SELECT m FROM Monkey m WHERE m.name = :name")
    List<Monkey> findByName(String name);
    @Query("SELECT m FROM Monkey m WHERE m.upgradeRow1 = :row1 AND m.upgradeRow2 = :row2 AND m.upgradeRow3 = :row3")
    Optional<Monkey> findMonkeyByRows(Integer row1, Integer row2, Integer row3);
}
