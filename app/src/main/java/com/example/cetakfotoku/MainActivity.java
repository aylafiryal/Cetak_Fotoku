package com.example.cetakfotoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements KeranjangBelanjaListener {

    private RecyclerView rvKatalogFoto;
    private KatalogFotoListAdapter adapter;
    private FloatingActionButton btnKeranjangBelanja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();

        rvKatalogFoto = findViewById(R.id.rv_katalog);
        adapter = new KatalogFotoListAdapter(this);

        rvKatalogFoto.setAdapter(adapter);
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));

        btnKeranjangBelanja = findViewById(R.id.btn_keranjang_belanja);
        orderChanged();
        btnKeranjangBelanja.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, KeranjangBelanjaActivity.class);
            startActivity(intent);
        });
        OrderFotoUtil.addKBListener(this);
    }

    @Override
    public void orderChanged() {
        Toast.makeText(this, "Dimasukkan ke keranjang", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App telah di-resume", Toast.LENGTH_SHORT).show();
    }
}