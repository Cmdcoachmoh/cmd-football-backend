package com.cmdfootball.ui.login;

import com.cmdfootball.auth.LoginManager;
import com.cmdfootball.service.CoachLoader;
import com.cmdfootball.ui.dashboard.DashboardUI;
import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private JComboBox<String> languageSelector;

    public LoginScreen() {
        setTitle("CMD Football Login");
        setSize(420, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 🔹 ASCII Banner
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JTextArea banner = new JTextArea(
            "  ____  __  __ ____     _____           _        _ _       \n" +
            " / ___||  \\/  |  _ \\   |  ___|___  ___ | |_ __ _| | | ___  \n" +
            "| |    | |\\/| | | | |  | |_ / _ \\ \\/ _ \\| __/ _` | | |/ _ \\ \n" +
            "| |___ | |  | | |_| |  |  _| (_) >  __/| || (_| | | |  __/ \n" +
            " \\____||_|  |_|____/   |_|  \\___/ \\___| \\__\\__,_|_|_|\\___| \n" +
            "         C   M   D   F O O T B A L L"
        );
        banner.setEditable(false);
        banner.setFont(new Font("Monospaced", Font.PLAIN, 10));
        banner.setBackground(getBackground());
        banner.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(banner, gbc);

        // 🔹 Username
        gbc.gridy = 1; gbc.gridwidth = 1; gbc.gridx = 0;
        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(20);
        add(usernameField, gbc);

        // 🔹 Password
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        add(passwordField, gbc);

        // 🔹 Language Selector
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Language:"), gbc);
        gbc.gridx = 1;
        languageSelector = new JComboBox<>(new String[]{"English", "Français", "Español"});
        add(languageSelector, gbc);

        // 🔹 Status Label
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        statusLabel = new JLabel(" ");
        statusLabel.setForeground(Color.RED);
        add(statusLabel, gbc);

        // 🔹 Login Button
        gbc.gridy = 5;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.addActionListener(e -> handleLogin());
        add(loginButton, gbc);

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("⚠️ Please enter both username and password.");
            return;
        }

        boolean success = LoginManager.authenticate(username, password);
        if (success) {
            statusLabel.setForeground(Color.GREEN);
            statusLabel.setText("✅ Login successful. Welcome, " + username + "!");
            dispose();

            // 🔹 Launch dashboard
            new DashboardUI(username);

            // 🔹 Optional drill preview if coach has drills
            CoachLoader.findByEmail(username).ifPresent(coach -> {
                if (coach.getDrillIds() != null && !coach.getDrillIds().isEmpty()) {
                    new JugglingLevels();
                }
            });

        } else {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("❌ Invalid credentials. Please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}