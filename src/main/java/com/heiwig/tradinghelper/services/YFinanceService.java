package com.heiwig.tradinghelper.services;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

import static yahoofinance.YahooFinance.*;

public class YFinanceService {

    public static String getStockTimestamp(String stockName) {
        String result = "";
        try {
            Stock stock = get(stockName);
            stock.print();
            result = stock.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
