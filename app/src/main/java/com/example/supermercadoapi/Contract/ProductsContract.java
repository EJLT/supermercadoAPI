package com.example.supermercadoapi.Contract;

import com.example.supermercadoapi.Domain.Product;

public interface ProductsContract {

    interface View{

    }

    interface Presenter{
        void listarProductos();
        void agregarProductos(Product product);
        void modificarProductos(int productId, Product product);
        void obtenerDetallesProductos(int productId);
        void eliminarProductos(int productId);
    }
}
