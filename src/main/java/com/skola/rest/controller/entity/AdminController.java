package com.skola.rest.controller.entity;

import com.skola.rest.Database;
import com.skola.rest.dto.Admindto;
import com.skola.rest.dto.Userdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.skola.rest.Database.adminHashMap;
import static com.skola.rest.Database.userHashMap;

@RestController
@RequestMapping(value ="/admin")
public class AdminController {

    private ArrayList<UUID> adminUUIDs = new ArrayList<>();

    @PostMapping("/create")
    ResponseEntity<String> createAdmin(@RequestBody Admindto admin) {

        UUID uuid = UUID.randomUUID();

        for (Map.Entry<UUID, Admindto> entry : Database.adminHashMap.entrySet()) {
            Admindto adminValue = entry.getValue();

            if (adminValue != null && adminValue.getEmail().equals(admin.getEmail())) {
                return new ResponseEntity<>("This admin already exists!", HttpStatus.NOT_FOUND);
            }
        }

        adminUUIDs.add(uuid);
        adminHashMap.put(uuid, admin);



        return new ResponseEntity<>("Admin created: "+ admin.getId(), HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listAdmin() {

        List<Admindto> adminValues = new ArrayList<Admindto>(adminHashMap.values());
        StringBuilder responseBuilder = new StringBuilder("Admins: ");

        for(Admindto value : adminValues) {
            responseBuilder.append(value.toString()).append("\n");

        }

        return new ResponseEntity<>(responseBuilder.toString(), HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteAdmin(@RequestBody Map<String, String> requestBody) {
        String id = requestBody.get("id");
        UUID adminId = UUID.fromString(id);
        for(Map.Entry<UUID, Admindto> entry: adminHashMap.entrySet()) {
            Admindto admin = entry.getValue();
            if (admin != null && admin.getId().equals(adminId)){
                adminHashMap.remove(admin.getId());
                System.out.println(adminHashMap);
                return new ResponseEntity<>("Admin has been deleted!",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("There is no such admin.", HttpStatus.NOT_FOUND);

    }

    @GetMapping("listone")
    ResponseEntity<String> getAdmin(@RequestBody Map<String, String> requestBody) {

        String email = requestBody.get("email");

        for(Map.Entry<UUID, Admindto> entry: adminHashMap.entrySet()) {
            Admindto admin = entry.getValue();
            if (admin != null && admin.getEmail().equals(email)){
                return new ResponseEntity<>("Admin email: "+ admin.getEmail() + ", UserUUID: "+ admin.getId(),HttpStatus.OK);

            }
        }

        return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);

    }

}
