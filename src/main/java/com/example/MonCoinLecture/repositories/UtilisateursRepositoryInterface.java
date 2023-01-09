package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateursRepositoryInterface extends JpaRepository<Utilisateurs, Integer> {

    Utilisateurs findById(int id);
    Utilisateurs findByAdresseMail(String adresseMail);
    Utilisateurs findByPseudo(String pseudo);
    Utilisateurs findByMotDePasse(String motDePasse);

}
