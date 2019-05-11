package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Classe;

public class ListaSelecaoClasseAdapter extends RecyclerView.Adapter<ListaSelecaoClasseAdapter.ClassesHolder> {
    private List<Classe> classes;
    private Context contexto;
    ChamadaBotaoClasse chamadaBotaoClasse;

    public ListaSelecaoClasseAdapter(ArrayList<Classe> classes, Context contexto, ChamadaBotaoClasse chamadaBotaoClasse) {
        this.chamadaBotaoClasse = chamadaBotaoClasse;
        this.classes = classes;
        this.contexto = contexto;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesHolder listaClassesHolder, int i) {
        listaClassesHolder.nomeClasse.setText(classes.get(i).getNome());
        listaClassesHolder.descricaoClasse.setText(classes.get(i).getDescricao());
        listaClassesHolder.btnSelecionarClasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamadaBotaoClasse.classeSelecionada(listaClassesHolder.nomeClasse.getText().toString());
            }
        });

    }

    @NonNull
    @Override
    public ClassesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_classe_item, viewGroup, false);
        return new ListaSelecaoClasseAdapter.ClassesHolder(view);
    }

    public interface ChamadaBotaoClasse{
        void classeSelecionada(String classe);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ClassesHolder extends RecyclerView.ViewHolder {
        private TextView nomeClasse,descricaoClasse;
        private Button btnSelecionarClasse;

        public ClassesHolder(@NonNull View itemView) {
            super(itemView);
            nomeClasse = itemView.findViewById(R.id.tv_nome_classe_selecao);
            descricaoClasse = itemView.findViewById(R.id.tv_descricao_classe_selecao);
            btnSelecionarClasse = itemView.findViewById(R.id.btn_selecionar_classe_personagem);
        }
    }


}
