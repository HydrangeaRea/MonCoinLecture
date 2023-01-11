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

    @PostMapping("/AffichageLivresRecherchesIllustrateur/{illustrateur}")
    public List<Livres> AffichageLivresRecherchesIllustrateur(@PathVariable ("illustrateur") String illustrateur) {
        List<Livres> listeLivresRecherches = livresRepositoryInterface.findByIllustrateur(illustrateur);
        return listeLivresRecherches;
    }
    @PostMapping("/AffichageLivresRecherchesTitre/{titre}")
    public List<Livres> AffichageLivresRecherchesTitre(@PathVariable ("titre") String titre) {
        List<Livres> listeLivresRecherches = livresRepositoryInterface.findByTitre(titre);
        return listeLivresRecherches;
    }
    @PostMapping("/AffichageLivresRecherchesAuteur/{auteur}")
    public List<Livres> AffichageLivresRecherchesAuteur(@PathVariable ("auteur") String auteur) {
        List<Livres> listeLivresRecherches = livresRepositoryInterface.findByAuteur(auteur);
        return listeLivresRecherches;
    }

    @GetMapping("/voirTousLesAvis/{pseudo}")
    public List<Avis> listeAvisParUtilisateur(@PathVariable ("pseudo") String pseudo){
        Utilisateurs user = utilisateursRepositoryInterface.findByPseudo(pseudo);
        return avisRepositoryInterface.findByUtilisateur(user);
    }

    @GetMapping("/voirTousLesLivres")
    public List<Livres> listeLivres(){
        return livresRepositoryInterface.findAll();
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
    /*@GetMapping("/trierAvisParUtilisateur/{pseudo}")
    public List<Avis> trierAvisParUtilisateur(@PathVariable ("pseudo") String pseudo){
        List<Avis> listeAvis= avisRepositoryInterface.findByUtilisateur(pseudo);
        return listeAvis;
    }*/
    @GetMapping("/trierAvisParLivre/{titreLivre}")
    public List<Avis> trierAvisParId(@PathVariable ("titreLivre") String titreLivre){
        return avisRepositoryInterface.findByLivre(titreLivre);
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
        Livres livres= new Livres("Dragon Ball tome 1", "Dragon Ball", "1/21", "lu", "Akira Toriyama", "Aucun", "Gallimard", "Shonen", "Manga", null, null,  "Bonjour");
        livresRepositoryInterface.save(livres);
        return livres;
    }

    @PostMapping("/ajoutUtilisateur")
    public String ajoutUtilisateur (@RequestBody Utilisateurs utilisateur) {
        if (utilisateur.getPseudo() != "" && utilisateur.getAdresseMail() != "" && utilisateur.getMotDePasse() != "") {
            if (utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo()) == null && utilisateursRepositoryInterface.findByAdresseMail(utilisateur.getAdresseMail()) == null) {
                utilisateur.setDateInscription(java.time.LocalDate.now());
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
        } else {
            return "Vous devez impérativement remplir un pseudo, une adresse mail et un mot de passe pour vous inscrire.";
        }
    }

    @PostMapping("/modificationCompteUtilisateur")
    public String modificationCompteUtilisateur (@RequestBody Utilisateurs utilisateur) {
        Utilisateurs utilAModifier = utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo());
        if (utilisateur.getAuteurFavori() != "") {
            utilAModifier.setAuteurFavori(utilisateur.getAuteurFavori());
        }
        if (utilisateur.getLivreFavori() != "") {
            utilAModifier.setLivreFavori(utilisateur.getLivreFavori());
        }
        if (utilisateur.getDescription() != "") {
            utilAModifier.setDescription(utilisateur.getDescription());
        }
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

    @PostMapping("/mesInformations")
    public Utilisateurs mesInformations(@RequestBody Utilisateurs utilisateur) {
        Utilisateurs monCompte = utilisateursRepositoryInterface.findByPseudo(utilisateur.getPseudo());
        return monCompte;
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
