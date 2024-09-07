package com.example.cryptowatcher;

import com.google.gson.annotations.SerializedName;

public class CryptoData {
    @SerializedName("name")
    private String name;

    @SerializedName("quote")
    private Quote quote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return quote.getUSD().getPrice();
    }

    public double getPercentChange24h() {
        return quote.getUSD().getPercentChange24h();
    }

    public static class Quote {
        @SerializedName("USD")
        private USD usd;

        public USD getUSD() {
            return usd;
        }

        public void setUSD(USD usd) {
            this.usd = usd;
        }
    }

    public static class USD {
        @SerializedName("price")
        private double price;

        @SerializedName("percent_change_24h")
        private double percentChange24h;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(double percentChange24h) {
            this.percentChange24h = percentChange24h;
        }
    }
}
