package com.example.Double_Trouble.Service;

import com.example.Double_Trouble.Exception.Single_Exception;
import com.example.Double_Trouble.Model.Single;
import com.example.Double_Trouble.Repository.Single_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Single_Service_Impl implements Single_service{
    @Autowired
    Single_Repo singleRepo;
    @Override
    public Single additem(Single item) {
        return singleRepo.save(item);
    }
    @Override
    public Single getitemById(Integer id) throws Single_Exception {
        return singleRepo.findById(id).orElseThrow(
                ()->new Single_Exception("No Such " +id+" found")
        );
    }

    @Override
    public List<Single> getitems() {
        return singleRepo.findAll();
    }
    @Override
    public Single updateitem(Integer itemId, Single item){
        Single item1=singleRepo.findById(itemId).orElseThrow(
                ()->new Single_Exception("No Such "+itemId+" Found"));
        item1.setFather(Objects.isNull(item.getFather())?item1.getFather():item.getFather());
        item1.setMarks(Objects.isNull(item.getMarks())?item1.getMarks():item.getMarks());
        return singleRepo.save(item1);
    }
    @Override
    public void deleteitem(Integer itemId) {
     Single it =singleRepo.findById(itemId).orElseThrow(
             ()->new Single_Exception("No Such "+itemId+" Found"));
     singleRepo.save(it);
    }
}
