package com.example.Scania.Repository;

import com.example.Scania.MODEL.Scanif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Scanif_Repo extends JpaRepository<Scanif ,Integer> {
}
