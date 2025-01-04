package com.example.btd6siteProject.service;


import com.example.btd6siteProject.model.entity.Points;
import com.example.btd6siteProject.repository.PointsRepository;

import java.awt.*;

public class PointsService {
    private final PointsRepository pointsRepository;

    public PointsService(PointsRepository pointsRepository){
        this.pointsRepository = pointsRepository;
    }

    public void savePoint(Points point){
        pointsRepository.save(point);
    }
}
