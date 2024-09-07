package com.example.cryptowatcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> {

    private List<CryptoData> cryptoDataList;

    public static class CryptoViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView priceTextView;
        public TextView percentChange24hTextView;

        public CryptoViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.crypto_name);
            priceTextView = itemView.findViewById(R.id.crypto_price);
            percentChange24hTextView = itemView.findViewById(R.id.crypto_percent_change_24h);
        }
    }

    public CryptoAdapter(List<CryptoData> cryptoDataList) {
        this.cryptoDataList = this.cryptoDataList;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_item, parent, false);
        return new CryptoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        CryptoData cryptoData = cryptoDataList.get(position);
        holder.nameTextView.setText(cryptoData.getName());
        holder.priceTextView.setText(String.format("$%.2f", cryptoData.getPrice()));
        holder.percentChange24hTextView.setText(String.format("%.2f%%", cryptoData.getPercentChange24h()));
    }

    @Override
    public int getItemCount() {
        return cryptoDataList.size();
    }

    // Método para atualizar a lista de dados
    public void setCryptoDataList(List<CryptoData> cryptoDataList) {
        this.cryptoDataList = cryptoDataList;
        notifyDataSetChanged();
    }
}
