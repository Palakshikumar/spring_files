package com.example.Cart_Shopping.Service;

import com.example.Cart_Shopping.Exception.ItemNotFoundException;
import com.example.Cart_Shopping.Model.Address_id;
import com.example.Cart_Shopping.Repository.Adress_Repo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class Adres_Service_Impl implements Adree_Service{
    @Autowired
    Adress_Repo adressRepo;


    @Override
    public Address_id addItem(Address_id item) {
        return adressRepo.save(item);
    }

    @Override
    public Address_id getitembyId(Integer id) throws ItemNotFoundException {
        return adressRepo.findById(id).orElseThrow(
                ()-> new ItemNotFoundException("No Such item "+id+ " Found")
        );
    }

    @Override
    public List<Address_id> getitems() {
        return adressRepo.findAll();
    }

    @Override
    public Address_id updateitem(Integer itemId, Address_id item) throws ItemNotFoundException {
        Address_id item1 =adressRepo.findById(itemId).orElseThrow(
                ()-> new ItemNotFoundException("no such item "+itemId+" Found")
        );
        item1.setName(Objects.isNull(item.getName())?item1.getName():item.getName());
        return adressRepo.save(item1);
    }

    @Override
    public void deleteitem(Integer itemId) throws ItemNotFoundException {
    Address_id it =adressRepo.findById(itemId).orElseThrow(
            ()-> new ItemNotFoundException("No Such item "+itemId+" Found"));
     adressRepo.delete(it);
    }
}
