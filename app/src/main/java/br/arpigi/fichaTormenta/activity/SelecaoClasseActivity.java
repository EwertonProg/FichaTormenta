package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

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

        setSupportActionBar(findViewById(R.id.toolbar_principal));
        getSupportActionBar().setTitle("Mudou");

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
