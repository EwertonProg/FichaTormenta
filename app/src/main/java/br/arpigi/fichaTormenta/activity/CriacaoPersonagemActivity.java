package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Tendencias;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Raca_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ConsultaUnique;
import br.arpigi.fichaTormenta.util.DialogHabAsync;
import br.arpigi.fichaTormenta.util.HabilidadesDialog;
import br.arpigi.fichaTormenta.util.Utils;
import io.objectbox.Box;

public class CriacaoPersonagemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, HabilidadesDialog.RetornoDialog {
    EditText edNome,edForca,edForcaMod,edDestreza,edDestrezaMod,edConstituicao,edConstituicaoMod
            ,edInteligencia,edInteligenciaMod,edSabedoria,edSabedoriaMod,edCarisma,edCarismaMod;
    TextView tvForca,tvDestreza,tvConstituicao,tvInteligencia,tvSabedoria,tvCarisma;
    Spinner spnRaca,spnTendencia,spnSexo;
    Intent i;
    Box<Raca> racaBox;
    Box<Personagem> personagemBox;
    HabilidadesDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_personagem);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Criação de Personagem");

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

        edForca.addTextChangedListener(Utils.teste(Habilidades.FORCA,this));
        edDestreza.addTextChangedListener(Utils.teste(Habilidades.DESTREZA,this));
        edConstituicao.addTextChangedListener(Utils.teste(Habilidades.CONSTITUICAO,this));
        edInteligencia.addTextChangedListener(Utils.teste(Habilidades.INTELIGENCIA,this));
        edSabedoria.addTextChangedListener(Utils.teste(Habilidades.SABEDORIA,this));
        edCarisma.addTextChangedListener(Utils.teste(Habilidades.CARISMA,this));

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

            startActivityForResult(i,1);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ConsultaUnique task = new ConsultaUnique();
        task.execute(racaBox.query().equal(Raca_.nome,(String) parent.getItemAtPosition(position)).build());
        Raca raca = null;
        try {
            raca = (Raca) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(raca.getHabVariavel()){
            FragmentManager manager = this.getSupportFragmentManager();
            new DialogHabAsync().execute(HabilidadesDialog.newInstance(raca.getId(), this, manager));

        }else adicionarModificadores(raca);
    }

    private void adicionarModificadores(Raca raca){

        tvForca.setText("");
        tvDestreza.setText("");
        tvConstituicao.setText("");
        tvInteligencia.setText("");
        tvSabedoria.setText("");
        tvCarisma.setText("");
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
        edForca.setText(edForca.getText());
        edDestreza.setText(edDestreza.getText());
        edConstituicao.setText(edConstituicao.getText());
        edInteligencia.setText(edInteligencia.getText());
        edSabedoria.setText(edSabedoria.getText());
        edCarisma.setText(edCarisma.getText());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        personagemBox.closeThreadResources();
        racaBox.closeThreadResources();
    }

    @Override
    public void clickPositivo(Raca raca) {
        adicionarModificadores(raca);
    }

    @Override
    public void clickNegativo() {
        spnRaca.setSelection(1);
    }


    public EditText getEdNome() {
        return edNome;
    }

    public EditText getEdForca() {
        return edForca;
    }

    public EditText getEdForcaMod() {
        return edForcaMod;
    }

    public EditText getEdDestreza() {
        return edDestreza;
    }

    public EditText getEdDestrezaMod() {
        return edDestrezaMod;
    }

    public EditText getEdConstituicao() {
        return edConstituicao;
    }

    public EditText getEdConstituicaoMod() {
        return edConstituicaoMod;
    }

    public EditText getEdInteligencia() {
        return edInteligencia;
    }

    public EditText getEdInteligenciaMod() {
        return edInteligenciaMod;
    }

    public EditText getEdSabedoria() {
        return edSabedoria;
    }

    public EditText getEdSabedoriaMod() {
        return edSabedoriaMod;
    }

    public EditText getEdCarisma() {
        return edCarisma;
    }

    public EditText getEdCarismaMod() {
        return edCarismaMod;
    }

    public TextView getTvForca() {
        return tvForca;
    }

    public TextView getTvDestreza() {
        return tvDestreza;
    }

    public TextView getTvConstituicao() {
        return tvConstituicao;
    }

    public TextView getTvInteligencia() {
        return tvInteligencia;
    }

    public TextView getTvSabedoria() {
        return tvSabedoria;
    }

    public TextView getTvCarisma() {
        return tvCarisma;
    }

    public Spinner getSpnRaca() {
        return spnRaca;
    }

    public Spinner getSpnTendencia() {
        return spnTendencia;
    }

    public Spinner getSpnSexo() {
        return spnSexo;
    }

    public Intent getI() {
        return i;
    }

    public Box<Raca> getRacaBox() {
        return racaBox;
    }

    public Box<Personagem> getPersonagemBox() {
        return personagemBox;
    }

    public HabilidadesDialog getDialog() {
        return dialog;
    }
}