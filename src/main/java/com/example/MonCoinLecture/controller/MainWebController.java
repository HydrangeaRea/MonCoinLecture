package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.repositories.*;
import com.example.MonCoinLecture.beans.*;
import com.example.MonCoinLecture.repositories.UtilisateursRepositoryInterface;
import com.example.MonCoinLecture.repositories.LivresRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @PostMapping("/Avis)")
    public String Ajouter_Avis(@RequestBody Avis avis1) {
        avisRepositoryInterface.save(avis1);
        return "OK";
    }
    @GetMapping("/supprimerAvisParUtilisateur/{pseudo}")
    public String supprimerAvisParUtilisateur(@PathVariable ("pseudo") String pseudo){
        avisRepositoryInterface.deleteByUtilisateur(pseudo);
        return "OK";
    }
    @GetMapping("/supprimerAvisParId/{Id}")
    public String supprimerAvisParId(@PathVariable ("Id") int Id){
        avisRepositoryInterface.deleteById(Id);
        return "OK";
    }
    @GetMapping("/trierAvisParUtilisateur/{pseudo}")
    public List<Avis> trierAvisParUtilisateur(@PathVariable ("pseudo") String pseudo){
        List<Avis> listeAvis= avisRepositoryInterface.findByUtilisateur(pseudo);
        return listeAvis;
    }
    @GetMapping("/trierAvisParLivre/{titreLivre}")
    public List<Avis> trierAvisParId(@PathVariable ("titreLivre") String titreLivre){
        return avisRepositoryInterface.findByLivre(titreLivre);
    }
    @GetMapping("/trierAvisParId/{Id}")
    public Avis trierAvisParId(@PathVariable ("Id") int Id){
        return avisRepositoryInterface.findById(Id);
    }
    @GetMapping("/tousLesAvis")
    public List<Avis> tousLesAvis(){
        return avisRepositoryInterface.findAll();
    }
    @GetMapping("/modifierAvis/{titreLivre}")
    public String modifierAvis(@PathVariable("titreLivre") String titreLivre){
        avisRepositoryInterface.findByLivre(titreLivre);
        if (avisRepositoryInterface.findByLivre(titreLivre).isEmpty()== true && avisRepositoryInterface.findByLivre(titreLivre.toUpperCase()).isEmpty()== true){
            return ("Vous n'avez posté aucun commentaire sur cet ouvrage.");
        }
        else {
            return "N'oubliez pas d'enregistrer vos modifications.";
        }

    }

    @GetMapping("/ajouterUnLivre")
    public Livres ajout_livre(){
        Livres livres= new Livres("furtifs", null, null, "lu", "Damasio", "Aucun", "La volte", "SF", "Roman", null, "Bonjour");
        livresRepositoryInterface.save(livres);
        return livres;
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







    @GetMapping ("/bonjour")
    public String bonjour () {
        return "bonjour";
    }




}
