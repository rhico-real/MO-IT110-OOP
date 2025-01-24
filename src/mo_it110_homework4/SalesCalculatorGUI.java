package mo_it110_homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculatorGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtPhonePrice, txtPhoneQuantity, txtRepairPrice, txtRepairHours;
    private JTextArea txtResult;

    public SalesCalculatorGUI() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Initialize components
        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {
        JLabel lblPhonePrice = new JLabel("Phone Price:");
        txtPhonePrice = new JTextField("500.0");
        JLabel lblPhoneQuantity = new JLabel("Quantity Sold:");
        txtPhoneQuantity = new JTextField("10");

        JLabel lblRepairPrice = new JLabel("Repair Price per Hour:");
        txtRepairPrice = new JTextField("50.0");
        JLabel lblRepairHours = new JLabel("Number of Hours:");
        txtRepairHours = new JTextField("5");

        JButton btnCalculate = new JButton("Calculate");
        JLabel lblResult = new JLabel("Total Sales:");
        txtResult = new JTextArea();
        txtResult.setEditable(false);

        add(lblPhonePrice);
        add(txtPhonePrice);
        add(lblPhoneQuantity);
        add(txtPhoneQuantity);
        add(lblRepairPrice);
        add(txtRepairPrice);
        add(lblRepairHours);
        add(txtRepairHours);
        add(btnCalculate);
        add(lblResult);
        add(txtResult);

        btnCalculate.addActionListener(new CalculateButtonListener());
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double phonePrice = Double.parseDouble(txtPhonePrice.getText());
                int phoneQuantity = Integer.parseInt(txtPhoneQuantity.getText());

                double repairPrice = Double.parseDouble(txtRepairPrice.getText());
                int repairHours = Integer.parseInt(txtRepairHours.getText());

                Item phone = new Phone(phonePrice, phoneQuantity);
                Item repair = new Repair(repairPrice, repairHours);

                txtResult.setText("Phone Sales: ₱" + phone.calculateSales() + "\n" +
                        "Repair Sales: ₱" + repair.calculateSales());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SalesCalculatorGUI.this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesCalculatorGUI::new);
    }
}