package com.unext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unext.model.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {

}
