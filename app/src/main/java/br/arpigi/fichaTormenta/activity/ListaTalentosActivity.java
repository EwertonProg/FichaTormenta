package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.List;

import br.arpigi.fichaTormenta.enums.GrupoDeTalento;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Talento;
import br.arpigi.fichaTormenta.model.Talento_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaTalentosAdapter;
import io.objectbox.Box;

public class ListaTalentosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ListaTalentosAdapter.ChamadaBotaoTalento {
    Box<Talento> talentoBox;
    Box<Personagem> personagemBox;
    Personagem personagem;
    List<Talento> talentos;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_talentos);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        talentoBox = Banco.get().boxFor(Talento.class);
        personagemBox = Banco.get().boxFor(Personagem.class);
        personagem = personagemBox.get(getIntent().getLongExtra("idPersonagem",0));
        talentos = talentoBox.getAll();

        recyclerView = findViewById(R.id.lista_talento_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaTalentosAdapter(talentos, this, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        talentos.clear();
        if (id == R.id.it_talento_combate) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.COMBATE.name()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.COMBATE.getNome());
        } else if (id == R.id.it_talento_pericia) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.PERICIA.toString()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.PERICIA.getNome());
        } else if (id == R.id.it_talento_magia) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.MAGIA.toString()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.MAGIA.getNome());
        } else if (id == R.id.it_talento_poder_concedido) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.PODER_CONCEDIDO.toString()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.PODER_CONCEDIDO.getNome());
        } else if (id == R.id.it_talento_tormenta) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.TORMENTA.toString()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.TORMENTA.getNome());
        } else if (id == R.id.it_talento_destino) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.DESTINO.toString()).build().find());
            getSupportActionBar().setTitle(GrupoDeTalento.DESTINO.getNome());
        }

        adapter.notifyDataSetChanged();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void talentoSelecionado(Long idTalento) {
        if(personagem.getTalentos().getById(idTalento)==null){
            personagem.getTalentos().add(talentoBox.get(idTalento));
            Log.d("qtdTendencia",String.format("%s",personagem.getTalentos().getAddCount()));
        }
    }

}
