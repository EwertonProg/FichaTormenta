package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Personagem;

public class ListaPersonagemAdapter extends RecyclerView.Adapter<ListaPersonagemAdapter.ListaPersonagemHolder> {
    private List<Personagem> personagens;
    private Context contexto;
    ClickPersonagem clickPersonagem;

    public ListaPersonagemAdapter(ArrayList<Personagem> personagens, Context contexto, ClickPersonagem clickPersonagem) {

        this.personagens = personagens;
        this.contexto = contexto;
        this.clickPersonagem = clickPersonagem;
    }

    @NonNull
    @Override
    public ListaPersonagemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_personagem_item, viewGroup, false);
        return new ListaPersonagemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPersonagemHolder listaPersonagemHolder, int i) {
        listaPersonagemHolder.raca.setText(String.format("Raça: %s", personagens.get(i).getRaca().getTarget().getNome()));
        listaPersonagemHolder.nivelPersonagem.setText(String.format("Nivel: %s", personagens.get(i).getNvDePersonagem()));
        listaPersonagemHolder.nomePersonagem.setText(personagens.get(i).getNome());
        Drawable drawable = AppCompatResources.getDrawable(contexto,personagens.get(i).getImagemPadrao());
        listaPersonagemHolder.imagemPersonagem.setBackground(drawable);
        listaPersonagemHolder.classes.setText(String.format("Classes: %s ", personagens.get(i).classesString()));
        listaPersonagemHolder.bind(personagens.get(i),clickPersonagem);

    }

    @Override
    public int getItemCount() {
        return personagens.size();
    }

    public interface ClickPersonagem{
        void personagemClicado(Long id);
    }

    public class ListaPersonagemHolder extends RecyclerView.ViewHolder {
        private TextView nomePersonagem, nivelPersonagem, raca, classes;
        private ImageView imagemPersonagem;

        public ListaPersonagemHolder(@NonNull View itemView) {
            super(itemView);
            nomePersonagem = itemView.findViewById(R.id.tv_nome_personagem_lista);
            nivelPersonagem = itemView.findViewById(R.id.tv_nivel_personagem_lista);
            raca = itemView.findViewById(R.id.tv_raca_personagem_lista);
            classes = itemView.findViewById(R.id.tv_classe_personagem_lista);
            imagemPersonagem = itemView.findViewById(R.id.img_imagem_personagem_lista);
        }

        public void bind(final Personagem personagem,final ClickPersonagem clickPersonagem){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickPersonagem.personagemClicado(personagem.getId());
                }
            });
        }

    }

}
