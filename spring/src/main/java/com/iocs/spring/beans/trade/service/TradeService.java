package com.iocs.spring.beans.trade.service;

import com.iocs.spring.beans.trade.bo.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TradeService {

    private Double BROKERAGE_RATE = 0.03;

    private Double MAX_BROKERAGE = 20.0;

    private Double EXCHANGE_TXN_CHARGE = 0.07;

    private Double GST = 0.13;

    private Double STAMP_DUTY = 0.03;

    private Double DEFAULT_STOP_LOSS = 2.0;

    public List<Transaction> analyzeTransaction(Transaction transaction){
        List transactions = new LinkedList();
        transactions.add(analyzeBuyTransaction(getTransactionObject(transaction)));
        transactions.add(analyzeShortSellTransaction(getTransactionObject(transaction)));
        List<Transaction> test = new ArrayList<>();
        boolean breakMe = false;
        while(true){
            test.add(new Transaction());
            if(breakMe){
                break;
            }
        }
        return transactions;
    }

    public Transaction getTransactionObject(Transaction transaction ){
        Transaction transactionCopy = new Transaction();
        transactionCopy.setInvestmentAmount(transaction.getInvestmentAmount());
        transactionCopy.setCurrentPrice(transaction.getCurrentPrice());
        transactionCopy.setExpectedProfit(transaction.getExpectedProfit());
        transactionCopy.setStopLossPer(transaction.getStopLossPer());
        return transactionCopy;
    }

    public Transaction analyzeBuyTransaction(Transaction transaction){
        transaction.setShareCount(transaction.getInvestmentAmount()/transaction.getCurrentPrice());
        Double simpleBuyPrice = transaction.getInvestmentAmount()-transaction.getExpectedProfit()/transaction.getShareCount();
        Double buyBrokerage = (transaction.getInvestmentAmount()+transaction.getExpectedProfit()*0.03)/100;
        if(buyBrokerage>MAX_BROKERAGE)
            buyBrokerage = MAX_BROKERAGE;

        Double sellBrokerage = (transaction.getInvestmentAmount()+transaction.getExpectedProfit()*0.03)/100;
        if(sellBrokerage>MAX_BROKERAGE)
            sellBrokerage = MAX_BROKERAGE;

        Double brokerage = buyBrokerage + sellBrokerage;
        Double txnCharge = EXCHANGE_TXN_CHARGE * transaction.getShareCount();
        Double gst =  GST * transaction.getShareCount();
        Double stampDuty = STAMP_DUTY * transaction.getShareCount();
        Double totalTaxAndCharges = brokerage + txnCharge + gst + stampDuty;
        Double sellPrice = (stampDuty + gst + txnCharge + brokerage + transaction.getInvestmentAmount()+transaction.getExpectedProfit())/transaction.getShareCount();
        double stopLossPer = (transaction.getStopLossPer() != null || transaction.getStopLossPer() != 0)?transaction.getStopLossPer():DEFAULT_STOP_LOSS;
        Double stopLoss = ((transaction.getInvestmentAmount()-(transaction.getInvestmentAmount()*stopLossPer/100))+totalTaxAndCharges)/transaction.getShareCount();

        transaction.setBrokerage(brokerage);
        transaction.setTxnCharge(txnCharge);
        transaction.setGst(gst);
        transaction.setStampDuty(stampDuty);
        transaction.setTotalTaxAndCharges(totalTaxAndCharges);
        transaction.setSellingPrice(sellPrice);
        transaction.setStopLoss(stopLoss);
        transaction.setTransactionType(Transaction.TYPE.BUY);
        return transaction;
    }

    public Transaction analyzeShortSellTransaction(Transaction transaction){
        transaction.setShareCount(transaction.getInvestmentAmount()/transaction.getCurrentPrice());
        Double simpleSellingPrice = transaction.getInvestmentAmount()+transaction.getExpectedProfit()/transaction.getShareCount();
        Double buyBrokerage = (transaction.getInvestmentAmount()+transaction.getExpectedProfit()*0.03)/100;
        if(buyBrokerage>MAX_BROKERAGE)
            buyBrokerage = MAX_BROKERAGE;

        Double sellBrokerage = (transaction.getInvestmentAmount()+transaction.getExpectedProfit()*0.03)/100;
        if(sellBrokerage>MAX_BROKERAGE)
            sellBrokerage = MAX_BROKERAGE;

        Double brokerage = buyBrokerage + sellBrokerage;
        Double txnCharge = EXCHANGE_TXN_CHARGE * transaction.getShareCount();
        Double gst =  GST * transaction.getShareCount();
        Double stampDuty = STAMP_DUTY * transaction.getShareCount();
        Double totalTaxAndCharges = brokerage + txnCharge + gst + stampDuty;
        Double buyPrice = (transaction.getInvestmentAmount() - stampDuty - gst - txnCharge - brokerage - transaction.getExpectedProfit())/transaction.getShareCount();
        double stopLossPer = (transaction.getStopLossPer() != null || transaction.getStopLossPer() != 0)?transaction.getStopLossPer():DEFAULT_STOP_LOSS;
        Double stopLoss = ((transaction.getInvestmentAmount()+(transaction.getInvestmentAmount()*stopLossPer/100))-totalTaxAndCharges)/transaction.getShareCount();

        transaction.setBrokerage(brokerage);
        transaction.setTxnCharge(txnCharge);
        transaction.setGst(gst);
        transaction.setStampDuty(stampDuty);
        transaction.setTotalTaxAndCharges(totalTaxAndCharges);
        transaction.setSellingPrice(buyPrice);
        transaction.setStopLoss(stopLoss);
        transaction.setTransactionType(Transaction.TYPE.SELL);
        return transaction;
    }




    public static void main(String []args){
        Transaction transaction = new Transaction();
        transaction.setInvestmentAmount(100000.0);
        transaction.setCurrentPrice(500.0);
        transaction.setExpectedProfit(200.0);
        transaction.setStopLossPer(2.0);

        TradeService service = new TradeService();
        transaction = service.analyzeBuyTransaction(transaction);

        System.out.println(transaction);
        System.out.println();
        transaction = service.analyzeShortSellTransaction(transaction);
        System.out.println(transaction);

    }
}

