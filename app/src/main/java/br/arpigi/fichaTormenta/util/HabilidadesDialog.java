package br.arpigi.fichaTormenta.util;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.model.Raca;
import io.objectbox.Box;

public class HabilidadesDialog extends DialogFragment implements HabilidadesVariaveisAdapter.ChamadaCheckBoxHabilidade {

    private Raca raca;
    private Box<Raca> racaBox;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public static HabilidadesDialog newInstance(Long idRaca){
        HabilidadesDialog dialog = new HabilidadesDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("idRaca",idRaca);
        dialog.setArguments(bundle);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        racaBox = Banco.get().boxFor(Raca.class);
        raca = racaBox.get(getArguments().getLong("idRaca"));
        AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("Selecione sua habilidades")
                .setMessage("Selecione "+raca.getQtdHabVariavel().size()+" Habilidades para adicionar +"+raca.getQtdHabVariavel().get(0)).create();
        View rootView = layoutInflater.inflate(R.layout.habilidades_variaveis_dialog,null);

        recyclerView = rootView.findViewById(R.id.habilidade_variavel_recycler);
        adapter = new HabilidadesVariaveisAdapter(getContext(),raca.getHabVariavelAumento(), this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        dialog.setView(rootView);

        return dialog;
    }

    @Override
    public void periciaSelecionada(Habilidades habilidade, boolean isChecked, int itemPosicao) {

    }
}
