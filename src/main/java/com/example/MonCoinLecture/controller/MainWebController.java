package com.example.MonCoinLecture.controller;


import com.example.MonCoinLecture.beans.Livres;
import com.example.MonCoinLecture.beans.Utilisateurs;
import com.example.MonCoinLecture.repositories.UtilisateursRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/API")
public class MainWebController {

    @Autowired
    private UtilisateursRepositoryInterface utilisateursRepositoryInterface;


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
        utilAModifier.setDescription(utilisateur.getDescription());
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

}
