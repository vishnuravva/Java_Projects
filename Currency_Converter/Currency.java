package Java_Projects.Currency_Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

public class Currency extends JFrame {


    JComboBox fromCurrency, toCurrency;
    private Map<String,Double> currencyRates;
    JLabel heading,resultLabel, resultValue,noteLabel;
    JTextField amountField;
    JPanel headingPanel,amountPanel,resultPanel, convertPanel, resultValuePanel;
    JButton convertBtn;
    Font font  = new Font("Roboto",Font.BOLD,20);

    Currency(){
        components();
        events();
    }
    private void components(){
        currencyRates = new HashMap<>();
        // values with respect to USD
        currencyRates.put("USD", 1.08);
        currencyRates.put("EUR", 0.93);
        currencyRates.put("GBP", 0.78);
        currencyRates.put("INR", 74.50);
        currencyRates.put("JPY", 110.15);
        currencyRates.put("AUD", 1.35);
        currencyRates.put("CAD", 1.25);
        currencyRates.put("CHF", 0.92);
        currencyRates.put("SGD", 1.34);
        currencyRates.put("KWD", 0.30);
        currencyRates.put("BHD", 0.38);
        currencyRates.put("OMR", 0.39);

        setTitle("Currency Converter");
        setLayout(new GridLayout(10, 2));
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        heading = new JLabel("Currency Conversion");
        heading.setFont(new Font("Roboto",Font.PLAIN,20));
        headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingPanel.add(heading);

// for adding margins  aside combobox
        fromCurrency = new JComboBox(currencyRates.keySet().toArray(new String[0]));
        fromCurrency.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        toCurrency = new JComboBox(currencyRates.keySet().toArray(new String[0]));
        toCurrency.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        amountField = new JTextField();
//        setPlaceholder(amountField,"Enter value");
        amountField.setPreferredSize(new Dimension(300,40));
amountField.setFont(font);
      amountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      amountPanel.add(amountField);


        resultLabel = new JLabel("Outcome: ");
        resultLabel.setFont(new Font("Roboto",Font.BOLD,20));
        resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);

        convertBtn = new JButton("Convert");
        convertPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        convertPanel.add(convertBtn);

        resultValue = new JLabel("0.00");
        resultValue.setFont(font);
        resultValuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultValuePanel.add(resultValue);

        JLabel noteLabel = new JLabel("This is just for project purposes, the currency values may change over time.");
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(headingPanel);
        add(new JLabel("From: "));
        add(fromCurrency);
        add(amountPanel);
        add(new JLabel("To: "));
        add(toCurrency);
        add(convertPanel);
        add(resultPanel);
        add(resultValuePanel);
        add(noteLabel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void events(){
convertBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!amountField.getText().isEmpty()) {
            String fromCurrencyText = (String) fromCurrency.getSelectedItem();
            String toCurrencyText = (String) toCurrency.getSelectedItem();
            System.out.println(fromCurrencyText);
            System.out.println(toCurrencyText);
            double amount = Double.parseDouble(amountField.getText());
            Double fromRate = null;
            Double toRate = null;
            for (Map.Entry<String, Double> entry : currencyRates.entrySet()) {
                String currency = entry.getKey();


                if (fromCurrencyText.equals(currency)) {
                    fromRate = entry.getValue();
                    System.out.println("From rate " + fromRate + " fromCurrency " + fromCurrencyText);
                }
                if (toCurrencyText.equals(currency)) {
                    toRate = entry.getValue();
                    System.out.println("to rate " + toRate + " toCurrency " + toCurrencyText);
                }
            }
            if (fromRate == null || toRate == null) {
                resultValue.setText("One or both of the currencies were not found");
            } else {

                double convertedAmount = (amount / fromRate) * toRate;
                resultValue.setText(String.format("%.2f", convertedAmount) + toCurrencyText);

            }

        }else {
            resultValue.setText("No amount enetered");
        }
    }
});
    }
//    public static void setPlaceholder(JTextField textField, String placeholder) {
//        textField.setForeground(Color.GRAY); // Set placeholder color
//        textField.setText(placeholder); // Set placeholder text initially
//
//        // Add FocusListener to handle placeholder behavior
//        textField.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (textField.getText().equals(placeholder)) {
//                    textField.setText(""); // Clear placeholder text when field is focused
//                    textField.setForeground(Color.BLACK); // Set text color to black
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (textField.getText().isEmpty()) {
//                    textField.setForeground(Color.GRAY); // Set placeholder color
//                    textField.setText(placeholder); // Restore placeholder text if field is empty
//                }
//            }
//        });
//    }
}
