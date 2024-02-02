package com.example.litters.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Litter implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nom;
   private String senderAd;
   @Temporal(TemporalType.DATE)
   private Date date;
   private String receiverAd;
   private String contactPerson;
   private String subject;
   @Column(length = 1000)
   private String body;
   private String footnot;
   @OneToMany
   private List<Adress> adress;

}
