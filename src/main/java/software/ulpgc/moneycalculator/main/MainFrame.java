package software.ulpgc.moneycalculator.main;

import software.ulpgc.moneycalculator.control.Command;
import software.ulpgc.moneycalculator.view.CurrencyDialog;
import software.ulpgc.moneycalculator.view.MoneyDialog;
import software.ulpgc.moneycalculator.view.MoneyDisplay;
import software.ulpgc.moneycalculator.view.swing.SwingCurrencyDialog;
import software.ulpgc.moneycalculator.view.swing.SwingMoneyDialog;
import software.ulpgc.moneycalculator.view.swing.SwingMoneyDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public MainFrame() throws HeadlessException, IOException {
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(ImageIO.read(Objects.requireNonNull(getClass().getResource("/calculadora.png"))));
        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(createMoneyDisplay());
        this.add(toolbar());
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    public CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    public MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
