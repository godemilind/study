package com.iocs.spring.beans.trade;

import com.iocs.spring.beans.crud.Tutorial;
import com.iocs.spring.beans.trade.bo.Transaction;
import com.iocs.spring.beans.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradingController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/analyzeTransaction")
    public ResponseEntity<List<Transaction>> createTutorial(@RequestBody Transaction Transaction) {
        List transactions = tradeService.analyzeTransaction(Transaction);
        return ResponseEntity.ok(transactions);
    }

    public TradeService getTradeService() {
        return tradeService;
    }

    public void setTradeService(TradeService tradeService) {
        this.tradeService = tradeService;
    }
}
