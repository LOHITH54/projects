import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirlineReservationSystemGUI {
    private JFrame frame;
    private JButton[] seatButtons = new JButton[10];
    private boolean[] seatStatus = new boolean[10];

    public AirlineReservationSystemGUI() {
        frame = new JFrame("Airline Reservation System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Airline Reservation System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(2, 5, 10, 10));

        for (int i = 0; i < 10; i++) {
            seatButtons[i] = new JButton("Seat " + (i + 1));
            seatButtons[i].setBackground(Color.GREEN);
            final int index = i; // Necessary for the lambda to work properly
            seatButtons[i].addActionListener(e -> toggleSeat(index));
            seatPanel.add(seatButtons[i]);
        }
        frame.add(seatPanel, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton viewAvailableButton = new JButton("View Available Seats");
        viewAvailableButton.addActionListener(e -> viewAvailableSeats());
        actionPanel.add(viewAvailableButton);

        JButton resetButton = new JButton("Reset All");
        resetButton.addActionListener(e -> resetSeats());
        actionPanel.add(resetButton);

        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void toggleSeat(int index) {
        if (seatStatus[index]) {
            int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Do you want to cancel the reservation for Seat " + (index + 1) + "?",
                "Cancel Reservation",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                seatStatus[index] = false;
                seatButtons[index].setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Reservation for Seat " + (index + 1) + " canceled.");
            }
        } else {
            seatStatus[index] = true;
            seatButtons[index].setBackground(Color.RED);
            JOptionPane.showMessageDialog(frame, "Seat " + (index + 1) + " booked successfully.");
        }
    }

    private void viewAvailableSeats() {
        StringBuilder availableSeats = new StringBuilder("Available Seats: ");
        boolean anyAvailable = false;
        for (int i = 0; i < seatStatus.length; i++) {
            if (!seatStatus[i]) {
                availableSeats.append((i + 1)).append(" ");
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            availableSeats = new StringBuilder("No seats are available.");
        }

        JOptionPane.showMessageDialog(frame, availableSeats.toString());
    }

    private void resetSeats() {
        for (int i = 0; i < seatStatus.length; i++) {
            seatStatus[i] = false;
            seatButtons[i].setBackground(Color.GREEN);
        }
        JOptionPane.showMessageDialog(frame, "All seats have been reset.");
    }

    public static void main(String[] args) {
        new AirlineReservationSystemGUI();
    }
}
