package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.beans.Livres;
import com.example.MonCoinLecture.repositories.*;

import com.example.MonCoinLecture.beans.Livres;
import com.example.MonCoinLecture.beans.*;
import com.example.MonCoinLecture.repositories.UtilisateursRepositoryInterface;
import com.example.MonCoinLecture.repositories.LivresRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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






    @GetMapping ("/ajoutLivresEnBaseTest")
    public String ajoutLivresEnBaseTest () {
        Livres livre1 = new Livres("Harry Potter à l'école des sorciers", "Harry Potter", "1/7", "Terminée",
                "J. K. Rowling", "NULL", "Gallimard", "Fantasy", "Roman",
                new Date("16/11/1998"), "src=img / harry_potter_tome_1.jpg", "Le jour de ses onze ans, " +
                "Harry Potter, un orphelin élevé par un oncle et une tante qui le détestent, voit son existence bouleversée. " +
                "Un géant vient le chercher pour l'emmener à Poudlard, la célèbre école de sorcellerie où une place l'attend " +
                "depuis toujours. Voler sur des balais, jeter des sorts, combattre les Trolls : Harry Potter se révèle un sorcier " +
                "vraiment doué. Mais quel mystère entoure donc sa naissance et qui est l'effroyable V..., " +
                "le mage dont personne n'ose prononcer le nom ?");
        livresRepositoriesInterface.save(livre1);
        return "OK";
    }

    @GetMapping ("/bonjour")
    public String bonjour () {
        return "bonjour";
    }




}
