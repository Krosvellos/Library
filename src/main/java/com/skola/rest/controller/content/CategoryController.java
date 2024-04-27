package com.skola.rest.controller.content;


import com.skola.rest.Database;
import com.skola.rest.dto.Admindto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skola.rest.dto.Categorydto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.skola.rest.Database.adminHashMap;
import static com.skola.rest.Database.categoryHashMap;

@RestController
@RequestMapping(value ="/category")
public class CategoryController {


    private ArrayList<UUID> categoryUUIDs = new ArrayList<>();


    @PostMapping("/create")
    ResponseEntity<String> createCategory(@RequestBody Categorydto category) {

        UUID uuid = UUID.randomUUID();
        categoryUUIDs.add(uuid);
        categoryHashMap.put(uuid, category);

        return new ResponseEntity<>("New category created: "+category.getName(), HttpStatus.OK);

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

        List<Categorydto> categoryValues = new ArrayList<Categorydto>(categoryHashMap.values());
        StringBuilder responseBuilder = new StringBuilder("Categories: ");

        for(Categorydto value : categoryValues) {
            responseBuilder.append(value.toString()).append("\n");

        }

        return new ResponseEntity<>(responseBuilder.toString(), HttpStatus.OK);

    }



}
