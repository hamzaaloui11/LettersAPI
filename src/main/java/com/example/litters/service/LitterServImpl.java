package com.example.litters.service;

import com.example.litters.Entity.Adress;
import com.example.litters.Entity.Litter;
import com.example.litters.repo.AdressRepo;
import com.example.litters.repo.LitterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LitterServImpl implements LitterService{
    @Autowired
    private LitterRepo litterRepo;
    @Autowired
    private AdressRepo adressRepo;
    @Override
    public Litter saveLitter(Litter litter) {
        return litterRepo.save(litter);
    }

    @Override
    public List<Litter> getLitters() {
        return litterRepo.findAll();
    }

    @Override
    public Adress addAdress(Adress adress) {
        return adressRepo.save(adress);
    }

    @Override
    public void insertAdressLitter( int litter_id,  int adress_id){
         litterRepo.insertAdressLitter(litter_id,adress_id);
    }

    @Override
    public List<String> getAddressString(int litter_id) {
        return litterRepo.getAllAdressByid(litter_id);
    }
}
