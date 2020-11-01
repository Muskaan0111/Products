package com.example.productsselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productsselector.databinding.ProductItemBinding;

import java.util.List;

import Model.Product;

class ProductAdapters extends RecyclerView.Adapter<ProductAdapters.ViewHolder> {


    private Context context;
    private List<Product> productList;

    public ProductAdapters(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductItemBinding b = ProductItemBinding.inflate(LayoutInflater.from(context)
                , parent
                , false);

        return new ViewHolder(b);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Product product = productList.get(position);


        holder.b.name.setText(String.format("%s Rs. %d", product.name, product.price));


        holder.b.quantity.setText(product.qty + "");

        holder.b.decrementBtn.setVisibility(product.qty > 0 ? View.VISIBLE : View.GONE);
        holder.b.quantity.setVisibility(product.qty > 0 ? View.VISIBLE : View.GONE);


        holder.b.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.qty++;
                notifyItemChanged(position);
            }
        });


    }



    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private ProductItemBinding b;

        public ViewHolder(@NonNull ProductItemBinding b) {
            super(b.getRoot());
            this.b = b;
        }

    }

}