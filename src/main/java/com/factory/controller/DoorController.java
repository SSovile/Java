package com.factory.controller;

import com.factory.details.Door;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/door")
public class DoorController {
    int counter = 0;
    private final Map<Integer, Door> doors = new HashMap<>();

    @PostMapping
    public ResponseEntity<Object> addDoor(@RequestBody Door door){
        door.setId(counter++);
        doors.put(door.getId(), door);
        return ResponseEntity.ok(Collections.singletonMap("id", door.getId()));
    }

    @GetMapping
    public Collection<Door> getDoors(){
        return doors.values();
    }

    @GetMapping("{id}")
    public ResponseEntity<Door> getDoor(@PathVariable("id") int id){
        Door door = doors.get(id);
        if(door != null)
            return ResponseEntity.ok(door);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDoor(@PathVariable("id") int id){
        Door door = doors.get(id);
        if(door != null) {
            doors.remove(id);
            return ResponseEntity.ok(Collections.singletonMap("id", id));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Door> updateDoor(@RequestBody Door newDoor, @PathVariable("id") int id){
        Door usedDoor = doors.get(id);
        if(usedDoor != null){
            newDoor.setId(id);
            doors.replace(id, newDoor);
            return ResponseEntity.ok(usedDoor);
        }
        return ResponseEntity.notFound().build();
    }


