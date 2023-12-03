package com.aston.stockapp.api;

import com.aston.stockapp.domain.asset.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stocks")
public class YahooFinanceController {

    private final YahooFinanceService yahooFinanceService;

    @GetMapping("/{symbol}")
    public String getStockData(@PathVariable String symbol, Model model) {
        Stock stock = yahooFinanceService.fetchStockData(symbol);
        model.addAttribute("stock", stock);
        return "stock";
    }

    @Autowired
    public YahooFinanceController(YahooFinanceService yahooFinanceService) {
        this.yahooFinanceService = yahooFinanceService;
    }
}