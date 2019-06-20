package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import io.objectbox.Box;

public class DescricaoPersonagemActivity extends AppCompatActivity {

    EditText edNome, edNivel, edRaca, edSexo, edTendencia, edClasse;
    Box<Personagem> personagemBox;
    Personagem personagem;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_personagem);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Descrição de Personagem");

        long id = getIntent().getLongExtra("idPersonagem",0);
        personagemBox = Banco.get().boxFor(Personagem.class);
        personagem = personagemBox.get(id);

        edNome = findViewById(R.id.ed_nome_personagem_descricao);
        edNivel = findViewById(R.id.ed_nivel_personagem_descricao);
        edRaca = findViewById(R.id.ed_raca_personagem_descricao);
        edSexo = findViewById(R.id.ed_sexo_personagem_descricao);
        edTendencia = findViewById(R.id.ed_tendencia_personagem_descricao);
        edClasse = findViewById(R.id.ed_classe_personagem_descricao);

        edNome.setText(personagem.getNome());
        edNivel.setText(String.format("%s",personagem.getNvDePersonagem()));
        edRaca.setText(personagem.getRaca().getTarget().getNome());
        edSexo.setText(personagem.getSexo());
        edTendencia.setText(personagem.getTendencia().toString());
        edClasse.setText(personagem.classesString());
    }

    public void irParaSelecaoTalento(View view){
        i = new Intent(this,ListaTalentosActivity.class);
        i.putExtra("idPersonagem",personagem.getId());
        startActivity(i);
    }

    public void irParaSelecaoMagia(View view){
        i = new Intent(this,ListaMagiasActivity.class);
        i.putExtra("idPersonagem",personagem.getId());
        startActivity(i);
    }

    public void irParaCombate(View view){
        i = new Intent(this,CombateActivity.class);
        i.putExtra("idPersonagem",personagem.getId());
        startActivity(i);
    }

    public void irParaPericias(View view){
        i = new Intent(this,PericiasActivity.class);
        i.putExtra("idPersonagem",personagem.getId());
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        personagemBox.closeThreadResources();
    }
}
