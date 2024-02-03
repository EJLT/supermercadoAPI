package com.example.supermercadoapi.Presenter;

import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;


public class ProductosPresenter implements ProductsContract.Presenter{
    private ProductsContract.View view;

public ProductosPresenter(ProductsContract.View view){
    this.view = view;
}


    @Override
    public void listarProductos() {


    }
    @Override
    public void agregarProductos(Product product) {

    }
    @Override
    public void modificarProductos(int productId, Product product) {

    }
    @Override
    public void obtenerDetallesProductos(int productId) {

    }

    @Override
    public void eliminarProductos(int productId) {

    }

}
