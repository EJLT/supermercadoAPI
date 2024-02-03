package com.example.supermercadoapi.Model;

import com.example.supermercadoapi.Api.ProductApi;
import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosModel implements ProductsContract {

    public interface OnDataReadyListener {
        void onDataReady(List<Product> productList);
    }

    public interface OnProductAddedListener {
        void onProductAdded(Product addedProduct);
    }


    public void obtenerListaDeProductos(OnDataReadyListener listener) {
        ProductApi.getInstance().listProductos().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> productList = response.body();
                    if (listener != null) {
                        listener.onDataReady(productList);
                    }
                } else {
                    // Manejar error en la respuesta
                    if (listener != null) {
                        listener.onDataReady(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Manejar error en la solicitud
                if (listener != null) {
                    listener.onDataReady(null);
                }
            }
        });



        }
    }

