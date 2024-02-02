package com.example.litters.service;

import com.example.litters.Entity.Adress;
import com.example.litters.Entity.Litter;

import java.util.List;

public interface LitterService {
     Litter saveLitter(Litter litter);
    public Adress addAdress(Adress adress);
     List<Litter>  getLitters();
      void insertAdressLitter( int litter_id,  int adress_id);
    List<String>  getAddressString(int litter_id);
}
