package com.example.Double_Trouble.Service;

import com.example.Double_Trouble.Exception.Double_Exception;
import com.example.Double_Trouble.Model.Double;

import java.util.List;

public interface Double_Service
{
    Double addItem(Double item);
    Double getItemById(Integer id)throws Double_Exception;
    List<Double>getitems();
    Double updateItem(Integer itemId,Double item) throws Double_Exception;
    void deleteitem(Integer itemId) throws Double_Exception;
}
