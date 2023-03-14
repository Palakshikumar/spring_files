package com.example.Cart_Shopping.Service;

import com.example.Cart_Shopping.Exception.ItemNotFoundException;
import com.example.Cart_Shopping.Model.User_id;
import com.example.Cart_Shopping.Repository.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class User_Service_impl implements User_Service{

    @Autowired
    User_Repo userRepo;
    @Override
    public User_id additem(User_id item) {
        return userRepo.save(item);
    }

    @Override
    public User_id getitemById(Integer id) throws ItemNotFoundException {
        return userRepo.findById(id).orElseThrow(
                ()-> new ItemNotFoundException("No such items"+id+" Found")
        );
    }

    @Override
    public List<User_id> getitems() {
        return userRepo.findAll();
    }

    @Override
    public User_id updateitems(Integer itemId, User_id item) throws ItemNotFoundException {
        User_id item1=userRepo.findById(itemId).orElseThrow(
                ()-> new ItemNotFoundException("No such items"+itemId+" Found"));
        item1.setName(Objects.isNull(item.getName())?item1.getName():item.getName());
        item1.setEmail(Objects.isNull(item.getEmail())?item1.getEmail():item.getEmail());
        item1.setAddressId(Objects.isNull(item.getAddressId())?item1.getAddressId():item.getAddressId());
        return userRepo.save(item1);

    }

    @Override
    public void deleteitem(Integer itemId) throws ItemNotFoundException {
      User_id it =userRepo.findById(itemId).orElseThrow(
              ()-> new ItemNotFoundException("no such "+itemId+" Found")
      );
      userRepo.delete(it);
    }
}
