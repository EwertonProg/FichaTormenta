package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.model.Magia;

public class ListaMagiasAdapter extends RecyclerView.Adapter<ListaMagiasAdapter.MagiaHolder> implements Filterable {

    private List<Magia> magias;
    private List<Magia> todasMagias;
    private Context contexto;
    private ChamadaBotaoMagia chamadaBotaoMagia;

    public ListaMagiasAdapter(List<Magia> magias, Context contexto, ChamadaBotaoMagia chamadaBotaoMagia) {
        this.magias = magias;
        this.contexto = contexto;
        this.chamadaBotaoMagia = chamadaBotaoMagia;
        todasMagias = new ArrayList<>(magias);
    }

    @NonNull
    @Override
    public MagiaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MagiaHolder magiaHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Magia> listaFiltrada = new ArrayList<>();

                if (constraint == null || constraint.length() == 0){
                    listaFiltrada.addAll(todasMagias);
                }else{
                    String charPesquisa = constraint.toString().toLowerCase().trim();
                    for (Magia magia: magias){
                        if(magia.getNome().toLowerCase().contains(charPesquisa)){
                            listaFiltrada.add(magia);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listaFiltrada;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                magias.clear();
                magias.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };

    }

    public interface ChamadaBotaoMagia{
        void magiaSelecionada(Long idBancoTalento, Integer posLista);
    }

    class MagiaHolder extends RecyclerView.ViewHolder {

        public MagiaHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
