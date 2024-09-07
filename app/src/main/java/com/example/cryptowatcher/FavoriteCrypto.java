package com.example.cryptowatcher;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite_cryptos")
public class FavoriteCrypto {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
