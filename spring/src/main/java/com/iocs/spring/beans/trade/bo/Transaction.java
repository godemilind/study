package com.iocs.spring.beans.trade.bo;

public class Transaction {

    public enum TYPE{BUY,SELL}

    private TYPE transactionType;

    private Double sellingPrice;

    private Double shareCount;

    private Double stopLoss;

    private Double investmentAmount;

    private Double currentPrice;

    private Double expectedProfit;

    private Double brokerage;

    private Double txnCharge;

    private Double gst;

    private Double stampDuty;

    private Double totalTaxAndCharges;

    private Double stopLossPer;

    public TYPE getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TYPE transactionType) {
        this.transactionType = transactionType;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getShareCount() {
        return shareCount;
    }

    public void setShareCount(Double shareCount) {
        this.shareCount = shareCount;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getExpectedProfit() {
        return expectedProfit;
    }

    public void setExpectedProfit(Double expectedProfit) {
        this.expectedProfit = expectedProfit;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getTxnCharge() {
        return txnCharge;
    }

    public void setTxnCharge(Double txnCharge) {
        this.txnCharge = txnCharge;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Double getTotalTaxAndCharges() {
        return totalTaxAndCharges;
    }

    public void setTotalTaxAndCharges(Double totalTaxAndCharges) {
        this.totalTaxAndCharges = totalTaxAndCharges;
    }

    public Double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(Double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public Double getStopLossPer() {
        return stopLossPer;
    }

    public void setStopLossPer(Double stopLossPer) {
        this.stopLossPer = stopLossPer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "\nsellingPrice=" + sellingPrice +
                "\nshareCount=" + shareCount +
                "\nstopLoss=" + stopLoss +
                "\ninvestmentAmount=" + investmentAmount +
                "\ncurrentPrice=" + currentPrice +
                "\nexpectedProfit=" + expectedProfit +
                "\nbrokerage=" + brokerage +
                "\ntxnCharge=" + txnCharge +
                "\ngst=" + gst +
                "\nstampDuty=" + stampDuty +
                "\ntotalTaxAndCharges=" + totalTaxAndCharges +
                "\nstopLossPer=" + stopLossPer +
                "\ntransactionType=" + transactionType +"\n"+
                '}';
    }
}
