package com.factory.controller;

import com.factory.details.Door;
import com.factory.services.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/door")
@RestController
public class DoorController {
    DoorService doorService;

    @Autowired
    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @PostMapping
    public ResponseEntity<Door> addDoor(@RequestBody Door door) {
        return ResponseEntity.ok(doorService.addDoor(door));
    }

    @GetMapping
    public Collection<Door> getDoors() {
        return doorService.getDoors();
    }

    @GetMapping("{id}")
    public ResponseEntity<Door> getDoor(@PathVariable("id") int id) {
        Door door = doorService.getDoor(id);
        if (door != null)
            return ResponseEntity.ok(door);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Door> deleteDoor(@PathVariable("id") int id) {
        Door door = doorService.deleteDoor(id);
        if (door != null)
            return ResponseEntity.ok(door);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Door> updateDoor(@RequestBody Door newDoor, @PathVariable("id") int id) {
        Door door = doorService.updateDoor(newDoor,id);
        if (door != null)
            return ResponseEntity.ok(door);
        return ResponseEntity.notFound().build();
    }
}

