package com.example.cryptowatcher;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CryptoApiService {

    // Definir o endpoint para obter os preços de criptomoedas
    @Headers("X-CMC_PRO_API_KEY: b9ddb98f-2d3b-4b3b-8333-09b39f62a047")  // Substitua "YOUR_API_KEY" pela sua chave de API
    @GET("v1/cryptocurrency/listings/latest")
    Call<CryptoApiResponse> getCryptoPrices(@Query("start") int start, @Query("limit") int limit, @Query("convert") String convert);
}
