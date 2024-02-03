package com.example.supermercadoapi.Presenter;

import com.example.supermercadoapi.Api.Constants;
import com.example.supermercadoapi.Api.ProductApi;
import com.example.supermercadoapi.Api.ProductApiInterface;
import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductosPresenter implements ProductsContract.Presenter {

    private ProductsContract.View view;
    private ProductApiInterface productApi;

    public ProductosPresenter(ProductsContract.View view) {
        this.view = view;

        productApi = ProductApi.getInstance();

        // Configura Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crea la instancia de la interfaz de la API
        productApi = retrofit.create(ProductApiInterface.class);
    }

    @Override
    public void listarProductos() {
        Call<List<Product>> call = productApi.listProductos();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    view.mostrarProductos(response.body());
                } else {
                    view.mostrarMensajeError("Error al obtener productos");
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                view.mostrarMensajeError("Error de red al obtener productos");
            }
        });
    }

    // ProductosPresenter.java
    @Override
    public void agregarProductos(Product product) {
        Call<Product> call = productApi.AgregarProducto(product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    // Producto agregado exitosamente
                    view.mostrarProductoAgregado(response.body());
                } else {
                    // Error al agregar el producto
                    view.mostrarMensajeError("Error al agregar el producto");
                }
            }
            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                // Manejar error de red al agregar el producto
                view.mostrarMensajeError("Error de red al agregar el producto");
            }
        });
    }


    @Override
    public void modificarProductos(int productId, Product product) {
        Call<Product> call = productApi.ModificarProducto(productId, product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {

                } else {
                    view.mostrarMensajeError("Error al modificar producto");
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                view.mostrarMensajeError("Error de red al modificar producto");
            }
        });
    }

    @Override
    public void obtenerDetallesProductos(int productId) {
        Call<Product> call = productApi.ObtenerDetallesProductos(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {

                } else {
                    view.mostrarMensajeError("Error al obtener detalles del producto");
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                view.mostrarMensajeError("Error de red al obtener detalles del producto");
            }
        });
    }

    @Override
    public void eliminarProductos(int productId) {
        Call<Void> call = productApi.eliminarProductos(productId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {

                } else {
                    view.mostrarMensajeError("Error al eliminar producto");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                view.mostrarMensajeError("Error de red al eliminar producto");
            }
        });
    }
}
