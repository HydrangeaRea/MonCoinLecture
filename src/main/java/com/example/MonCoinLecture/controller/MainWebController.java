package com.example.MonCoinLecture.controller;

import com.example.MonCoinLecture.repositories.*;
import com.example.MonCoinLecture.beans.*;
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
        Livres livres= new Livres("furtifs", null, null, "lu", "Damasio", "Aucun", "La volte", "SF", "Roman", null,"", "Bonjour");
        livresRepositoryInterface.save(livres);
        return livres;
    }

    @PostMapping("/ajoutUtilisateur")
    public String ajoutUtilisateur (@RequestBody Utilisateurs utilisateur) {
        if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()) == null && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()) == null) {
            utilisateursRepositoryInterface.save(utilisateur);
            return "Félicitation vous êtes désormais membre de MonCoinLecture.";
        } else if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()) != null && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()) == null) {
            return "Ce pseudo est déjà utilisé, veuillez en choisir un autre.";
        }
        else if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()) == null && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()) != null) {
            return "Cette adresse mail est déjà associée à un compte.";
        }
        else {
            return "Vous possédez déjà un compte.";
        }
    }

    @PostMapping("/modificationCompteUtilisateur")
    public String modificationCompteUtilisateur (@RequestBody Utilisateurs utilisateur) {
        Utilisateurs utilAModifier = utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo());
        if (utilisateursRepositoryInterface.findByAuteurFavori(utilisateur.getAuteurFavori()) != null) {
            utilAModifier.setAuteurFavori(utilisateur.getAuteurFavori());
        } else utilAModifier.setAuteurFavori(utilAModifier.getAuteurFavori());
        utilAModifier.setDescription(utilisateur.getDescription());
        utilAModifier.setLivreFavori(utilisateur.getLivreFavori());
        utilisateursRepositoryInterface.save(utilAModifier);
        return "ok";
    }

    @PostMapping("/connexion")
    public String connexion(@RequestBody Utilisateurs utilisateur) {
        if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()) != null) {
            Utilisateurs utilisateurAConnecter = utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo());
            if (utilisateurAConnecter.getMotDePasse().equals(utilisateur.getMotDePasse())) {
                return "ok";
            }
            else {
                return "ko";
            }
        }
        else {
            return "ko";
        }
    }


    @GetMapping("/voirTousLesLivres")
    public List<Livres> listeLivres(){
        return livresRepositoryInterface.findAll();
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
        livresRepositoryInterface.save(livre1);
        return "OK";
    }

    @GetMapping ("/bonjour")
    public String bonjour () {
        return "bonjour";
    }




}
