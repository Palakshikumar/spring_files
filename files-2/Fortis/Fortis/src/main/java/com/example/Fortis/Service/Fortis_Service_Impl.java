package com.example.Fortis.Service;

import com.example.Fortis.Exception.ItemNotFOundException;
import com.example.Fortis.Model.Fortis;
import com.example.Fortis.Repository.Fortis_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class Fortis_Service_Impl implements Fortis_Service{

    @Autowired
    Fortis_Repo fortisRepo;
    @Override
    public Fortis addItem(Fortis item) {
        return fortisRepo.save(item);
    }

    @Override
    public Fortis getItemById(Integer id)  {
        return fortisRepo.findById(id).orElseThrow(
                ()->new ItemNotFOundException("No such "+id+" found")
        );
    }
    @Override
    public List<Fortis> getItems() {
        return fortisRepo.findAll();
    }

    @Override
    public Fortis updateItem(Integer itemId, Fortis item)  {
        Fortis item1= fortisRepo.findById(itemId).orElseThrow(
                ()->new ItemNotFOundException("No such "+itemId+" Found")
        );
        item1.setMarks(Objects.isNull(item.getMarks())?item1.getMarks():item.getMarks());
        item1.setName(Objects.isNull(item.getName())?item1.getName():item.getName());
        item1.setTotal(Objects.isNull(item.getTotal())?item1.getTotal():item.getTotal());
        return fortisRepo.save(item1);
    }

    @Override
    public void detleteItem(Integer itemId) throws ItemNotFOundException {
      Fortis it =fortisRepo.findById(itemId).orElseThrow(
              ()-> new ItemNotFOundException("No such "+itemId+" Found")
      ); fortisRepo.save(it);
    }
}
