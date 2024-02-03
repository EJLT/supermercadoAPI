package com.example.supermercadoapi.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supermercadoapi.Contract.ProductsContract;
import com.example.supermercadoapi.Domain.Product;
import com.example.supermercadoapi.Presenter.ProductosPresenter;
import com.example.supermercadoapi.R; // Asegúrate de que esta importación sea correcta según la ubicación de tu proyecto y el paquete R.

import java.util.List;

public class ModificarProductosView extends AppCompatActivity implements ProductsContract.View {

    private ProductsContract.Presenter presenter;

    private EditText editTextModificarNombre;
    private EditText editTextModificarPrecio;
    private EditText editTextModificarDescripcion;
    private EditText editTextModificarProcedencia;
    private Button btnModificarProducto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_productos);

        presenter = new ProductosPresenter(this);

        // Obtén referencias a las vistas
        editTextModificarNombre = findViewById(R.id.editTextModificarNombre);
        editTextModificarPrecio = findViewById(R.id.editTextModificarPrecio);
        editTextModificarDescripcion = findViewById(R.id.editTextModificarDescripcion);
        editTextModificarProcedencia = findViewById(R.id.editTextModificarProcedencia);
        btnModificarProducto = findViewById(R.id.btnModificarProducto);

        // Configura el clic del botón de modificación
        btnModificarProducto.setOnClickListener(v -> modificarProducto());

        // Puedes agregar más configuraciones según tus necesidades
    }

    private void modificarProducto() {
        // Obtiene los valores de las vistas
        String nuevoNombre = editTextModificarNombre.getText().toString();
        double nuevoPrecio = Double.parseDouble(editTextModificarPrecio.getText().toString());
        String nuevaDescripcion = editTextModificarDescripcion.getText().toString();
        String nuevaProcedencia = editTextModificarProcedencia.getText().toString();

        // Crea un objeto Product con los nuevos valores
        Product productoModificado = new Product(1, nuevoNombre, nuevoPrecio, nuevaDescripcion, nuevaProcedencia);

        // Llama al método del presentador para modificar el producto
        presenter.modificarProductos(1, productoModificado);


    }

    @Override
    public void mostrarProductos(List<Product> productList) {

    }
}
