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


public class ProductosActivity extends AppCompatActivity implements ProductsContract.View {
private ProductsContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        presenter = new ProductosPresenter(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  //

        // Inicializar botones
        Button btnListarProductos = findViewById(R.id.btnListarProductos);
        Button btnAddProductos = findViewById(R.id.btnAddProductos);
        Button btnModificarProductos = findViewById(R.id.btnModificarProductos);
        Button btnDetallesProductos = findViewById(R.id.btnDetallesProductos);
        Button btnEliminarProductos = findViewById(R.id.btnEliminarProductos);

        // Establecer clic listeners
        btnListarProductos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.listarProductos();
            }
        });
        btnAddProductos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.agregarProductos(new Product(0, "Nombre", 10.99, "Descripción", "Procedencia"));
            }
        });

        btnModificarProductos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.modificarProductos(1, new Product(1, "Nuevo Nombre", 15.99, "Nueva Descripción", "Nueva Procedencia"));
            }
        });

        btnDetallesProductos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.obtenerDetallesProductos(1);
            }
        });

        btnEliminarProductos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                presenter.eliminarProductos(1);
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


}
