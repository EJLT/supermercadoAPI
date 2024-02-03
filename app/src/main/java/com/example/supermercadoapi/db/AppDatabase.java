package com.example.supermercadoapi.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.supermercadoapi.Domain.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}

