package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Tendencias;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Raca_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.Utils;
import io.objectbox.Box;

public class CriacaoPersonagemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText edNome,edForca,edForcaMod,edDestreza,edDestrezaMod,edConstituicao,edConstituicaoMod
            ,edInteligencia,edInteligenciaMod,edSabedoria,edSabedoriaMod,edCarisma,edCarismaMod;
    TextView tvForca,tvDestreza,tvConstituicao,tvInteligencia,tvSabedoria,tvCarisma;
    Spinner spnRaca,spnTendencia,spnSexo;
    Intent i;
    Box<Raca> racaBox;
    Box<Personagem> personagemBox;
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
        tvForca = findViewById(R.id.tv_forca_personagem);
        tvDestreza = findViewById(R.id.tv_destreza_personagem);
        tvConstituicao = findViewById(R.id.tv_constituicao_personagem);
        tvInteligencia = findViewById(R.id.tv_inteligencia_personagem);
        tvSabedoria = findViewById(R.id.tv_sabedoria_personagem);
        tvCarisma = findViewById(R.id.tv_carisma_personagem);

        racaBox = Banco.get().boxFor(Raca.class);
        personagemBox = Banco.get().boxFor(Personagem.class);

        ArrayAdapter<CharSequence> sexoAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.sexoArray));
        spnSexo.setAdapter(sexoAdapter);

        ArrayAdapter<String> tendenciaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, Tendencias.stringValues());
        spnTendencia.setAdapter(tendenciaAdapter);

        ArrayAdapter<String> RacaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,racaBox.query().build().property(Raca_.nome).findStrings() );
        spnRaca.setOnItemSelectedListener(this);
        spnRaca.setAdapter(RacaAdapter);

        edForca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvSabedoria.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }
                    try{
                        edForcaMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                    }catch (java.lang.NumberFormatException e){
                        edForcaMod.setText(null);
                    }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edDestreza.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvDestreza.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }
                    try{
                        edDestrezaMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                    }catch (java.lang.NumberFormatException e){
                        edDestrezaMod.setText(null);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edConstituicao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvConstituicao.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }
                    try{
                        edConstituicaoMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                    }catch (java.lang.NumberFormatException e){
                        edConstituicaoMod.setText(null);
                    }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
  edInteligencia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvInteligencia.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }
                    try{
                        edInteligenciaMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                    }catch (java.lang.NumberFormatException e){
                        edInteligenciaMod.setText(null);
                    }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
  edSabedoria.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvSabedoria.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }
                    try{
                        edSabedoriaMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                    }catch (java.lang.NumberFormatException e){
                        edSabedoriaMod.setText(null);
                    }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
  edCarisma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int modRaca ;
                try {
                    modRaca = Integer.parseInt(tvCarisma.getText().toString());
                }catch (java.lang.NumberFormatException e){
                    modRaca = 0;
                }

                try{
                    edCarismaMod.setText(Habilidade.calcularModificador(Integer.parseInt(s.toString())+modRaca));
                }catch (java.lang.NumberFormatException e){
                    edCarismaMod.setText(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void irParaSelecaoClasse(View view){
        if(Utils.validarEditText(edNome,edForca,edDestreza,edConstituicao,edInteligencia,edSabedoria,edCarisma)) {
            i = new Intent(this,SelecaoClasseActivity.class);

            Personagem personagem1 = new Personagem();

            personagem1.setNome(edNome.getText().toString());

            personagem1.setSexo((String) spnSexo.getSelectedItem());

            personagem1.getRaca().setTarget(racaBox.query().equal(Raca_.nome, (String) spnRaca.getSelectedItem()).build().findFirst());

            personagem1.setTendencia(Tendencias.getTendendias((String) spnTendencia.getSelectedItem()));

            personagem1.getHabilidades().add(new Habilidade(Habilidades.FORCA, Byte.valueOf(edForca.getText().toString())));
            personagem1.getHabilidades().add(new Habilidade(Habilidades.DESTREZA, Byte.valueOf(edDestreza.getText().toString())));
            personagem1.getHabilidades().add(new Habilidade(Habilidades.CONSTITUICAO, Byte.valueOf(edConstituicao.getText().toString())));
            personagem1.getHabilidades().add(new Habilidade(Habilidades.INTELIGENCIA, Byte.valueOf(edInteligencia.getText().toString())));
            personagem1.getHabilidades().add(new Habilidade(Habilidades.SABEDORIA, Byte.valueOf(edSabedoria.getText().toString())));
            personagem1.getHabilidades().add(new Habilidade(Habilidades.CARISMA, Byte.valueOf(edCarisma.getText().toString())));
            i.putExtra("idPersonagem",personagemBox.put(personagem1));
            Toast.makeText(this, personagem1.getHabilidades().get(0).getValor() + personagem1.getNome() + personagem1.getSexo() + personagem1.getRaca().getTarget().getNome() + personagem1.getTendencia().getNome(), Toast.LENGTH_SHORT).show();

            startActivity(i);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        tvForca.setText("");
        tvDestreza.setText("");
        tvConstituicao.setText("");
        tvInteligencia.setText("");
        tvSabedoria.setText("");
        tvCarisma.setText("");
        Raca raca = racaBox.query().equal(Raca_.nome,(String) parent.getItemAtPosition(position)).build().findFirst();
        for (Map.Entry<Habilidade,Byte> modhab:raca.getModHab().entrySet()) {
            switch (modhab.getKey().getNome()){
                case FORCA:
                    tvForca.setText(String.format("%s", modhab.getValue()));
                    break;
                case DESTREZA:
                    tvDestreza.setText(String.format("%s", modhab.getValue()));
                    break;
                case CONSTITUICAO:
                    tvConstituicao.setText(String.format("%s", modhab.getValue()));
                    break;
                case INTELIGENCIA:
                    tvInteligencia.setText(String.format("%s", modhab.getValue()));
                    break;
                case SABEDORIA:
                    tvSabedoria.setText(String.format("%s", modhab.getValue()));
                    break;
                case CARISMA:
                    tvCarisma.setText(String.format("%s", modhab.getValue()));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
