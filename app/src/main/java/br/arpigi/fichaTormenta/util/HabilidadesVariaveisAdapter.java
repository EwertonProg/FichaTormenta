package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.enums.Habilidades;

public class HabilidadesVariaveisAdapter extends RecyclerView.Adapter<HabilidadesVariaveisAdapter.HabilidadesVariaveisHolder> {

    private Context contexto;
    private List<Habilidades> habilidades;
    private ChamadaCheckBoxHabilidade chamadaCheckBoxHabilidade;

    public HabilidadesVariaveisAdapter(Context contexto, List<Habilidades> habilidades, ChamadaCheckBoxHabilidade chamadaCheckBoxHabilidade) {
        this.contexto = contexto;
        this.habilidades = habilidades;
        this.chamadaCheckBoxHabilidade = chamadaCheckBoxHabilidade;
    }

    @NonNull
    @Override
    public HabilidadesVariaveisHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.habilidades_variaveis_item,viewGroup,false);
        return new HabilidadesVariaveisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabilidadesVariaveisHolder habilidadesVariaveisHolder, int i) {
        final Habilidades habilidade =  habilidades.get(i);
        habilidadesVariaveisHolder.checkBox.setOnCheckedChangeListener(null);
        habilidadesVariaveisHolder.checkBox.setText(habilidade.getNome());
        habilidadesVariaveisHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                habilidadesVariaveisHolder.checkBox.setChecked(chamadaCheckBoxHabilidade.periciaSelecionada(isChecked, habilidadesVariaveisHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return habilidades.size();
    }

    public interface ChamadaCheckBoxHabilidade {
        boolean periciaSelecionada(boolean isChecked, int posicao);
    }

    public class HabilidadesVariaveisHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;

        public HabilidadesVariaveisHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_habilidade_variavel);
        }
    }
}
