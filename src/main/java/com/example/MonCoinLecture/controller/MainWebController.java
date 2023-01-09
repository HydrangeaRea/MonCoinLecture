package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.repositories.*;

import com.example.MonCoinLecture.beans.Avis;
import com.example.MonCoinLecture.beans.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/API")
public class MainWebController {

    @Autowired
    private LivresRepositoryInterface livresRepositoryInterface;
    @Autowired
    private  UtilisateursRepositoryInterface utilisateursRepositoryInterface;
    @Autowired
    private AvisRepositoryInterface avisRepositoryInterface;

    @GetMapping("/ajouterAvis)")
    public String Ajouter_Avis(@RequestBody Avis avis1) {
        avisRepositoryInterface.save(avis1);
        return "OK";
    }

    @PostMapping("/ajoutUtilisateur")
    public String ajoutUtilisateur (@RequestBody Utilisateurs utilisateur) {
        if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()).isEmpty() == true && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()).isEmpty() == true) {
            utilisateursRepositoryInterface.save(utilisateur);
            return "Félicitation vous êtes désormais membre de MonCoinLecture.";
        } else if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()).isEmpty() == false && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()).isEmpty() == true) {
            return "Ce pseudo est déjà utilisé, veuillez en choisir un autre.";
        }
        else if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()).isEmpty() == true && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()).isEmpty() == false) {
            return "Cette adresse mail est déjà associée à un compte.";
        }
        else {
            return "Vous possédez déjà un compte.";
        }
    }

    @PostMapping("/modificationCompteUtilisateur")
    public String modificationCompteUtilisateur (@RequestBody Utilisateurs utilisateur) {
        return "ok";
    }
}
