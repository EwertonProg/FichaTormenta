package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
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
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_magia_item,viewGroup,false);
        return new ListaMagiasAdapter.MagiaHolder(view);
    }

    public void onBindViewHolder(@NonNull MagiaHolder magiaHolder, int i) {
        magiaHolder.tvNomeMagia.setText(todasMagias.get(i).getNome());
        magiaHolder.tvNivelMagia.setText(todasMagias.get(i).getNivel());
        magiaHolder.tvTipoMagia.setText(todasMagias.get(i).getTipoMagia().getNome());
        magiaHolder.tvDescritores.setText(todasMagias.get(i).descritoresParaTexto());
        magiaHolder.tvTempoDeExecucao.setText(todasMagias.get(i).getTempoDeExecucao());
        magiaHolder.tvAlcance.setText(todasMagias.get(i).getAlcance());
        magiaHolder.tvAlvo.setText(todasMagias.get(i).getAlvo());
        magiaHolder.tvDuracao.setText(todasMagias.get(i).getDuracao());
        magiaHolder.tvResistencia.setText(todasMagias.get(i).getResistencia());
        magiaHolder.tvDescricao.setText(todasMagias.get(i).getDescricao());
        magiaHolder.imgbtnSelecionarMagia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamadaBotaoMagia.magiaSelecionada(magias.get(i).getId(),i);
            }
        });

    }

    public List<Magia> getTodasMagias() {
        return todasMagias;
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
        void magiaSelecionada(Long idBancoMagia, Integer posLista);
    }

    class MagiaHolder extends RecyclerView.ViewHolder {

        ImageButton imgbtnSelecionarMagia;
        TextView tvNomeMagia,tvNivelMagia,tvTipoMagia, tvDescritores, tvTempoDeExecucao,tvAlcance,tvAlvo,tvDuracao,tvResistencia,tvDescricao;

        public MagiaHolder(@NonNull View itemView) {
            super(itemView);
            imgbtnSelecionarMagia = itemView.findViewById(R.id.imgbtn_selecionar_magia);
            tvNomeMagia = itemView.findViewById(R.id.tv_nome_magia);
            tvNivelMagia = itemView.findViewById(R.id.tv_nivel_magia);
            tvTipoMagia = itemView.findViewById(R.id.tv_tipo_magia);
            tvDescritores = itemView.findViewById(R.id.tv_descritores_magia);
            tvTempoDeExecucao = itemView.findViewById(R.id.tv_tempo_execucao_magia);
            tvAlcance = itemView.findViewById(R.id.tv_alcance_magia);
            tvAlvo = itemView.findViewById(R.id.tv_alvo_magia);
            tvDuracao = itemView.findViewById(R.id.tv_duracao_magia);
            tvResistencia = itemView.findViewById(R.id.tv_resistencia_magia);
            tvDescricao = itemView.findViewById(R.id.tv_descricao_magia);
        }
    }
}
