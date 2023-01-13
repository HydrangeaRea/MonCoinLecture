package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Avis;
import com.example.MonCoinLecture.beans.Livres;
import com.example.MonCoinLecture.beans.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AvisRepositoryInterface extends JpaRepository<Avis, Integer>, JpaSpecificationExecutor<Livres> {
    List<Avis> findByLivre(int Id);
    List<Avis> findByLivre (Livres livres);

    List<Avis> findByUtilisateur(Utilisateurs user);

    List<Avis> findByLivre(String titreLivre);

    List<Avis> deleteByUtilisateur(String pseudo);

}
