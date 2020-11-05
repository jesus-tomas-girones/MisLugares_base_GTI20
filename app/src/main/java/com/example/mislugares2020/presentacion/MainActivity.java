package com.example.mislugares2020.presentacion;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.mislugares2020.Aplicacion;
import com.example.mislugares2020.R;
import com.example.mislugares2020.casos_uso.CasosUsoLugar;
import com.example.mislugares2020.datos.RepositorioLugares;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private RepositorioLugares lugares;
   private CasosUsoLugar usoLugar;
   private RecyclerView recyclerView;
   public AdaptadorLugares adaptador;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      lugares = ((Aplicacion) getApplication()).lugares;
      usoLugar = new CasosUsoLugar(this, lugares);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
      toolBarLayout.setTitle(getTitle());
      adaptador = ((Aplicacion) getApplication()).adaptador;
      adaptador.setOnItemClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int pos = recyclerView.getChildAdapterPosition(v);
            usoLugar.mostrar(pos);
         }
      });
      recyclerView = findViewById(R.id.recyclerView);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(adaptador);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();
      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
         // poner una acción
         return true;
      }
      return super.onOptionsItemSelected(item);
   }

}