package org.vascoom.vascoomspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vascoom.vascoomspring.entities.Users;
import org.vascoom.vascoomspring.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/active")
    public ResponseEntity<List<Users>> getAlActivelUsers(
            @RequestParam(value = "skip", required = false, defaultValue = "") int skip,
            @RequestParam(value = "take", required = false, defaultValue = "") int take
    ) {
        return ResponseEntity.ok(usersService.findAllActiveUsers(skip,take));
    }
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(
            @RequestParam("skip") int skip,
            @RequestParam("take") int take
    ) {
        return ResponseEntity.ok(usersService.findAllActiveUsers(skip,take));
    }


    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.createUser(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users users, @PathVariable Long id) {
        return ResponseEntity.ok(usersService.updateUser(users, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.deleteUser(id));
    }
}
