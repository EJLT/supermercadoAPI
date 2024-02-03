package com.example.supermercadoapi.Api;

import com.example.supermercadoapi.Domain.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductApiInterface {

    //obtener Lista de Productos
    @GET("productos")
    Call<List<Product>> listProductos();

    //Obtener detalles de un producto por ID
    @GET ("productos/{id}")
    Call<Product> ObtenerDetallesProductos(@Path("id")int productID);

    //Añadir productos al catálogo
    @POST("productos")
    Call<Product> AgregarProducto(@Body Product product);

    //Modificar un producto existente
    @PUT("productos/{id}")
    Call<Product> ModificarProducto(@Path("id") int productId, @Body Product product);

    //Eliminar un producto por ID
    @DELETE("productos/{id}")
    Call<Void> eliminarProductos(@Path("id")int productID);

    }


