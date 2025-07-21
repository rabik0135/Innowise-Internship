package com.rabinchuk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Factory implements Runnable {
    private static final int MAX_DETAILS_PER_DAY = 10;
    private final BlockingQueue<Details> details = new LinkedBlockingQueue<>();
    private final Random random = new Random();
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                if (details.size() < MAX_DETAILS_PER_DAY) {
                    details.put(getRandomDetail());
                }
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public List<Details> getDetails(int maxParts) {
        List<Details> detailsList = new ArrayList<>();
        details.drainTo(detailsList, maxParts);
        return detailsList;
    }

    private Details getRandomDetail() {
        return Details.values()[random.nextInt(Details.values().length)];
    }

    public void stop() {
        running = false;
    }
}
