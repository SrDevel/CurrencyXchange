package controller;

import model.History;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryController {
    List<History> historyList = new ArrayList<>();
    public void saveHistoryMovement(String currency, String currencyTo, Double amount, Double result) {
        Date date = Date.from(new Date().toInstant());
        History history = new History(date, currency, currencyTo, amount, result);
        historyList.add(history);
    }

    public void printHistory() {
        StringBuilder historyString = new StringBuilder("");
        for (History history : historyList) {
            System.out.println(history.toString());
            historyString.append(history.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, historyString);
    }
}
