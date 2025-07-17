package com.rabinchuk;

import com.rabinchuk.model.Details;
import com.rabinchuk.model.Faction;
import com.rabinchuk.model.Factory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int DAY_DELAY_MS = 100;
    private static final int NIGHT_DELAY_MS = 200;

    public static void main(String[] args) {
        Factory factory = new Factory();
        Faction world = new Faction("World");
        Faction wednesday = new Faction("Wednesday");

        Thread factoryThread = new Thread(factory);
        factoryThread.start();
        try {
            for (int day = 1; day <= 100; day++) {
                System.out.println("Day: " + day);
                Thread.sleep(DAY_DELAY_MS);

                System.out.println("Night: " + day);

                try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
                    executor.execute(() -> stealDetails(factory, world));
                    executor.execute(() -> stealDetails(factory, wednesday));
                }

                System.out.println("Status after day: " + day);
                System.out.println("World: " + world.getRobots());
                System.out.println("Wednesday: " + wednesday.getRobots());
                Thread.sleep(NIGHT_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Simulation failed");
        } finally {
            factory.stop();
            try {
                factoryThread.join(1000);
            } catch (InterruptedException e) {
                System.err.println("Factory thread interrupted");
            }
        }

        printResults(world, wednesday);
    }

    private static void stealDetails(Factory factory, Faction faction) {
        List<Details> details = factory.getDetails(5);
        if (!details.isEmpty()) {
            faction.addDetails(details);
        }
    }

    private static void printResults(Faction world, Faction wednesday) {
        System.out.println();
        System.out.println("Status after 100 days:");
        System.out.println("World: " + world.getRobots() + " robots");
        System.out.println("Wednesday: " + wednesday.getRobots() + " robots");

        if (world.getRobots().get() == wednesday.getRobots().get()) {
            System.out.println("Result: draw");
        } else {
            System.out.println(
                    (world.getRobots().get() > wednesday.getRobots().get())
                            ? "Result: world wins"
                            : "Result: wednesday wins"
            );
        }
    }
}
