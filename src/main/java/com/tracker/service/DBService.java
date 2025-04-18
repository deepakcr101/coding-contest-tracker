package com.tracker.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tracker.model.Contest;

public class DBService {

    private static final String URL = "jdbc:mysql://localhost:3306/contest_tracker";
    private static final String USER = "contest_user";
    private static final String PASSWORD = "tracker123";

    private Connection conn;

    public DBService() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected.");
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
        }
    }

    public void saveContest(Contest contest) {
        String query = "INSERT INTO contests (platform, name, start_time, duration) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, contest.getPlatform());
            stmt.setString(2, contest.getName());
            stmt.setLong(3, contest.getStartTime());
            stmt.setLong(4, contest.getStartTime());
            stmt.executeUpdate();
            System.out.println("✔ Saved contest: " + contest.getName());
        } catch (SQLException e) {
            System.err.println("⚠️ Failed to save contest: " + e.getMessage());
        }
    }

    public List<Contest> getAllContests() {
        List<Contest> list = new ArrayList<>();
        String query = "SELECT * FROM contests ORDER BY start_time";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Contest c = new Contest();
                c.setPlatform(rs.getString("platform"));
                c.setName(rs.getString("name"));
                c.setStartTime(rs.getLong("start_time"));
                //c.setDurationSeconds(rs.getInt("duration"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Failed to fetch contests: " + e.getMessage());
        }

        return list;
    }
}
