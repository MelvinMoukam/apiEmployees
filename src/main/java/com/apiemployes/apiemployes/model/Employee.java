package com.apiemployes.apiemployes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import static jakarta.persistence.GenerationType.IDENTITY;
@Data // génère automatiquement les gettes et setters puis le constructeur par défaut de la classe
@Entity // défini la classe comme table dans la base de donnée
@Table(name = "employees")
public class Employee {

        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String firstname;

        @Column(name = "last_name")
        private String lastname ;

        private String email;

        private String password;



}
