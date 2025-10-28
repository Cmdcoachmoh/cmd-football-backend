package com.cmdfootball.ui.dashboard;

import com.cmdfootball.ui.login.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {

    public DashboardUI(String coachName) {
        setTitle("CMD Football Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔹 ASCII Branding
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
        banner.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(banner, BorderLayout.NORTH);

        // 🔹 Welcome Header + Quote
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        JLabel welcome = new JLabel("Welcome, Coach " + coachName + "!", SwingConstants.CENTER);
        welcome.setFont(new Font("SansSerif", Font.BOLD, 18));
        JLabel quote = new JLabel("“Effort is the heartbeat of progress.”", SwingConstants.CENTER);
        quote.setFont(new Font("SansSerif", Font.ITALIC, 14));
        quote.setForeground(new Color(0, 102, 204));
        headerPanel.add(welcome);
        headerPanel.add(quote);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerPanel, BorderLayout.PAGE_START);

        // 🔹 Main Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        buttonPanel.add(createButton("🧍 Players", e -> openPlayerManager()));
        buttonPanel.add(createButton("👥 Teams", e -> openTeamManager()));
        buttonPanel.add(createButton("📊 Reports", e -> openReports()));
        buttonPanel.add(createButton("🏅 Badges", e -> openBadgeTracker()));
        buttonPanel.add(createButton("⚙️ Settings", e -> openSettings()));
        buttonPanel.add(createButton("🚪 Logout", e -> confirmLogout()));

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createButton(String label, ActionListener action) {
        JButton button = new JButton(label);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.addActionListener(action);
        return button;
    }

    // 🔹 Navigation stubs
    private void openPlayerManager() {
        JOptionPane.showMessageDialog(this, "Opening Player Manager...");
    }

    private void openTeamManager() {
        JOptionPane.showMessageDialog(this, "Opening Team Manager...");
    }

    private void openReports() {
        JOptionPane.showMessageDialog(this, "Generating Reports...");
    }

    private void openBadgeTracker() {
        JOptionPane.showMessageDialog(this, "Launching Badge Tracker...");
    }

    private void openSettings() {
        JOptionPane.showMessageDialog(this, "Opening Settings...");
    }

    private void confirmLogout() {
        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            new LoginScreen();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardUI("Mohamad"));
    }
}