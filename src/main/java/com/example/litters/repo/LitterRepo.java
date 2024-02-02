package com.example.litters.repo;

import com.example.litters.Entity.Litter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LitterRepo extends JpaRepository<Litter, Integer> {

    @Query(value = "insert into litter_adress (litter_id, adress_id) values (?, ?)", nativeQuery = true)
    @Modifying
    @Transactional
    public void insertAdressLitter(@Param("litter_id") int litter_id, @Param("adress_id") int adress_id);

 @Query(value = "select a.recever_adress from litter_adress la,Litter l,Adress a where la.adress_id=a.id and la.litter_id= ? group by a.recever_adress ", nativeQuery = true)

    public List<String> getAllAdressByid(@Param("litter_id") int litter_id);

}
