package com.example.litters.repo;

import com.example.litters.Entity.Adress;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdressRepo extends JpaRepository<Adress, Integer> {



}
