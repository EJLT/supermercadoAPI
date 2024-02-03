package com.example.supermercadoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;
import com.example.supermercadoapi.Presenter.ProductosPresenter;
import com.example.supermercadoapi.View.AddProductosView;
import com.example.supermercadoapi.View.BorrarProductosView;
import com.example.supermercadoapi.View.DetallesProductosView;
import com.example.supermercadoapi.View.ListarProductosView;
import com.example.supermercadoapi.View.ModificarProductosView;

import java.util.List;


public class ProductosActivity extends AppCompatActivity implements ProductsContract.View {
private ProductsContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        presenter = new ProductosPresenter(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.action_maps) {
                // Lógica para abrir la actividad de mapas (MapsActivity)
                abrirActividad(MapsActivity.class);
                return true;
            }
            return false;
        });

        // Inicializar botones
        Button btnListarProductos = findViewById(R.id.btnListarProductos);
        Button btnAddProductos = findViewById(R.id.btnAddProductos);
        Button btnModificarProductos = findViewById(R.id.btnModificarProductos);
        Button btnDetallesProductos = findViewById(R.id.btnDetallesProductos);
        Button btnEliminarProductos = findViewById(R.id.btnEliminarProductos);

        // Establecer clic listeners
        btnListarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad(ListarProductosView.class);
            }
        });

        btnAddProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad(AddProductosView.class);
            }
        });

        btnModificarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad(ModificarProductosView.class);
            }
        });

        btnDetallesProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad(DetallesProductosView.class);
            }
        });

        btnEliminarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad(BorrarProductosView.class);
            }
        });
    }



    private void abrirActividad(Class<?> actividad){
        Intent intent =new Intent(ProductosActivity.this, actividad);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void mostrarProductos(List<Product> productList) {

    }

    @Override
    public void mostrarMensajeError(String mensaje) {

    }

    @Override
    public void mostrarProductoAgregado(Product nuevoProducto) {

    }
}
