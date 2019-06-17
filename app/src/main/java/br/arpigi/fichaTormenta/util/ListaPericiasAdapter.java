package br.arpigi.fichaTormenta.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.model.Pericia;

public class ListaPericiasAdapter extends RecyclerView.Adapter<ListaPericiasAdapter.PericiasHolder> {

    private List<Pericia> pericias;
    private Context contexto;
    private ChamadaCheckBoxPericia chamadaCheckBoxPericia;

    public ListaPericiasAdapter(List<Pericia> pericias, Context contexto, ChamadaCheckBoxPericia chamadaCheckBoxPericia) {
        this.pericias = pericias;
        this.contexto = contexto;
        this.chamadaCheckBoxPericia = chamadaCheckBoxPericia;
    }

    @NonNull
    @Override
    public PericiasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.pericias_itens,viewGroup,false);
        return new ListaPericiasAdapter.PericiasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PericiasHolder periciasHolder, int i) {
        final Pericia pericia = pericias.get(i);
        periciasHolder.checkBoxPericia.setOnCheckedChangeListener(null);
        periciasHolder.checkBoxPericia.setChecked(pericia.isTreinada());
        periciasHolder.checkBoxPericia.setText(pericia.getNome().getNome());
        periciasHolder.tvTotal.setText(String.format("%s",pericia.getBonus()));
        periciasHolder.tvGraduacao.setText(String.format("%s",pericia.getGraduacao()));
        periciasHolder.tvHabilidade.setText(String.format("%s",pericia.getModHabilidade()));
        periciasHolder.checkBoxPericia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        chamadaCheckBoxPericia.periciaSelecionada(pericia,isChecked, periciasHolder.getAdapterPosition());
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return pericias.size();
    }

    public interface ChamadaCheckBoxPericia {
        void periciaSelecionada(Pericia pericia, boolean isChecked, int itemPosicao);
    }

    public class PericiasHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBoxPericia;
        private TextView tvTotal,tvGraduacao,tvHabilidade;

        public PericiasHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxPericia = itemView.findViewById(R.id.checkbox_pericia);
            tvTotal = itemView.findViewById(R.id.tv_total_pericia);
            tvGraduacao = itemView.findViewById(R.id.tv_graduacao_pericia);
            tvHabilidade = itemView.findViewById(R.id.tv_habilidade_pericia);
        }
    }
}
