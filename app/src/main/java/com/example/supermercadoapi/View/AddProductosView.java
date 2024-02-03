package com.example.supermercadoapi.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;
import com.example.supermercadoapi.Presenter.ProductosPresenter;
import com.example.supermercadoapi.R;

import java.util.List;

public class AddProductosView extends AppCompatActivity implements ProductsContract.View {

    private ProductosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_productos);

        presenter = new ProductosPresenter(this);

        // Inicializar elementos de la vista
        EditText editTextNombreProducto = findViewById(R.id.editTextNombreProducto);
        EditText editTextPrecioProducto = findViewById(R.id.editTextPrecioProducto);
        Button btnGuardarProducto = findViewById(R.id.btnGuardarProducto);

        // Aquí puedes agregar lógica para manejar el clic del botón
        btnGuardarProducto.setOnClickListener(view -> {
            String nombreProducto = editTextNombreProducto.getText().toString();
            String precioProductoStr = editTextPrecioProducto.getText().toString();

            if (!nombreProducto.isEmpty() && !precioProductoStr.isEmpty()) {
                double precioProducto = Double.parseDouble(precioProductoStr);

                // Crea un objeto Product con los datos ingresados
                Product nuevoProducto = new Product(0, nombreProducto, precioProducto, "", "");
                // Llama al método del presentador para agregar el producto
                presenter.agregarProductos(nuevoProducto);
            } else {

                mostrarMensajeError("Por favor, completa todos los campos.");
            }
        });
    }

    @Override
    public void mostrarProductos(List<Product> productList) {

    }

    // Método para mostrar mensajes de error
    public void mostrarMensajeError(String mensaje) {
        // Implementa la lógica para mostrar el mensaje de error, por ejemplo, usando Toast
        // o actualizando una vista específica en la interfaz de usuario.
    }
}

