package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.entity.Transcation;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation, Integer>{

}
