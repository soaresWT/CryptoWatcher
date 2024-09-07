package com.example.cryptowatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView loadingMessage;
    private RecyclerView recyclerView;
    private CryptoAdapter cryptoAdapter; // Adapter para RecyclerView
    private List<CryptoData> cryptoDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingMessage = findViewById(R.id.loading_message);
        recyclerView = findViewById(R.id.crypto_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar o adapter
        cryptoAdapter = new CryptoAdapter(cryptoDataList);
        recyclerView.setAdapter(cryptoAdapter);

        loadCryptoData();

    }

    private void loadCryptoData() {
        CryptoApiService apiService = RetrofitClient.getClient().create(CryptoApiService.class);

        // Mostrar mensagem de carregamento
        loadingMessage.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        Call<CryptoApiResponse> call = apiService.getCryptoPrices(1, 10, "USD");
        call.enqueue(new Callback<CryptoApiResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<CryptoApiResponse> call, Response<CryptoApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Recebe os dados da resposta
                    List<CryptoData> data = response.body().getData();

                    // Atualizar RecyclerView com os dados recebidos
                    cryptoAdapter.setCryptoDataList(data);
                    cryptoAdapter.notifyDataSetChanged();

                    // Esconder mensagem de carregamento e mostrar RecyclerView
                    loadingMessage.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                } else {
                    Log.e("MainActivity", "Erro na resposta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CryptoApiResponse> call, Throwable t) {
                Log.e("MainActivity", "Falha na chamada da API: " + t.getMessage());
                // Esconder mensagem de carregamento em caso de falha
                loadingMessage.setVisibility(View.GONE);
            }
        });
    }
}
