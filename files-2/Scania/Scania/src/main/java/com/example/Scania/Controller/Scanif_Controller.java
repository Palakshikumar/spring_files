package com.example.Scania.Controller;

import com.example.Scania.MODEL.Scanif;
import com.example.Scania.Service.Scanif_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Palakshi/v1")
public class Scanif_Controller
{
    @Autowired
    Scanif_Service scanifService;

    @PostMapping("/items")
    public ResponseEntity<Object> createItem(@RequestBody Scanif item){
        return new ResponseEntity<>(scanifService.addItem(item), HttpStatus.CREATED);
    }
    @GetMapping("items/{id}")
    public ResponseEntity<Object> getItem(@PathVariable("id")Integer itemid){
        return ResponseEntity.ok().body(scanifService.getItemById(itemid));
    }
    @GetMapping ("items")
    public List<Scanif> getitems(){return scanifService.getItems();}

    @PutMapping("items/{id}")
    public ResponseEntity<Object> updateitem(@PathVariable ("id") Integer itemId,@RequestBody Scanif item){
        return ResponseEntity.ok().body(scanifService.updateItem(itemId,item));
    }

    @DeleteMapping("items/{id}")
    public ResponseEntity<Object> deleteitem(@PathVariable("id") int itemId){
        scanifService.deleteItem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }
}
