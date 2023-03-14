package com.example.Fortis.Controller;

import com.example.Fortis.Model.Fortis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("Palakshi/v1")
public interface Fortis_cont {
    @PostMapping
    ResponseEntity <Object >createitem(@RequestBody Fortis item);

    @GetMapping
    ResponseEntity<Fortis>getitem(@PathVariable("id")Integer itemId);

    @GetMapping
    List<Fortis>getitems();

    @PutMapping
    ResponseEntity<Fortis>updateitem(@PathVariable("id")Integer itemId,@RequestBody Fortis item);

    @DeleteMapping
    ResponseEntity<Object>deleteitem(@PathVariable("id") int itemId);
}
