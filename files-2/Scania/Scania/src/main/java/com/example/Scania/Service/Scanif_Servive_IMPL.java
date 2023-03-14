package com.example.Scania.Service;

import com.example.Scania.Exception.ItemNotFoundException;
import com.example.Scania.MODEL.Scanif;
import com.example.Scania.Repository.Scanif_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Scanif_Servive_IMPL implements Scanif_Service{
    @Autowired
    Scanif_Repo scanifRepo;

    @Override
    public Scanif addItem(Scanif item) {
        return scanifRepo.save(item);
    }

    @Override
    public Scanif getItemById(Integer id) throws ItemNotFoundException {
        return scanifRepo.findById(id).orElseThrow(
                ()->new ItemNotFoundException("No such "+id+" Found")
        );
    }

    @Override
    public List<Scanif> getItems() {
        return scanifRepo.findAll();
    }

    @Override
    public Scanif updateItem(Integer itemId, Scanif item) throws ItemNotFoundException {
        Scanif item1=scanifRepo.findById(itemId).orElseThrow(
                ()-> new ItemNotFoundException("No Such "+itemId+" Found")
        );
        item1.setName(Objects.isNull(item.getName())?item1.getName():item.getName());
        item1.setMileage(Objects.isNull(item.getMileage())? item1.getMileage():item.getMileage());
        item1.setPrice(Objects.isNull(item.getPrice())?item1.getPrice():item.getPrice());
        item1.setSpeed(Objects.isNull(item.getSpeed())?item1.getSpeed():item.getSpeed());
        return scanifRepo.save(item1);
    }

    @Override
    public void deleteItem(Integer itemId) throws ItemNotFoundException {
   Scanif it=scanifRepo.findById(itemId).orElseThrow(
           ()-> new ItemNotFoundException("No such "+itemId+" Found")
   );
   scanifRepo.delete(it);
    }
}
