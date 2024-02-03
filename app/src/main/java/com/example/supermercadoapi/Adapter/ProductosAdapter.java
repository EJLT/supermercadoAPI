package com.example.supermercadoapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supermercadoapi.Domain.Product;
import com.example.supermercadoapi.R;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductViewHolder> {

    private List<Product> productList;
    private LayoutInflater inflater;

    public ProductosAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_producto, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        // Configura las vistas del ViewHolder con los datos del producto
        holder.txtNombreProducto.setText(currentProduct.getName());
        holder.txtPrecioProducto.setText(String.valueOf(currentProduct.getPrecio()));
        holder.txtDescripcionProducto.setText(currentProduct.getDescripcion());
        holder.txtProcedenciaProducto.setText(currentProduct.getProcedencia());

    }

    @Override
    public int getItemCount() {
        if (productList != null) {
            return productList.size();
        } else {
            return 0;
        }
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreProducto;
        TextView txtPrecioProducto;
        TextView txtDescripcionProducto;
        TextView txtProcedenciaProducto;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
            txtPrecioProducto = itemView.findViewById(R.id.txtPrecioProducto);
            txtDescripcionProducto = itemView.findViewById(R.id.txtDescripcionProducto);
            txtProcedenciaProducto = itemView.findViewById(R.id.txtProcedenciaProducto);
        }
    }
    public void setProductos(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged(); // Notificar al RecyclerView que los datos han cambiado
    }
}
