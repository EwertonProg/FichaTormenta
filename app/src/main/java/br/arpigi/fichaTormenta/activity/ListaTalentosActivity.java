package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

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

    private ListaTalentosAdapter adapter;

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

        talentoBox = Banco.get().boxFor(Talento.class);
        personagemBox = Banco.get().boxFor(Personagem.class);
        personagem = personagemBox.get(getIntent().getLongExtra("idPersonagem",0));
        talentos = talentoBox.query().order(Talento_.nome).build().find();

        this.identificarTalentosPersonagem();

        RecyclerView recyclerView = findViewById(R.id.lista_talento_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ListaTalentosAdapter(talentos, this, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_talento);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            talentoBox.closeThreadResources();
            personagemBox.closeThreadResources();
        }
    }

    private void identificarTalentosPersonagem(){
        for(Talento talento : talentos){
            if(personagem.getTalentos().contains(talento)){
                talento.setOnPersonagem(true);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lista_talentos, menu);

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
    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        talentos.clear();
        if (id == R.id.it_talento_combate) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.COMBATE.name()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.COMBATE.getNome());
        } else if (id == R.id.it_talento_pericia) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.PERICIA.toString()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.PERICIA.getNome());
        } else if (id == R.id.it_talento_magia) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.MAGIA.toString()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.MAGIA.getNome());
        } else if (id == R.id.it_talento_poder_concedido) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.PODER_CONCEDIDO.toString()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.PODER_CONCEDIDO.getNome());
        } else if (id == R.id.it_talento_tormenta) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.TORMENTA.toString()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.TORMENTA.getNome());
        } else if (id == R.id.it_talento_destino) {
            talentos.addAll(talentoBox.query().equal(Talento_.Grupo, GrupoDeTalento.DESTINO.toString()).order(Talento_.nome).build().find());
            Objects.requireNonNull(getSupportActionBar()).setTitle(GrupoDeTalento.DESTINO.getNome());
        }
        adapter.getTodosTalentos().clear();
        adapter.getTodosTalentos().addAll(talentos);
        this.identificarTalentosPersonagem();
        adapter.notifyDataSetChanged();

        DrawerLayout drawer = findViewById(R.id.drawer_layout_talento);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void talentoSelecionado(Long idBancoTalento,Integer posLista) {

        if(personagem.getTalentos().getById(idBancoTalento)==null){
            if(personagem.getTalentos().add(talentoBox.get(idBancoTalento))){
               Talento t = talentos.get(posLista);
               t.setOnPersonagem(true);
               adapter.notifyItemChanged(posLista);
               personagemBox.put(personagem);
            }
        }else{
            personagem.getTalentos().removeById(idBancoTalento);
            Talento t = talentos.get(posLista);
            t.setOnPersonagem(false);
            adapter.notifyItemChanged(posLista);
            personagemBox.put(personagem);
        }
    }
}
