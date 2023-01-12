package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Livres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivresRepositoryInterface extends JpaRepository<Livres, Integer> {

    List<Livres> findByTitre (String titre);
    List<Livres> findByAuteur (String auteur);
    List<Livres> findByIllustrateur (String illustrateur);
    List<Livres> findByType (String type);
    Livres findById (int id);
}
