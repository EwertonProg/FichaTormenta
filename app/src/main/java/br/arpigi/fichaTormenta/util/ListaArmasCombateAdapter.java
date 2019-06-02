package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Arma;

public class ListaArmasCombateAdapter extends RecyclerView.Adapter<ListaArmasCombateAdapter.ListaArmasCombateHolder>{

    private List<Arma> armas;
    private Context contexto;

    public ListaArmasCombateAdapter(Context contexto,List<Arma> armas) {
        this.armas = armas;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ListaArmasCombateHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.armas_combate_item, viewGroup,false);
        return new ListaArmasCombateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaArmasCombateHolder listaArmasCombateHolder, int i) {
        if(!armas.isEmpty()) {
        Arma arma = armas.get(i);
        listaArmasCombateHolder.tvNome.setText(arma.getNome());
        listaArmasCombateHolder.tvDano.setText(arma.getDano());
        StringBuilder critico = new StringBuilder();
        if(arma.getCritico()==null||arma.getCritico().equals((byte)20)){
            critico.append("20");
        }else{
            critico.append(arma.getCritico());
            critico.append("-20");
        }
        if(!(arma.getModCritico()==null||arma.getModCritico().equals((byte)2))){
            critico.append("/x");
            critico.append(arma.getModCritico());
        }
        listaArmasCombateHolder.tvCritico.setText(critico.toString());

        listaArmasCombateHolder.tvTipo.setText(arma.getTipo().getNome());
        listaArmasCombateHolder.tvDistancia.setText(String.format("%sm",arma.getDistancia()));
        }
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
            tvCritico = itemView.findViewById(R.id.tv_critico_item_atk_combate);
            tvTipo = itemView.findViewById(R.id.tv_tipo_item_atk_combate);
            tvDistancia = itemView.findViewById(R.id.tv_dist_atk_item_combate);
        }
    }

}
