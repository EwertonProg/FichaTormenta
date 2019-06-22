package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Talento;

public class ListaTalentosAdapter extends RecyclerView.Adapter<ListaTalentosAdapter.TalentosHolder> implements Filterable {

    private List<Talento> talentos;
    private List<Talento> todosTalentos;
    private Context contexto;
    private ChamadaBotaoTalento chamadaBotaoTalento;

    public ListaTalentosAdapter(List<Talento> talentos, Context contexto, ChamadaBotaoTalento chamadaBotaoTalento) {
        this.talentos = talentos;
        this.contexto = contexto;
        this.chamadaBotaoTalento = chamadaBotaoTalento;
        todosTalentos = new ArrayList<>(talentos);
    }

    @NonNull
    @Override
    public TalentosHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_talento_item,viewGroup,false);
        return new ListaTalentosAdapter.TalentosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TalentosHolder talentosHolder, int i) {
        talentosHolder.tvNome.setText(talentos.get(i).getNome());
        talentosHolder.tvPreRequisito.setText(talentos.get(i).preRequisitosParaTexto());
        talentosHolder.tvDescricao.setText(talentos.get(i).getDescricao());
        Resources resources = contexto.getResources();
        Drawable done = ResourcesCompat.getDrawable(resources,R.drawable.done_icon,null);
        Drawable add = ResourcesCompat.getDrawable(resources,R.drawable.add_icon,null);
        talentosHolder.imgbtnSelecionarTalento.setIcon((talentos.get(i).getOnPersonagem())?done:add);
        talentosHolder.imgbtnSelecionarTalento.setBackgroundColor((talentos.get(i).getOnPersonagem())?contexto.getColor(R.color.verde):contexto.getColor(R.color.primaria));
        talentosHolder.imgbtnSelecionarTalento.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chamadaBotaoTalento.talentoSelecionado(talentos.get(talentosHolder.getAdapterPosition()).getId(),talentosHolder.getAdapterPosition());
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return talentos.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Talento> listaFiltrada = new ArrayList<>();

                if (constraint == null || constraint.length() == 0){
                    listaFiltrada.addAll(todosTalentos);
                }else{
                    String charPesquisa = constraint.toString().toLowerCase().trim();
                    for (Talento talento: talentos){
                        if(talento.getNome().toLowerCase().contains(charPesquisa)){
                            listaFiltrada.add(talento);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listaFiltrada;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                talentos.clear();
                talentos.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
    }

     class TalentosHolder extends RecyclerView.ViewHolder{
        private MaterialButton imgbtnSelecionarTalento;
        private TextView tvNome,tvPreRequisito,tvDescricao;
         TalentosHolder(@NonNull View itemView) {
            super(itemView);
            imgbtnSelecionarTalento = itemView.findViewById(R.id.imgbtn_selecionar_talento);
            tvNome = itemView.findViewById(R.id.tv_nome_talento);
            tvPreRequisito = itemView.findViewById(R.id.tv_prerequisito_talento);
            tvDescricao = itemView.findViewById(R.id.tv_descricao_talento);
        }
    }

    public List<Talento> getTodosTalentos() {
        return todosTalentos;
    }

    public interface ChamadaBotaoTalento{
        void talentoSelecionado(Long idBancoTalento, Integer posLista);
    }
}
