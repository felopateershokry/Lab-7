package skillfrog;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Initialize your service (loads users and courses from JSON)
        StudentService studentService = new StudentService();

        // Choose a student ID to log in (must exist in users.json)
        int studentId = 1; // Example: Alice

        // Launch the dashboard on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            StudentDashboardFrame dashboard = new StudentDashboardFrame(studentId, studentService);
            dashboard.setVisible(true);
        });
    }
}
