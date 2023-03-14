package com.example.Fortis.Controller;

import com.example.Fortis.Model.Fortis;
import com.example.Fortis.Service.Fortis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Palakshi/v1")
public class Fortis_Controller implements Fortis_cont{
    @Autowired
    Fortis_Service fortisService;

/*
   @PostMapping("items")
    public ResponseEntity<Fortis> createItem(@RequestBody Fortis item){

    }
*/

    @Override
    @PostMapping("/items")
    public ResponseEntity<Object> createitem(Fortis item) {
        return new ResponseEntity<>(fortisService.addItem(item),HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/items/{id}")
    public ResponseEntity<Fortis> getitem(Integer itemId) {
        return ResponseEntity.ok().body(fortisService.getItemById(itemId));
    }

    @Override
    @GetMapping("/items")
    public List<Fortis> getitems() {
        return fortisService.getItems();
    }

    @Override
    @PutMapping("items/{id}")
    public ResponseEntity<Fortis> updateitem(Integer itemId, Fortis item) {
        return ResponseEntity.ok().body(fortisService.updateItem(itemId,item));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Object> deleteitem(int itemId) {
        fortisService.detleteItem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }
}
