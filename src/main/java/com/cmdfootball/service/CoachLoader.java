package com.cmdfootball.service;

import com.cmdfootball.model.Coach;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class CoachLoader {

    private static final Logger logger = Logger.getLogger(CoachLoader.class.getName());

    // 🔹 Thread-safe in-memory coach registry (replace with DB or external service)
    private static final List<Coach> coachRegistry = new CopyOnWriteArrayList<>();

    static {
        // 🔹 Sample coaches
        coachRegistry.add(new Coach(1L, "Mohamad", "mohamad@cmdfootball.com", "FED-001", List.of(101L, 102L)));
        coachRegistry.add(new Coach(2L, "Amina", "amina@cmdfootball.com", "FED-002", List.of(103L)));
    }

    /**
     * 🔹 Returns all registered coaches.
     */
    public static List<Coach> getAllCoaches() {
        return new ArrayList<>(coachRegistry);
    }

    /**
     * 🔹 Finds a coach by ID.
     */
    public static Optional<Coach> findById(Long id) {
        return coachRegistry.stream()
                .filter(coach -> coach.getId().equals(id))
                .findFirst();
    }

    /**
     * 🔹 Finds a coach by federation ID.
     */
    public static Optional<Coach> findByFederationId(String federationId) {
        return coachRegistry.stream()
                .filter(coach -> federationId.equalsIgnoreCase(coach.getFederationId()))
                .findFirst();
    }

    /**
     * 🔹 Finds a coach by email.
     */
    public static Optional<Coach> findByEmail(String email) {
        return coachRegistry.stream()
                .filter(coach -> coach.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    /**
     * 🔹 Finds coaches by federation prefix (e.g. "FED-").
     */
    public static List<Coach> findByFederationPrefix(String prefix) {
        List<Coach> result = new ArrayList<>();
        for (Coach coach : coachRegistry) {
            if (coach.getFederationId().startsWith(prefix)) {
                result.add(coach);
            }
        }
        return result;
    }

    /**
     * 🔹 Registers a new coach with validation.
     */
    public static boolean registerCoach(Coach coach) {
        if (coach == null || coach.getEmail() == null || coach.getFederationId() == null) {
            logger.warning("❌ Invalid coach data. Registration failed.");
            return false;
        }

        if (findByEmail(coach.getEmail()).isPresent()) {
            logger.warning("❌ Duplicate email: " + coach.getEmail());
            return false;
        }

        coachRegistry.add(coach);
        logger.info("✅ Registered coach: " + coach.getName() + " (" + coach.getFederationId() + ")");
        return true;
    }

    // 🔹 TODO: Replace in-memory registry with persistent DB or external service
}