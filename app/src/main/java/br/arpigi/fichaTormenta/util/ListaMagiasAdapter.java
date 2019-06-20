package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        magiaHolder.tvNivelMagia.setText(String.format("Nivel: %s",todasMagias.get(i).getNivel()));
        magiaHolder.tvTipoMagia.setText(String.format("Tipo de Magia: %s",todasMagias.get(i).getTipoMagia().getNome()));
        magiaHolder.tvDescritores.setText(todasMagias.get(i).descritoresParaTexto());
        magiaHolder.tvTempoDeExecucao.setText(String.format("Tempo de Execução: %s",todasMagias.get(i).getTempoDeExecucao()));
        magiaHolder.tvAlcance.setText(String.format("Alcance: %s",todasMagias.get(i).getAlcance()));
        magiaHolder.tvAlvo.setText(String.format("Alvo: %s",todasMagias.get(i).getAlvo()));
        magiaHolder.tvDuracao.setText(String.format("Duração: %s",todasMagias.get(i).getDuracao()));
        magiaHolder.tvResistencia.setText(String.format("Teste de resistência %s",todasMagias.get(i).getResistencia()));
        magiaHolder.tvDescricao.setText(todasMagias.get(i).getDescricao());
        magiaHolder.tvEfeito.setText(String.format("Efeito: %s",todasMagias.get(i).getEfeito()));
        magiaHolder.imgbtnSelecionarMagia.setImageResource((magias.get(i).getOnPersonagem())?R.drawable.done_icon:R.drawable.add_icon);
        magiaHolder.imgbtnSelecionarMagia.setBackgroundColor((magias.get(i).getOnPersonagem())?contexto.getColor(R.color.verde):contexto.getColor(R.color.primaria));
        if(todasMagias.get(i).getArea()==null){
            magiaHolder.tvArea.setHeight(1);
            magiaHolder.tvArea.setVisibility(View.INVISIBLE);
        }else{
            magiaHolder.tvArea.setText(String.format("Área: %s",todasMagias.get(i).getArea()));
        }
        magiaHolder.imgbtnSelecionarMagia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamadaBotaoMagia.magiaSelecionada(magias.get(magiaHolder.getAdapterPosition()).getId(),magiaHolder.getAdapterPosition());
            }
        });

    }

    public List<Magia> getTodasMagias() {
        return todasMagias;
    }

    @Override
    public int getItemCount() {
        return magias.size();
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
        TextView tvNomeMagia,tvNivelMagia,tvTipoMagia, tvDescritores, tvTempoDeExecucao,tvAlcance,tvAlvo,tvDuracao,tvResistencia,tvDescricao,tvEfeito,tvArea;

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
            tvEfeito = itemView.findViewById(R.id.tv_efeito_magia);
            tvArea = itemView.findViewById(R.id.tv_area_magia);
        }
    }
}
