package com.cmdfootball.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point for the CMD Football backend application.
 * Initializes Spring Boot and loads all configured components.
 */
@SpringBootApplication
public class CmdFootballApplication {

    private static final Logger logger = LoggerFactory.getLogger(CmdFootballApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CmdFootballApplication.class);

        // 🔹 Embedded startup banner
        app.setBanner((environment, sourceClass, out) -> {
            out.println("  ____ ____  __  __    ____            _       _     _       ");
            out.println(" / ___|  _ \\|  \\/  |  |  _ \\ ___  __ _(_) __ _| |__ | | ___  ");
            out.println("| |   | | | | |\\/| |  | |_) / _ \\/ _` | |/ _` | '_ \\| |/ _ \\ ");
            out.println("| |___| |_| | |  | |  |  __/  __/ (_| | | (_| | |_) | |  __/ ");
            out.println(" \\____|____/|_|  |_|  |_|   \\___|\\__, |_|\\__,_|_.__/|_|\\___| ");
            out.println("                                |___/                        ");
            out.println("CMD Football — Built for Coaches, Powered by Effort");
        });

        // 🔹 Run application
        Environment env = app.run(args).getEnvironment();
        String port = env.getProperty("server.port", "8080");
        String profile = String.join(", ", env.getActiveProfiles());

        logger.info("✅ CMD Football backend is up and running on port {} [{}]", port, profile.isEmpty() ? "default" : profile);

        // 🔹 Graceful shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("🛑 CMD Football backend is shutting down gracefully...");
        }));
    }
}
