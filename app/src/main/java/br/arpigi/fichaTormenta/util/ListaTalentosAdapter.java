package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.arpigi.fichaTormenta.model.Talento;

public class ListaTalentosAdapter extends RecyclerView.Adapter<ListaTalentosAdapter.TalentosHolder> {

    private List<Talento> talentos;
    private Context contexto;

    public ListaTalentosAdapter(List<Talento> talentos, Context contexto) {
        this.talentos = talentos;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public TalentosHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TalentosHolder talentosHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class TalentosHolder extends RecyclerView.ViewHolder{

        public TalentosHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
