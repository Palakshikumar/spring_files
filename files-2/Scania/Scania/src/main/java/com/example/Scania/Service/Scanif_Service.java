package com.example.Scania.Service;

import com.example.Scania.Exception.ItemNotFoundException;
import com.example.Scania.MODEL.Scanif;

import java.util.List;

public interface Scanif_Service {
    Scanif addItem (Scanif item);
    Scanif getItemById(Integer id) throws ItemNotFoundException;
    List <Scanif> getItems();
    Scanif updateItem(Integer itemId,Scanif item) throws ItemNotFoundException;
    void  deleteItem(Integer itemId)throws ItemNotFoundException;
}
