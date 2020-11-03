package com.example.productsselector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.productsselector.databinding.ActivityCatalogBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Product;

public class CatalogActivity extends AppCompatActivity {



    private ActivityCatalogBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCatalogBinding.inflate(getLayoutInflater());

        setContentView(b.getRoot());

        setupProductsList();
    }

    private void setupProductsList() {

        List<Product> products = new ArrayList<>(
                Arrays.asList(
                        new Product("Tomato", 60)
                        , new Product("Onion", 80)
                        , new Product("Apple", 90)


                )
        );


        ProductAdapters adapter = new ProductAdapters(this, products);

        b.recyclerView.setAdapter(adapter);
        b.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new WeightPicker().show(CatalogActivity.this, new WeightPicker.OnWeightPickedListener() {
            @Override
            public void onWeightPicked(int kg, int g) {
                Toast.makeText(CatalogActivity.this, "kg = " + kg + " " +  "g = "+(g*50), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onWeightPickerCancelled() {
                Toast.makeText(CatalogActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        });


    }
    }

