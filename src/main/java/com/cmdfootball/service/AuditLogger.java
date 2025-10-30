package com.cmdfootball.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * AuditLogger tracks system events for accountability and diagnostics.
 */
public class AuditLogger {

    private static final List<AuditEntry> auditTrail = new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Logs a generic system event.
     *
     * @param actor   the user or system component performing the action
     * @param action  the action performed
     * @param context optional context or target (e.g., "Player #12", "LoginScreen")
     */
    public static void log(String actor, String action, String context) {
        AuditEntry entry = new AuditEntry(actor, action, context, LocalDateTime.now());
        auditTrail.add(entry);
        System.out.println(entry.format());
    }

    /**
     * Returns all audit entries.
     */
    public static List<AuditEntry> getAuditTrail() {
        return new ArrayList<>(auditTrail);
    }

    /**
     * Clears the audit trail (use with caution).
     */
    public static void clear() {
        auditTrail.clear();
    }

    /**
     * Internal class representing a single audit entry.
     */
    public static class AuditEntry {
        private final String actor;
        private final String action;
        private final String context;
        private final LocalDateTime timestamp;

        public AuditEntry(String actor, String action, String context, LocalDateTime timestamp) {
            this.actor = actor;
            this.action = action;
            this.context = context;
            this.timestamp = timestamp;
        }

        public String format() {
            return String.format("[%s] %s performed '%s' on %s",
                    formatter.format(timestamp),
                    actor,
                    action,
                    context != null ? context : "N/A");
        }

        // Getters for external use
        public String getActor() { return actor; }
        public String getAction() { return action; }
        public String getContext() { return context; }
        public LocalDateTime getTimestamp() { return timestamp; }
    }
}