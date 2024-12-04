package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.Monkey;
import com.example.btd6siteProject.model.entity.MonkeyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MonkeyTypeRepository extends JpaRepository<MonkeyType, Integer> {

    Optional<MonkeyType> findByTypeName(String typeName);
}
