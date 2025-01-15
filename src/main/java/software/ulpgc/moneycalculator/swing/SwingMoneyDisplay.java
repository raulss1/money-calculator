package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        // Establece la alineación del texto en el centro
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        // Opcional: Configura un tamaño preferido para el JLabel
        this.setPreferredSize(new Dimension(200, 100));
    }

    @Override
    public void show(Money money) {
        this.setText(money.toString());
        // Crea una ventana para mostrar el JLabel centrado
        JFrame frame = new JFrame("Money Display");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
