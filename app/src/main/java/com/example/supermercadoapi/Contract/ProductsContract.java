package com.example.supermercadoapi.Contract;

import com.example.supermercadoapi.Domain.Product;

import java.util.List;

public interface ProductsContract {

    interface View{

        void mostrarProductos(List<Product> productList);
    }

    interface Presenter{
        void listarProductos();
        void agregarProductos(Product product);
        void modificarProductos(int productId, Product product);
        void obtenerDetallesProductos(int productId);
        void eliminarProductos(int productId);
    }
}
