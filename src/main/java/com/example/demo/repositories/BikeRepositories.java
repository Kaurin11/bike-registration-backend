package com.example.demo.repositories;

import com.example.demo.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepositories extends JpaRepository <Bike, Long> {
}
