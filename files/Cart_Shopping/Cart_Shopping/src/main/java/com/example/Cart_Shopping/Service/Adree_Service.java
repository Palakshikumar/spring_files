package com.example.Cart_Shopping.Service;

import com.example.Cart_Shopping.Exception.ItemNotFoundException;
import com.example.Cart_Shopping.Model.Address_id;

import java.util.List;

public interface Adree_Service
{
    Address_id addItem (Address_id item);
    Address_id getitembyId(Integer id)throws ItemNotFoundException;
    List<Address_id>getitems();
    Address_id updateitem(Integer itemId,Address_id item)throws ItemNotFoundException;
    void deleteitem(Integer itemId)throws ItemNotFoundException;
}
