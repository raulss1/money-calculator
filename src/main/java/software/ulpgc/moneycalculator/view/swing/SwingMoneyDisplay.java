package software.ulpgc.moneycalculator.view.swing;

import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension(200, 100));
    }

    @Override
    public void show(Money money) {
        this.setText(money.toString());
        JFrame frame = new JFrame("Money Display");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
