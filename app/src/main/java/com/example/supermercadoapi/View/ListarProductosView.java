package com.example.supermercadoapi.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supermercadoapi.Adapter.ProductosAdapter;
import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;
import com.example.supermercadoapi.Presenter.ProductosPresenter;
import com.example.supermercadoapi.R;

import java.util.List;

public class ListarProductosView extends AppCompatActivity implements ProductsContract.View {

    private ProductsContract.Presenter presenter;
    private ProductosAdapter productosAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);

        presenter = new ProductosPresenter(this);

        // Obtén referencias a las vistas
        TextView tvTitulo = findViewById(R.id.tvTitulo);
        RecyclerView recyclerViewProductos = findViewById(R.id.recyclerViewProductos);

        // Configura el RecyclerView
        productosAdapter = new ProductosAdapter(this, null); // Pasa una lista vacía inicialmente
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProductos.setAdapter(productosAdapter);

        // Llama al método del presentador para listar los productos
        presenter.listarProductos();
    }

    @Override
    public void mostrarProductos(List<Product> productList) {
        // Actualiza el adaptador con la lista de productos
        productosAdapter.setProductos(productList);

        // Notifica al adaptador que los datos han cambiado para que se refresque la interfaz de usuario
        productosAdapter.notifyDataSetChanged();
    }

}
