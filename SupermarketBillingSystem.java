import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupermarketBillingSystem extends JFrame {
    private JTextField itemField, priceField, quantityField, totalField;
    private JTextArea billArea;
    private JButton addButton, clearButton, printButton;
    private double totalAmount = 0.0;

    public SupermarketBillingSystem() {
        setTitle("Supermarket Billing System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Item Name:"));
        itemField = new JTextField();
        add(itemField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Total:"));
        totalField = new JTextField();
        totalField.setEditable(false);
        add(totalField);

        billArea = new JTextArea(10, 30);
        billArea.setEditable(false);
        add(new JScrollPane(billArea));
        addButton = new JButton("Add Item");
        clearButton = new JButton("Clear");
        printButton = new JButton("Print Bill");

        add(addButton);
        add(clearButton);
        add(printButton);

        
        addButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        clearButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        printButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });

        setVisible(true);
    }

    private void addItem() {
        String itemName = itemField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        double total = price * quantity;

        totalAmount += total;
        totalField.setText(String.valueOf(totalAmount));

        billArea.append(itemName + "\t" + price + "\t" + quantity + "\t" + total + "\n");

        clearFields();
    }

    private void clearFields() {
        itemField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    private void printBill() {
        JOptionPane.showMessageDialog(this, "Bill Printed Successfully!");
        billArea.setText("");
        totalField.setText("");
        totalAmount = 0.0;
    }

    public static void main(String[] args) {
        new SupermarketBillingSystem();
    }
}
