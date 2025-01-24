package mo_it110_homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculatorGUI extends JFrame {
	private static final long serialVersionUID = 1L;

    public SalesCalculatorGUI() {
     
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));


        JLabel lblPhonePrice = new JLabel("Phone Price:");
        JTextField txtPhonePrice = new JTextField("500.0");
        JLabel lblPhoneQuantity = new JLabel("Quantity Sold:");
        JTextField txtPhoneQuantity = new JTextField("10");


        JLabel lblRepairPrice = new JLabel("Repair Price per Hour:");
        JTextField txtRepairPrice = new JTextField("50.0");
        JLabel lblRepairHours = new JLabel("Number of Hours:");
        JTextField txtRepairHours = new JTextField("5");

        // Button to calculate total sales
        JButton btnCalculate = new JButton("Calculate");
        JLabel lblResult = new JLabel("Total Sales:");
        JTextArea txtResult = new JTextArea();
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

      
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                 
                    double phonePrice = Double.parseDouble(txtPhonePrice.getText());
                    int phoneQuantity = Integer.parseInt(txtPhoneQuantity.getText());

                    double phoneTotal = phonePrice * phoneQuantity;
                   
                    double repairPrice = Double.parseDouble(txtRepairPrice.getText());
                    int repairHours = Integer.parseInt(txtRepairHours.getText());

                    double repairTotal = repairPrice * repairHours;

                    txtResult.setText("Phone Sales: ₱" + phoneTotal + "\n" +
                            "Repair Sales: ₱" + repairTotal);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SalesCalculatorGUI.this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesCalculatorGUI::new);
    }
}
