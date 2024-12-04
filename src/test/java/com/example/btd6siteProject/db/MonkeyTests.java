package com.example.btd6siteProject.db;


import com.example.btd6siteProject.model.entity.Monkey;
import com.example.btd6siteProject.model.entity.MonkeyType;
import com.example.btd6siteProject.repository.MonkeyRepository;
import com.example.btd6siteProject.repository.MonkeyTypeRepository;
import com.example.btd6siteProject.service.MonkeyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class MonkeyTests {

    private final MonkeyService monkeyService;

    private final MonkeyRepository monkeyRepository;

    private final MonkeyTypeRepository monkeyTypeRepository;

    public MonkeyTests(MonkeyService monkeyService, MonkeyRepository monkeyRepository, MonkeyTypeRepository monkeyTypeRepository){
        this.monkeyService = monkeyService;
        this.monkeyRepository = monkeyRepository;
        this.monkeyTypeRepository = monkeyTypeRepository;
    }


    @Test
    public void testingMonkeyTypes(){
        Monkey monkey = new Monkey();
        monkey.setName("Dart Monkey");
        monkey.setUpgradeRow1(0);
        monkey.setUpgradeRow2(0);
        monkey.setUpgradeRow3(0);

        MonkeyType fetchedType = monkeyTypeRepository.findByTypeName("Primary")
                .orElseThrow(() -> new IllegalArgumentException("Type 'Primary' not found"));


        assertThat(fetchedType.getTypeName()).isEqualTo("Primary");
        List<Monkey> monkeys = monkeyRepository.findByMonkeyType(fetchedType);
        assertThat(monkeys).hasSize(1);
        assertThat(monkeys.get(0).getName()).isEqualTo("Dart Monkey");
        assertThat(monkeys.get(0).getUpgradeRow1()).isEqualTo(0);
        assertThat(monkeys.get(0).getUpgradeRow2()).isEqualTo(0);
        assertThat(monkeys.get(0).getUpgradeRow3()).isEqualTo(0);
    }

    @Test
    public void testIfMonkeyRepeats(){

    }

}
