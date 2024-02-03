package com.example.supermercadoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflar el menú
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar clic de ítem de menú
        toolbar.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.action_maps) {
                // Lógica para abrir la actividad de mapas (MapsActivity)
                abrirActividad(MapsActivity.class);
                return true;
            }
            return false;
        });

        Button btnProductos = findViewById(R.id.btnProductos);
        btnProductos.setOnClickListener(view -> abrirActividad(ProductosActivity.class));
      //  btnProductos.setText(R.string.btn_productos);


    }



        private void abrirActividad(Class<?> actividad){
            Intent intent =new Intent(MainActivity.this, actividad);
            startActivity(intent);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
