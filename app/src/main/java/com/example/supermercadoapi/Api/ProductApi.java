package com.example.supermercadoapi.Api;

import static com.example.supermercadoapi.Api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductApi {
    private static ProductApiInterface productApiInstance;

    public static ProductApiInterface getInstance() {
        if (productApiInstance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            productApiInstance = retrofit.create(ProductApiInterface.class);
        }
        return productApiInstance;
    }
}
