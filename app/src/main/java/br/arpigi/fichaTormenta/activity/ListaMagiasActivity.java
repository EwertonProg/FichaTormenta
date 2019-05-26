package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.List;

import br.arpigi.fichaTormenta.model.Magia;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaMagiasAdapter;
import io.objectbox.Box;

public class ListaMagiasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ListaMagiasAdapter.ChamadaBotaoMagia{
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
        setContentView(R.layout.activity_lista_talentos);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_talento);
        NavigationView navigationView = findViewById(R.id.nav_view);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void magiaSelecionada(Long idBancoMagia, Integer posLista) {
        if(personagem.getTalentos().getById(idBancoMagia)==null){
            if(personagem.getMagias().add(magiaBox.get(idBancoMagia))){
                Magia m = magias.get(posLista);
                m.setOnPersonagem(true);
                adapter.notifyItemChanged(posLista);
                personagemBox.put(personagem);
            }
            Log.d("qtdTendencia",String.format("%s",personagem.getTalentos().size()));
        }else{
            personagem.getTalentos().removeById(idBancoMagia);
            Magia t = magias.get(posLista);
            t.setOnPersonagem(false);
            adapter.notifyItemChanged(posLista);
            personagemBox.put(personagem);
            Log.d("qtdTendencia",String.format("%s",personagem.getTalentos().size()));
        }
    }
}
