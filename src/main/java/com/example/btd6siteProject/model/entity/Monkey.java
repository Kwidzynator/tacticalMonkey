package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "monkeys")
public class Monkey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MonkeyType type;

    private String name;

    private Integer upgradeRow1;
    private Integer upgradeRow2;
    private Integer upgradeRow3;

    public MonkeyType getType() {
        return type;
    }

    public void setType(MonkeyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUpgradeRow1() {
        return upgradeRow1;
    }

    public void setUpgradeRow1(Integer upgradeRow1) {
        this.upgradeRow1 = upgradeRow1;
    }

    public Integer getUpgradeRow2() {
        return upgradeRow2;
    }

    public void setUpgradeRow2(Integer upgradeRow2) {
        this.upgradeRow2 = upgradeRow2;
    }

    public Integer getUpgradeRow3() {
        return upgradeRow3;
    }

    public void setUpgradeRow3(Integer upgradeRow3) {
        this.upgradeRow3 = upgradeRow3;
    }
}
