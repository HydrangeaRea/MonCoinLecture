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

    @PostMapping("/Avis")
    public String Ajouter_Avis(@RequestBody Avis avis1) {
            avisRepositoryInterface.save(avis1);
            return "Votre avis a bien été posté. Merci pour votre contribution.";
        }


 /*   @PostMapping("/Avis")
    public String Ajouter_Avis_test(@RequestBody Avis avis1) {
        if (avisRepositoryInterface.findByTitre(titre).getUtilisateur() == null) {
            avisRepositoryInterface.save(avis1);
            return "Votre avis a bien été posté. Merci pour votre contribution.";
        }
        else {
            return ("Vous avez déjà posté un avis sur cet ouvrage. Cliquez sur \"Modifier mon avis\" si vous avez changer d'avis.");
        }
    }*/
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
        Livres livres= new Livres("Dragon Ball tome 1", "Dragon Ball", "1/21", "lu", "Akira Toriyama", "Aucun", "Gallimard", "Shonen", "Manga", null, "Bonjour");
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

  /*  @PostMapping("/modificationCompteUtilisateur")
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


*/



    @GetMapping ("/bonjour")
    public String bonjour () {
        return "bonjour";
    }




}
