package com.example.Cart_Shopping.Controller;

import com.example.Cart_Shopping.Model.User_id;
import com.example.Cart_Shopping.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
@RequestMapping
@RestController("User/v1")
public class User_controller
{
    @Autowired
    User_Service userService;

    @PostMapping("/items")
    public ResponseEntity<Object>createitem(@RequestBody User_id item){
        return new ResponseEntity<>(userService.additem(item), HttpStatus.CREATED);
    }
    @GetMapping("items/{id}")
    public ResponseEntity<User_id> getitem(@PathVariable("id")Integer itemId){
        return  ResponseEntity.ok().body(userService.getitemById(itemId));
    }

    @GetMapping("/items")
    public List<User_id>getitems(){return userService.getitems();}

    @PostMapping("items/{id}")
    public ResponseEntity<User_id>updateitem(@PathVariable("id") Integer itemId ,@RequestBody User_id item){
        return ResponseEntity.ok((userService.updateitems(itemId,item)));
    }
    @DeleteMapping("items/{id}")
    public ResponseEntity<Object>deleteitem(@PathVariable ("id") int itemId){
        userService.deleteitem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }


}
