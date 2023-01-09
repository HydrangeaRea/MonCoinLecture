package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepositoryInterface extends JpaRepository<Utilisateurs, Integer> {

    Utilisateurs findById(int id);
    Utilisateurs findByAdresseMail(String adresseMail);

}
