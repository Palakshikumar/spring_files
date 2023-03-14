package com.example.Double_Trouble.Controller;

import com.example.Double_Trouble.Model.Single;
import com.example.Double_Trouble.Service.Single_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Single_Controller
{
    @Autowired
    Single_service singleService;

    @PostMapping("/items")
    public ResponseEntity<Object>createitem(@RequestBody Single item){
        return new ResponseEntity<>(singleService.additem(item), HttpStatus.CREATED);
    }
    @GetMapping("items/{id}")
    public ResponseEntity<Single>getitem(@PathVariable ("id")Integer itemId){
        return  ResponseEntity.ok().body(singleService.getitemById(itemId));
    }

    @GetMapping("/items")
    public List<Single>getitems(){return singleService.getitems();}

    @PutMapping("/items/{id}")
    public ResponseEntity<Single>updateitem(@PathVariable("id")Integer itemId,@RequestBody Single item){
        return ResponseEntity.ok().body(singleService.updateitem(itemId,item));
    }
    @DeleteMapping("items/{id}")
    public ResponseEntity<Object>Deleteitem(@PathVariable("id")int itemId){
        singleService.deleteitem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }


}
