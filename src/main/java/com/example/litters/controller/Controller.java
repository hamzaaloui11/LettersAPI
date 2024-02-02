package com.example.litters.controller;

import com.example.litters.Dto.LetterDto;
import com.example.litters.Entity.Adress;
import com.example.litters.Entity.Litter;
import com.example.litters.service.LitterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class Controller {

    private LitterService litterService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/litters")
    public List<Litter> getLitters(){
       return litterService.getLitters();
    }
   @GetMapping("/littersA")
    public List<LetterDto> getLittersandAdress(){
       return litterService.getLitters().stream().map(litter ->{
           LetterDto letterDto=modelMapper.map(litter,LetterDto.class);
           letterDto.setAdress(litterService.getAddressString(litter.getId()));
        return letterDto;
       }).collect(Collectors.toList());
    }

    @GetMapping("/adressById")
    public List<Litter> getAdress(){
        return litterService.getLitters();
    }

    @PostMapping("/litter")
    public int addLitter(@RequestBody Litter litter){
        return litterService.saveLitter(litter).getId();
    }

    @PostMapping("/adress")
    public int addAdress(@RequestBody Adress adress){
        return litterService.addAdress(adress).getId();
    }
    @PostMapping("/litter_adress")
    public void addLitter_Adress(@RequestBody Map<String, Integer> requestBody) {
        int litter_id = requestBody.get("litter_id");
        int adress_id = requestBody.get("address_id");

        System.out.println("litter_adress");
        litterService.insertAdressLitter(litter_id, adress_id);
    }


}
