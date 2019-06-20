package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Armadura;
import br.arpigi.fichaTormenta.model.Escudo;
import br.arpigi.fichaTormenta.model.Item;

public class ListaArmaduraEscudoCombateAdapter extends RecyclerView.Adapter<ListaArmaduraEscudoCombateAdapter.ListaArmaduraEscudoCombateHolder>{
    private List<Item> itensDef;
    private Context contexto;

    public ListaArmaduraEscudoCombateAdapter(Context contexto, List<Item> itensDef) {
        this.itensDef = itensDef;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ListaArmaduraEscudoCombateHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.armadura_escudo_combate_item, viewGroup,false);
        return new ListaArmaduraEscudoCombateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaArmaduraEscudoCombateHolder listaArmasCombateHolder, int i) {
        if (itensDef.get(i) instanceof Armadura) {
            Armadura armadura = (Armadura) itensDef.get(i);
            listaArmasCombateHolder.tvNome.setText(armadura.getNome());
            listaArmasCombateHolder.tvBonusCa.setText(String.format("%s", armadura.getBonusCA()));
            listaArmasCombateHolder.tvMaxDes.setText(String.format("%s", armadura.getMaxDes()));
            listaArmasCombateHolder.tvPen.setText(String.format("%s", armadura.getPenArmadura()));
        } else if(itensDef.get(i) instanceof Escudo){
            Escudo escudo = (Escudo) itensDef.get(i);
            listaArmasCombateHolder.tvNome.setText(escudo.getNome());
            listaArmasCombateHolder.tvBonusCa.setText(String.format("%s", escudo.getBonusCA()));
            listaArmasCombateHolder.tvPen.setText(String.format("%s", escudo.getPenArmadura()));
            listaArmasCombateHolder.tvMaxDes.setText("-");
        }
    }

    @Override
    public int getItemCount() {
        return itensDef.size();
    }

    public class ListaArmaduraEscudoCombateHolder extends RecyclerView.ViewHolder {

        TextView tvNome, tvBonusCa, tvMaxDes, tvPen;

        public ListaArmaduraEscudoCombateHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_nome_item_def_combate);
            tvBonusCa = itemView.findViewById(R.id.tv_bonus_item_def_combate);
            tvMaxDes = itemView.findViewById(R.id.tv_mod_des_item_def_combate);
            tvPen = itemView.findViewById(R.id.tv_pen_item_def_combate);
        }
    }

}
