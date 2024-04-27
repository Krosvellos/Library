package com.skola.rest.controller.content;

import com.skola.rest.dto.Bookdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/book")
public class BookController {


    @PostMapping("/create")
    ResponseEntity<String> createBook(@RequestBody Bookdto book) {


        return new ResponseEntity<>("Book has been created", HttpStatus.OK);

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


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

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
