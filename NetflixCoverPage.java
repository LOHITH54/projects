import java.awt.*;
import javax.swing.*;

class NetflixCoverPage {
    void NetflixCoverPage() {
        JFrame frame = new JFrame("Netflix Cover Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel logo = new JLabel("Netflix");
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(logo);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Main content area
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 5, 10, 10)); // 2 rows, 5 columns

        for (int i = 1; i <= 10; i++) {
            JButton movieButton = new JButton("Movie " + i);
            movieButton.setPreferredSize(new Dimension(100, 150));
            mainPanel.add(movieButton);
        }
        frame.add(mainPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(new JLabel("© 2024 Netflix Clone"));
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}