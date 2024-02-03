package com.example.supermercadoapi.View;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supermercadoapi.R; // Asegúrate de que esta importación sea correcta según la ubicación de tu proyecto y el paquete R.

public class DetallesProductosView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);

        // Obtén referencias a las vistas
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewPrecio = findViewById(R.id.textViewPrecio);
        TextView textViewDescripcion = findViewById(R.id.textViewDescripcion);
        TextView textViewProcedencia = findViewById(R.id.textViewProcedencia);

        // Obtén datos del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            double precio = extras.getDouble("precio");
            String descripcion = extras.getString("descripcion");
            String procedencia = extras.getString("procedencia");

            // Actualiza las vistas con los datos recibidos
            textViewNombre.setText(nombre);
            textViewPrecio.setText(String.format("Precio: $%.2f", precio));
            textViewDescripcion.setText(descripcion);
            textViewProcedencia.setText(String.format("Procedencia: %s", procedencia));
        }
    }
}
