package com.example.Fortis.Service;

import com.example.Fortis.Exception.ItemNotFOundException;
import com.example.Fortis.Model.Fortis;

import java.util.List;

public interface Fortis_Service {
    Fortis addItem (Fortis item);
    Fortis getItemById(Integer id) throws ItemNotFOundException;

    List<Fortis>getItems();
    Fortis updateItem(Integer itemId,Fortis item) throws ItemNotFOundException;

    void detleteItem (Integer itemId) throws ItemNotFOundException;

}
