package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisRepositoryInterface extends JpaRepository<Avis, Integer> {
    Avis findById (int Id);
    List<Avis> findByUtilisateur (String Pseudo);
    List<Avis> findByLivre (String titreLivre);
    List<Avis> deleteByUtilisateur (String pseudo);

    Avis findByTitre ();
}
