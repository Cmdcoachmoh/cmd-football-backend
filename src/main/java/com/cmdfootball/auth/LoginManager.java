package com.cmdfootball.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LoginManager {

    private static final Logger logger = Logger.getLogger(LoginManager.class.getName());

    // 🔹 Simulated in-memory user store (replace with DB or external service)
    private static final Map<String, String> userStore = new HashMap<>();

    static {
        // Sample users (username → password)
        userStore.put("coachmohamad", "securePass123");
        userStore.put("admin", "adminPass");
    }

    /**
     * 🔐 Validates user credentials.
     *
     * @param username the username attempting to log in
     * @param password the password provided
     * @return true if credentials are valid, false otherwise
     */
    public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            logger.warning("Login attempt with null credentials.");
            return false;
        }

        String storedPassword = userStore.get(username.toLowerCase());
        boolean success = storedPassword != null && storedPassword.equals(password);

        logger.info("Login attempt for '" + username + "': " + (success ? "SUCCESS" : "FAILURE"));
        return success;
    }

    /**
     * 🆕 Registers a new user.
     *
     * @param username the new username
     * @param password the new password
     * @return true if registration is successful, false if user already exists
     */
    public static boolean register(String username, String password) {
        if (username == null || password == null || password.length() < 6) {
            logger.warning("Invalid registration attempt.");
            return false;
        }

        String key = username.toLowerCase();
        if (userStore.containsKey(key)) {
            logger.warning("Registration failed: user '" + username + "' already exists.");
            return false;
        }

        userStore.put(key, password);
        logger.info("✅ Registered new user: " + username);
        return true;
    }

    // 🔹 TODO: Replace with persistent user repository or federation service
}