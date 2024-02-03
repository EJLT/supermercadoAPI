package com.example.supermercadoapi.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.supermercadoapi.R;

public class AddProductosView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_productos);

        // Inicializar elementos de la vista
        EditText editTextNombreProducto = findViewById(R.id.editTextNombreProducto);
        EditText editTextPrecioProducto = findViewById(R.id.editTextPrecioProducto);
        Button btnGuardarProducto = findViewById(R.id.btnGuardarProducto);

        // Aquí puedes agregar lógica para manejar el clic del botón, por ejemplo:
        btnGuardarProducto.setOnClickListener(view -> {
            String nombreProducto = editTextNombreProducto.getText().toString();
            String precioProducto = editTextPrecioProducto.getText().toString();


        });
    }
}
