package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.arpigi.fichaTormenta.enums.Tendencias;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Raca_;
import br.arpigi.fichaTormenta.util.Banco;
import io.objectbox.Box;

public class CriacaoPersonagemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText edNome,edForca,edForcaMod,edDestreza,edDestrezaMod,edConstituicao,edConstituicaoMod
            ,edInteligencia,edInteligenciaMod,edSabedoria,edSabedoriaMod,edCarisma,edCarismaMod;
    Spinner spnRaca,spnTendencia,spnSexo;
    Box<Raca> racaBox;
    Personagem personagem;
    Raca raca;
    Tendencias tendencias;
    String sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_personagem);
        edNome = findViewById(R.id.ed_nome_personagem);
        edForca = findViewById(R.id.ed_forca_personagem);
        edForcaMod = findViewById(R.id.ed_forca_mod_personagem);
        edDestreza= findViewById(R.id.ed_destreza_personagem);
        edDestrezaMod= findViewById(R.id.ed_destreza_mod_personagem);
        edConstituicao = findViewById(R.id.ed_constituicao_personagem);
        edConstituicaoMod = findViewById(R.id.ed_constituicao_mod_personagem);
        edInteligencia= findViewById(R.id.ed_inteligencia_personagem);
        edInteligenciaMod= findViewById(R.id.ed_inteligencia_mod_personagem);
        edSabedoria= findViewById(R.id.ed_sabedoria_personagem);
        edSabedoriaMod= findViewById(R.id.ed_sabedoria_mod_personagem);
        edCarisma = findViewById(R.id.ed_carisma_personagem);
        edCarismaMod = findViewById(R.id.ed_carisma_mod_personagem);
        spnRaca = findViewById(R.id.spinner_raca_personagem);
        spnTendencia = findViewById(R.id.spinner_tendendia_personagem);
        spnSexo = findViewById(R.id.spinner_sexo_personagem);

        racaBox = Banco.get().boxFor(Raca.class);

        personagem = new Personagem();

        ArrayAdapter<CharSequence> sexoAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.sexoArray));
        spnSexo.setAdapter(sexoAdapter);
        spnSexo.setOnItemSelectedListener(this);

        ArrayAdapter<String> tendenciaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, Tendencias.stringValues());
        spnTendencia.setAdapter(tendenciaAdapter);
        spnTendencia.setOnItemSelectedListener(this);

        ArrayAdapter<String> RacaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,racaBox.query().build().property(Raca_.nome).findStrings() );
        spnRaca.setAdapter(RacaAdapter);
        spnRaca.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view.getId()==spnRaca.getId()){
           raca  = racaBox.query().equal(Raca_.nome,(String)parent.getItemAtPosition(position)).build().findFirst();
            Log.d("Spinner",raca.getNome());
        }else if(view.getId()==spnTendencia.getId()){
            tendencias = Tendencias.valueOf((String)parent.getItemAtPosition(position));
            Log.d("Spinner",tendencias.getNome());
        }else{
            sexo = (String)parent.getItemAtPosition(position);
            Log.d("Spinner",sexo);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void irParaSelecaoClasse(View view){
        Personagem personagem1 = new Personagem();

        personagem1.setSexo((String) spnSexo.getSelectedItem());

        personagem1.getRaca().setTarget(racaBox.query().equal(Raca_.nome,(String)spnRaca.getSelectedItem()).build().findFirst());

        personagem1.setTendencia(Tendencias.getTendendias((String) spnTendencia.getSelectedItem()));

        Toast.makeText(this, personagem1.getSexo() + personagem1.getRaca().getTarget().getNome()+personagem1.getTendencia().getNome(), Toast.LENGTH_SHORT).show();
    }
}
