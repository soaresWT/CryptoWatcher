package com.example.cryptowatcher;

import com.example.cryptowatcher.CryptoData;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CryptoApiResponse {
    @SerializedName("data")
    private List<CryptoData> data;

    public List<CryptoData> getData() {
        return data;
    }

    public void setData(List<CryptoData> data) {
        this.data = data;
    }
}
