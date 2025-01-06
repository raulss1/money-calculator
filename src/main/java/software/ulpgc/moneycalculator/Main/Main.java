package software.ulpgc.moneycalculator.Main;

import software.ulpgc.moneycalculator.Command;
import software.ulpgc.moneycalculator.Currency;
import software.ulpgc.moneycalculator.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.fixerws.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.fixerws.FixerExchangeRateLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame main = new MainFrame();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }
}
