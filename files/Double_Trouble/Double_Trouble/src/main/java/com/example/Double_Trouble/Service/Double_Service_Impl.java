package com.example.Double_Trouble.Service;

import com.example.Double_Trouble.Exception.Double_Exception;
import com.example.Double_Trouble.Model.Double;
import com.example.Double_Trouble.Repository.Double_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Double_Service_Impl implements Double_Service{
    @Autowired
    Double_Repo doubleRepo;
    @Override
    public Double addItem(Double item) {
        return doubleRepo.save(item);
    }

    @Override
    public Double getItemById(Integer id) throws Double_Exception {
        return doubleRepo.findById(id).orElseThrow(
                ()->new Double_Exception("No Such "+id+ "Found"));
    }

    @Override
    public List<Double> getitems() {
        return doubleRepo.findAll();
    }
    @Override
    public Double updateItem(Integer itemId, Double item) throws Double_Exception {
        Double item1=doubleRepo.findById(itemId).orElseThrow(
                ()-> new Double_Exception("No Such "+itemId+" Found")
        );
        item1.setModel(Objects.isNull(item.getModel())?item1.getModel():item.getModel());
        return doubleRepo.save(item1);
    }

    @Override
    public void deleteitem(Integer itemId) throws Double_Exception {
      Double it = doubleRepo.findById(itemId).orElseThrow(
              ()-> new Double_Exception("No such "+itemId+" Found")
      );
      doubleRepo.save(it);
    }
}
