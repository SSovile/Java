package com.factory.services;


import com.factory.details.Door;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DoorService {
    AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, Door> doors = new HashMap<>();

    public Door addDoor(Door door){
        door.setId(id.incrementAndGet());
        doors.put(door.getId(), door);
        return door;
    }

    public Collection<Door> getDoors(){
        return doors.values();
    }

    public Door getDoor(int id){
        return doors.get(id);
    }

    public Door deleteDoor(int id){
        Door door = doors.get(id);
        if(door != null)
            doors.remove(id);
        return door;
    }

    public Door updateDoor(Door newDoor,int id){
        Door usedDoor = doors.get(id);
        if(usedDoor != null){
            newDoor.setId(id);
            return doors.replace(id, newDoor);
        }
        return null;
    }
}
