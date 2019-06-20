package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import br.arpigi.fichaTormenta.model.Magia;
import br.arpigi.fichaTormenta.model.Magia_;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaMagiasAdapter;
import io.objectbox.Box;

public class ListaMagiasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ListaMagiasAdapter.ChamadaBotaoMagia{
    Box<Magia> magiaBox;
    Box<Personagem> personagemBox;
    Personagem personagem;

    List<Magia> magias;

    private RecyclerView recyclerView;
    private ListaMagiasAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_magias);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Magias");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_magias);
        NavigationView navigationView = findViewById(R.id.nav_view_magia);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        magiaBox = Banco.get().boxFor(Magia.class);
        personagemBox = Banco.get().boxFor(Personagem.class);
        personagem = personagemBox.get(getIntent().getLongExtra("idPersonagem",0));
        magias = magiaBox.getAll();

        this.identificarMagiasPersonagem();

        recyclerView = findViewById(R.id.lista_talento_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaMagiasAdapter(magias, this, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void identificarMagiasPersonagem() {
        for(Magia magia: magias){
            if(personagem.getMagias().contains(magia)){
                magia.setOnPersonagem(true);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_magias);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            magiaBox.closeThreadResources();
            personagemBox.closeThreadResources();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lista_magias, menu);

        MenuItem searchItem = menu.findItem(R.id.itn_BotaoPesquisa);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        magias.clear();
        if (id == R.id.it_magia_0) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 0).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+0);
        } else if (id == R.id.it_magia_1) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 1).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+1);
        } else if (id == R.id.it_magia_2) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 2).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+2);
        } else if (id == R.id.it_magia_3) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 3).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+3);
        } else if (id == R.id.it_magia_4) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 4).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+4);
        } else if (id == R.id.it_magia_5) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 5).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+5);
        } else if (id == R.id.it_magia_6) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 6).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+6);
        } else if (id == R.id.it_magia_7) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 7).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+7);
        } else if (id == R.id.it_magia_8) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 8).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+8);
        } else if (id == R.id.it_magia_9) {
            magias.addAll(magiaBox.query().equal(Magia_.nivel, 9).order(Magia_.nome).build().find());
            getSupportActionBar().setTitle("Magias de Nivel "+9);
        }
        adapter.getTodasMagias().clear();
        adapter.getTodasMagias().addAll(magias);
        this.identificarMagiasPersonagem();
        adapter.notifyDataSetChanged();

        DrawerLayout drawer = findViewById(R.id.drawer_layout_magias);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void magiaSelecionada(Long idBancoMagia, Integer posLista) {
        if(personagem.getMagias().getById(idBancoMagia)==null){
            if(personagem.getMagias().add(magiaBox.get(idBancoMagia))){
                Magia m = magias.get(posLista);
                m.setOnPersonagem(true);
                adapter.notifyItemChanged(posLista);
                personagemBox.put(personagem);
            }
            Log.d("qtdMagia",String.format("%s",personagem.getMagias().size()));
        }else{
            personagem.getMagias().removeById(idBancoMagia);
            Magia t = magias.get(posLista);
            t.setOnPersonagem(false);
            adapter.notifyItemChanged(posLista);
            personagemBox.put(personagem);
            Log.d("qtdMagia",String.format("%s",personagem.getMagias().size()));
        }
    }
}
