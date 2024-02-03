package com.example.supermercadoapi.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.supermercadoapi.Domain.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    long insertProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Query("SELECT * FROM productos")
    List<Product> getAllProducts();

    @Query("SELECT * FROM productos WHERE id = :productId")
    Product getProductById(int productId);
}
