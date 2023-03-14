package com.example.Double_Trouble.Controller;

import com.example.Double_Trouble.Model.Double;
import com.example.Double_Trouble.Service.Double_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class Double_Controller
{
    @Autowired
    Double_Service doubleService;

    @PostMapping("/items")
    public ResponseEntity<Object>createitem(@RequestBody Double item){
        return new ResponseEntity<>(doubleService.addItem(item), HttpStatus.CREATED);
    }
    @GetMapping("/items/{id}")
    public ResponseEntity<Double> getitem(@PathVariable ("id")Integer itemId){
        return  ResponseEntity.ok().body(doubleService.getItemById(itemId));
    }

    @GetMapping("/items")
    public List<Double>getitems(){return doubleService.getitems();}

    @PutMapping("/items/{id}")
    public ResponseEntity<Double>updateitem(@PathVariable("id")Integer itemId,@RequestBody Double item){
        return ResponseEntity.ok().body(doubleService.updateItem(itemId,item));
    }
    @DeleteMapping("items/{id}")
    public ResponseEntity<Object>Deleteitem(@PathVariable("id")int itemId){
        doubleService.deleteitem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }


}
