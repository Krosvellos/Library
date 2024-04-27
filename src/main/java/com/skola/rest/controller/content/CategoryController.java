package com.skola.rest.controller.content;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skola.rest.dto.Categorydto;

@RestController
@RequestMapping(value ="/category")
public class CategoryController {

    @PostMapping("/create")
    ResponseEntity<String> createCategory(@RequestBody Categorydto category) {


        return new ResponseEntity<>("New category created", HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateCategory() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteCategory() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listCategory() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }



}
