package com.example.Fortis.Repository;

import com.example.Fortis.Model.Fortis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Fortis_Repo extends JpaRepository <Fortis,Integer> {
}
