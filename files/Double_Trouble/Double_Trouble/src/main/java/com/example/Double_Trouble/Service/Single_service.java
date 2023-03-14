package com.example.Double_Trouble.Service;

import com.example.Double_Trouble.Exception.Single_Exception;
import com.example.Double_Trouble.Model.Single;

import java.util.List;

public interface Single_service {
    Single additem (Single item);
    Single getitemById(Integer id) throws Single_Exception;
    List<Single>getitems();
    Single updateitem(Integer itemId,Single item) throws Single_Exception;
    void deleteitem(Integer itemId)throws Single_Exception;
}
