package com.example.supermercadoapi.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supermercadoapi.R;

public class BorrarProductosView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_productos);

        // Inicializar elementos de la vista
        EditText editTextNombreProducto = findViewById(R.id.editTextNombreProductoBorrar);
        Button btnGuardarProducto = findViewById(R.id.btnBorrarProducto);

        btnGuardarProducto.setOnClickListener(view -> {
            String nombreProducto = editTextNombreProducto.getText().toString();

        });
    }
}