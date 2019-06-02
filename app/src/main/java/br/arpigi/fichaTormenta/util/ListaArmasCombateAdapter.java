package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Arma;

public class ListaArmasCombateAdapter extends RecyclerView.Adapter<ListaArmasCombateAdapter.ListaArmasCombateHolder>{

    List<Arma> armas;
    Context contexto;

    public ListaArmasCombateAdapter(List<Arma> armas, Context contexto) {
        this.armas = armas;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ListaArmasCombateHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaArmasCombateHolder listaArmasCombateHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return armas.size();
    }

    public class ListaArmasCombateHolder extends RecyclerView.ViewHolder {

        TextView tvNome, tvDano, tvCritico, tvTipo, tvDistancia;

        public ListaArmasCombateHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_nome_item_atk_combate);
            tvDano = itemView.findViewById(R.id.tv_dano_item_atk_combate);
            tvCritico = itemView.findViewById(R.id.critico_item_atk_layout);
            tvTipo = itemView.findViewById(R.id.tv_tipo_item_atk_combate);
            tvDistancia = itemView.findViewById(R.id.tv_dist_atk_item_combate);
        }
    }

}
