package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.beans.Avis;
import com.example.MonCoinLecture.beans.Utilisateurs;
import com.example.MonCoinLecture.beans.Livres;

import com.example.MonCoinLecture.repositories.avisRepositoriesInterface;
import com.example.MonCoinLecture.repositories.livresRepositoriesInterface;
import com.example.MonCoinLecture.repositories.utilisateursRepositoriesInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/API")
public class MainWebController {

    @Autowired
    private livresRepositoriesInterface livresRepositoriesInterface;
    @Autowired
    private  utilisateursRepositoriesInterface utilisateursRepositoriesInterface;
    @Autowired
    private avisRepositoriesInterface avisRepositoriesInterface;

    @GetMapping("/ajouterAvis)")
    public String Ajouter_Avis(@RequestBody Avis avis1) {
            avisRepositoriesInterface.save(avis1);
            return "OK";
    }
}
