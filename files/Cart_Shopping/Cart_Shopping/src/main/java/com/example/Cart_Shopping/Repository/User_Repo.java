package com.example.Cart_Shopping.Repository;

import com.example.Cart_Shopping.Model.User_id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repo extends JpaRepository<User_id,Integer> {
}
