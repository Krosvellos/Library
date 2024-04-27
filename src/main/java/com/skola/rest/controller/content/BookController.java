package com.skola.rest.controller.content;

import com.skola.rest.Database;
import com.skola.rest.dto.Admindto;
import com.skola.rest.dto.Bookdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.skola.rest.Database.adminHashMap;
import static com.skola.rest.Database.bookHashMap;

@RestController
@RequestMapping(value ="/book")
public class BookController {

    private ArrayList<UUID> bookUUIDs = new ArrayList<>();


    @PostMapping("/create")
    ResponseEntity<String> createBook(@RequestBody Bookdto book) {


        UUID uuid = UUID.randomUUID();
        bookUUIDs.add(uuid);
        bookHashMap.put(uuid, book);


        return new ResponseEntity<>("Book has been created: " + book.getName(), HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateBook() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteBook() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listBook() {

        List<Bookdto> bookValues = new ArrayList<Bookdto>(bookHashMap.values());
        StringBuilder responseBuilder = new StringBuilder("Books: ");

        for(Bookdto value : bookValues) {
            responseBuilder.append(value.toString()).append("\n");

        }

        return new ResponseEntity<>(responseBuilder.toString(), HttpStatus.OK);

    }

    @GetMapping("/reserved")
    ResponseEntity<String> getBookReservedState() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @PutMapping("/lend")
    ResponseEntity<String> lendBook() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @PutMapping("/return")
    ResponseEntity<String> returnBook() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

}
