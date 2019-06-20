package br.arpigi.fichaTormenta.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Raca;
import io.objectbox.Box;

public class HabilidadesDialog extends DialogFragment implements HabilidadesVariaveisAdapter.ChamadaCheckBoxHabilidade {

    private List<Habilidades> habilidades;
    private List<Habilidades> habilidadesSelecionadas = new ArrayList<>();
    private int count = 0;
    private Raca raca;
    private RetornoDialog retornoDialog;

    private AlertDialog dialog;

    public static HabilidadesDialog newInstance(Long idRaca, RetornoDialog retornoDialog){
        HabilidadesDialog dialog = new HabilidadesDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("idRaca",idRaca);
        dialog.setArguments(bundle);
        dialog.retornoDialog = retornoDialog;
        dialog.setCancelable(false);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        Box<Raca> racaBox = Banco.get().boxFor(Raca.class);
        raca = racaBox.get(getArguments().getLong("idRaca"));
        habilidades = raca.getHabVariavelAumento();
        View rootView = layoutInflater.inflate(R.layout.habilidades_variaveis_dialog,null);
        dialog = new AlertDialog.Builder(getActivity()).setTitle("Selecione sua habilidades")
                .setMessage("Selecione "+ raca.getQtdHabVariavel().size()+" Habilidades para adicionar +"+ raca.getQtdHabVariavel().get(0)).setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int iterador = 0;
                        for(Habilidades habilidade : habilidadesSelecionadas){
                            Habilidade h = new Habilidade(habilidade);
                            Map<Habilidade, Byte> modHab = raca.getModHab();
                            if(modHab.containsKey(h)){
                                byte b = (byte) (modHab.get(h) + raca.getQtdHabVariavel().get(iterador));
                                modHab.remove(h);
                                modHab.put(h,b);
                            }else{
                                modHab.put(h,raca.getQtdHabVariavel().get(iterador));
                            }
                            iterador++;
                        }
                        retornoDialog.clickPositivo(raca);
                    }
                }).setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        retornoDialog.clickNegativo();
                    }
                }).create();

        RecyclerView recyclerView = rootView.findViewById(R.id.habilidade_variavel_recycler);
        RecyclerView.Adapter adapter = new HabilidadesVariaveisAdapter(getContext(), habilidades, this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        dialog.setView(rootView);
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);

        return dialog;
    }

    @Override
    public boolean periciaSelecionada( boolean isChecked, int posicao) {
        if(isChecked && count < raca.getQtdHabVariavel().size()){
            habilidadesSelecionadas.add(habilidades.get(posicao));
            count++;
            if(count == raca.getQtdHabVariavel().size()){
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
            }
            return true;
        }else if(isChecked){
            Toast.makeText(getContext(),"O número máximo de habilidades foi selecionado",Toast.LENGTH_SHORT).show();
        }else{
            habilidadesSelecionadas.remove(habilidades.get(posicao));
            count--;
            if(count != raca.getQtdHabVariavel().size()){
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
            }
        }
            return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public interface RetornoDialog{
        public void clickPositivo(Raca raca);
        public void clickNegativo();
    }

}
