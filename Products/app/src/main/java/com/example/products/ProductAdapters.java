package com.example.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.products.databinding.ProductItemBinding;

import java.util.List;

class  ProductAdapters extends RecyclerView.Adapter<ProductAdapters.ViewHolder> {
    private Context context;
   ProductItemBinding b;

    private List<Products> productlist;


    public ProductAdapters(Context context, List<Products> products){
        this.context=context;



    }




    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

       ProductItemBinding b = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false);


        return new ViewHolder(b);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position){


        Products product= productlist.get(position);

        holder.b.name.setText(String.format("%s (Rs%d)",product.name,product.price));

        holder.b.quantity.setText(product.qty+"");

        holder.b.decrementBtn.setVisibility(product.qty>0? View.VISIBLE:View.GONE);
        holder.b.quantity.setVisibility(product.qty>0?View.VISIBLE:View.GONE);



        holder.b.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                product.qty++;

                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProductItemBinding b;

        public ViewHolder(@NonNull ProductItemBinding b) {
            super(b.getRoot());
            this.b=b;

        }
    }
}

