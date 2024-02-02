package com.example.litters.Dto;

import com.example.litters.Entity.Adress;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class LetterDto {
    private Integer id;
    private String nom;
    private String senderAd;
    private Date date;
    private String receiverAd;
    private String contactPerson;
    private String subject;
    private String body;
    private String footnot;
    private List<String> adress;
}
