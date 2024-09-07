package com.example.cryptowatcher;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface FavoriteCryptoDao {
    @Insert
    void insert(FavoriteCrypto favoriteCrypto);

    @Query("SELECT * FROM favorite_cryptos")
    List<FavoriteCrypto> getAllFavorites();
}
