package com.roganin.trademessages.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TradeMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal amountSell;
    private BigDecimal amountBuy;
    private BigDecimal rate;
    private Date timePlaced;
    private String originatingCountry;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(BigDecimal amountSell) {
        this.amountSell = amountSell;
    }

    public BigDecimal getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(BigDecimal amountBuy) {
        this.amountBuy = amountBuy;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    @Override
    public String toString() {
        return "TradeMessage{" +
                "userId=" + userId +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", amountSell=" + amountSell +
                ", amountBuy=" + amountBuy +
                ", rate=" + rate +
                ", timePlaced=" + timePlaced +
                ", originatingCountry='" + originatingCountry + '\'' +
                '}';
    }
}
