package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Classe_;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaSelecaoClasseAdapter;
import io.objectbox.Box;

public class SelecaoClasseActivity extends AppCompatActivity implements ListaSelecaoClasseAdapter.ChamadaBotaoClasse {
    Box<Classe> classeBox;
    Box<Personagem> personagemBox;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Long idPersonagem;
    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_classe);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Seleção de Classe");

        classeBox = Banco.get().boxFor(Classe.class);
        personagemBox = Banco.get().boxFor(Personagem.class);


        ArrayList<Classe> classes = (ArrayList<Classe>) classeBox.query().order(Classe_.__ID_PROPERTY).build().find();

        recyclerView = findViewById(R.id.lista_classes_selecao_recycler);
        adapter = new ListaSelecaoClasseAdapter(classes,this,this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        idPersonagem = getIntent().getLongExtra("idPersonagem",0);
        personagem = personagemBox.get(idPersonagem);
    }


    @Override
    public void classeSelecionada(String classe) {
        Classe classeObjt = classeBox.query().equal(Classe_.nome, classe).build().findFirst();
        personagem.getClasses().add(classeObjt);
        personagemBox.put(personagem.build());
        startActivity(new Intent(this,ListaPersonagensActivity.class));
        setResult(1);
        finish();
        classeBox.closeThreadResources();
        personagemBox.closeThreadResources();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        personagemBox.remove(idPersonagem);
    }
}
