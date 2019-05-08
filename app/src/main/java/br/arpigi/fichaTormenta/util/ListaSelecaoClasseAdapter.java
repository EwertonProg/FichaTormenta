package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Classe;

public class ListaSelecaoClasseAdapter extends RecyclerView.Adapter<ListaSelecaoClasseAdapter.ClassesHolder> {
    private List<Classe> classes;
    private Context contexto;

    public ListaSelecaoClasseAdapter(ArrayList<Classe> classes, Context contexto) {

        this.classes = classes;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ClassesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_classe_item, viewGroup, false);
        return new ListaSelecaoClasseAdapter.ClassesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesHolder listaClassesHolder, int i) {
        listaClassesHolder.nomeClasse.setText(classes.get(i).getNome());
        listaClassesHolder.descricaoClasse.setText(classes.get(i).getDescricao());

    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ClassesHolder extends RecyclerView.ViewHolder {
        private TextView nomeClasse,descricaoClasse;

        public ClassesHolder(@NonNull View itemView) {
            super(itemView);
            nomeClasse = itemView.findViewById(R.id.tv_nome_classe_selecao);
            descricaoClasse = itemView.findViewById(R.id.tv_descricao_classe_selecao);
        }
    }
}
