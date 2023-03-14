package com.example.Cart_Shopping.Controller;

import com.example.Cart_Shopping.Model.Address_id;
import com.example.Cart_Shopping.Service.Adree_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("Api/v1")
public class Adree_Control
{
  @Autowired
  Adree_Service adreeService;

  @PostMapping("/items")
  public ResponseEntity<Object>createItem(@RequestBody Address_id item){
      return new ResponseEntity<>(adreeService.addItem(item),HttpStatus.CREATED);
  }
  @GetMapping("/items/{id}")
  public ResponseEntity<Address_id>Getitem(@PathVariable ("id") Integer itemId){
    return ResponseEntity.ok().body(adreeService.getitembyId(itemId));
  }
  @GetMapping("/items")
  public List<Address_id>getitems(){return adreeService.getitems();}

  @PostMapping("items/{id}")
  public ResponseEntity<Address_id>updateitem(@PathVariable("id") Integer itemId , @RequestBody Address_id item){
    return ResponseEntity.ok(adreeService.updateitem(itemId,item));
  }
  @DeleteMapping("items/{id}")
  public ResponseEntity<Object>deleteitem(@PathVariable ("id") int itemId){
    adreeService.deleteitem(itemId);
    return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
  }
}
