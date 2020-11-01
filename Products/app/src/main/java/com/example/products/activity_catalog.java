package com.example.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.products.databinding.ActivityCatalogBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class activity_catalog extends AppCompatActivity {
     ActivityCatalogBinding c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        c = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(c.getRoot());





        setupProductsList();


    }

    private void setupProductsList() {

        //create data set

        List<Products> products = new ArrayList<>(


                Arrays.asList(
                        new Products("Tomato",20)
                        ,new Products("Potato",40)
                        ,new Products("Onion",80)



                )
        );


        ProductAdapters adapters = new ProductAdapters(this,products);



        c.productList.setAdapter(adapters);
        c.productList.setLayoutManager(new LinearLayoutManager(this));







    }

}