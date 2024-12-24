import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IDCardGenerator extends JFrame {
    private JTextField nameField, idField, departmentField, positionField;
    private JLabel idCardLabel;

    public IDCardGenerator() {
        setTitle("ID Card Generator System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

      
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("ID Number:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        add(new JLabel("Position:"));
        positionField = new JTextField();
        add(positionField);

  
        JButton generateButton = new JButton("Generate ID Card");
        add(generateButton);

        idCardLabel = new JLabel();
        idCardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idCardLabel.setVerticalAlignment(SwingConstants.CENTER);
        idCardLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(idCardLabel);

        generateButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                generateIDCard();
            }
        });

        setVisible(true);
    }

    private void generateIDCard() {
        String name = nameField.getText();
        String idNumber = idField.getText();
        String department = departmentField.getText();
        String position = positionField.getText();

        String idCardContent = "<html><body style='text-align: center;'><h1>ID Card</h1>" +
                "<p>Name: " + name + "</p>" +
                "<p>ID Number: " + idNumber + "</p>" +
                "<p>Department: " + department + "</p>" +
                "<p>Position: " + position + "</p></body></html>";

        
        idCardLabel.setText(idCardContent);
    }

    public static void main(String[] args) {
        new IDCardGenerator();
    }
}
