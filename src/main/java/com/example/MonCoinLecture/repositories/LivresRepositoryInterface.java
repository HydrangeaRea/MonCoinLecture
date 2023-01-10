package com.example.MonCoinLecture.repositories;

import com.example.MonCoinLecture.beans.Livres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivresRepositoryInterface extends JpaRepository<Livres, Integer> {

}
