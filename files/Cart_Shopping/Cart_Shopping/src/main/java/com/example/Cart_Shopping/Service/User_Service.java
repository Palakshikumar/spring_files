package com.example.Cart_Shopping.Service;

import com.example.Cart_Shopping.Exception.ItemNotFoundException;
import com.example.Cart_Shopping.Model.User_id;

import java.util.List;

public interface User_Service
{
    User_id additem (User_id item);
    User_id getitemById(Integer id) throws ItemNotFoundException;

    List<User_id>getitems();

    User_id updateitems(Integer itemId,User_id item) throws ItemNotFoundException;
    void deleteitem(Integer itemId) throws ItemNotFoundException;

}
