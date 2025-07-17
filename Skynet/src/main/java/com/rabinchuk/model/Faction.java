package com.rabinchuk.model;

import lombok.Getter;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Faction {
    private final String name;
    private final Map<Details, Integer> inventory = new EnumMap<>(Details.class);
    private final AtomicInteger robots =  new AtomicInteger(0);

    public Faction(String name) {
        this.name = name;
        for (Details detail : Details.values()) {
            inventory.put(detail, 0);
        }
    }

    public void addDetails(List<Details> details) {
        synchronized (inventory) {
            details.forEach(detail -> inventory.put(detail, inventory.get(detail) + 1));
            buildRobot();
        }
    }

    private void buildRobot() {
        while (possibleToBuild()) {
            inventory.put(Details.HEAD, inventory.get(Details.HEAD) - 1);
            inventory.put(Details.TORSO, inventory.get(Details.TORSO) - 1);
            inventory.put(Details.FEET, inventory.get(Details.FEET) - 2);
            inventory.put(Details.HAND, inventory.get(Details.HAND) - 2);

            robots.incrementAndGet();
        }
    }

    private boolean possibleToBuild() {
        return inventory.get(Details.HEAD) >= 1
                && inventory.get(Details.TORSO) >= 1
                && inventory.get(Details.FEET) >= 2
                && inventory.get(Details.HAND) >=2;
    }
}
