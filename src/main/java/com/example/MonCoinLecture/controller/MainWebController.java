package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.beans.*;
import com.example.MonCoinLecture.repositories.*;

import com.example.MonCoinLecture.beans.Livres;
import com.example.MonCoinLecture.beans.Utilisateurs;
import com.example.MonCoinLecture.repositories.UtilisateursRepositoryInterface;
import com.example.MonCoinLecture.repositories.LivresRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/API")
public class MainWebController {

    @Autowired
    private LivresRepositoryInterface livresRepositoryInterface;
    @Autowired
    private  UtilisateursRepositoryInterface utilisateursRepositoryInterface;
    @Autowired
    private AvisRepositoryInterface avisRepositoryInterface;

    @PostMapping("/ajouterAvis)")
    public String Ajouter_Avis(@RequestBody Avis avis1) {
        avisRepositoryInterface.save(avis1);
        return "OK";
    }
    @GetMapping("/triAvisParUtilisateur/{pseudo}")
    public String triAvisParUtilisateur(@PathVariable ("pseudo") String pseudo){
        List<Avis> listeAvis= avisRepositoryInterface.findByUtilisateur(pseudo);
    return "Ok";
    }

    @GetMapping("/triAvisParLivre/{livre}")
    public String triAvisParLivre(@PathVariable ("livre") String livre){
        List<Avis> listeAvis= avisRepositoryInterface.findByLivre(livre);
        return "Ok";
    }
    @GetMapping("/supprimerAvisParId/{Id}")
    public String supprimerAvisParId(@PathVariable ("Id") int Id){
        avisRepositoryInterface.findById(Id);
        return "Ok";
    }
    @GetMapping("/supprimerAvisUtilisateur/{pseudo}")
    public String supprimerAvisParId(@PathVariable ("pseudo") String pseudo){
        List<Avis> liste_suppressin = avisRepositoryInterface.deleteByUtilisateur(pseudo);
        return "Ok";
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
