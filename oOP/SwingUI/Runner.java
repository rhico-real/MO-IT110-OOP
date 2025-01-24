package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of the CalculatorGUI class
        CalculatorGUI calculatorGUI = new CalculatorGUI();

        // Set the content pane to the CalculatorGUI panel
        frame.setContentPane(calculatorGUI.panel1);

        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);

        // Add action listener to the calculateButton
        calculatorGUI.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input values from text fields
                try {
                    double phonePrice = Double.parseDouble(calculatorGUI.priceofthePhone.getText());
                    int qty = Integer.parseInt(calculatorGUI.quantity.getText());
                    double hourlyRate = Double.parseDouble(calculatorGUI.priceperHour.getText());
                    int hours = Integer.parseInt(calculatorGUI.totalHours.getText());

                    // Perform calculations
                    double totalPhonePrice = phonePrice * qty;
                    double totalHourlyRate = hourlyRate * hours;

                    // Display the result in totalSales field (or any other calculation logic you need)
                    double total = totalPhonePrice + totalHourlyRate;
                    calculatorGUI.totalSales.setText(String.format("%.2f", total));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(calculatorGUI.panel1, "Please enter valid numbers.");
                }
            }
        });
    }
}