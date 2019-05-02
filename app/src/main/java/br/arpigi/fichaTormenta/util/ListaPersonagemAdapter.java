package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Personagem;

public class ListaPersonagemAdapter extends RecyclerView.Adapter<ListaPersonagemAdapter.listaPersonagemHolder> {
    private List<Personagem> personagens;
    private Context contexto;
    private Integer layout;

    public ListaPersonagemAdapter(ArrayList<Personagem> personagens, Context contexto) {

        this.personagens = personagens;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public listaPersonagemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_personagem_item, viewGroup, false);
        return new listaPersonagemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaPersonagemHolder listaPersonagemHolder, int i) {
        listaPersonagemHolder.raca.setText("Raça: " + personagens.get(i).getRaca().getTarget().getNome());
        listaPersonagemHolder.nivelPersonagem.setText("Nivel: " + personagens.get(i).getNvDePersonagem());
        listaPersonagemHolder.nomePersonagem.setText(personagens.get(i).getNome());
        listaPersonagemHolder.imagemPersonagem.setImageAlpha(R.drawable.lena);
        StringBuilder sb = new StringBuilder();
        for (Classe classe : personagens.get(i).getClasses()) {
            sb.append(classe.getNome() + " " + classe.getNivelAtual() + ", ");
        }
        listaPersonagemHolder.classes.setText("Classes: " + sb.toString());
    }

    @Override
    public int getItemCount() {
        return personagens.size();
    }

    public class listaPersonagemHolder extends RecyclerView.ViewHolder {
        private TextView nomePersonagem, nivelPersonagem, raca, classes;
        private ImageView imagemPersonagem;

        public listaPersonagemHolder(@NonNull View itemView) {
            super(itemView);
            nomePersonagem = itemView.findViewById(R.id.tv_nome_personagem_lista);
            nivelPersonagem = itemView.findViewById(R.id.tv_nivel_personagem_lista);
            raca = itemView.findViewById(R.id.tv_raca_personagem_lista);
            classes = itemView.findViewById(R.id.tv_classe_personagem_lista);
            imagemPersonagem = itemView.findViewById(R.id.img_imagem_personagem_lista);
        }


    }

}
