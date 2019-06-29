package br.arpigi.fichaTormenta.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import br.arpigi.fichaTormenta.activity.CriacaoPersonagemActivity;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.model.Habilidade;


public abstract class Utils {
    public static boolean validarEditText(EditText... edits) {
        boolean b = true;
        for (EditText ed : edits) {
            if (ed.getText().toString().length() == 0) {
                ed.setError("Este campo é obrigatorio");
                b = false;
            }
        }

        return b;
    }

    public static TextWatcher teste(Habilidades habilidades, CriacaoPersonagemActivity activity) {
        return new TextWatcher() {
            int modRaca;
            EditText edMod = new EditText(activity);

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    switch (habilidades.toString()) {
                        case "FORCA":
                            edMod = activity.getEdForcaMod();
                            modRaca = Integer.parseInt(activity.getTvForca().getText().toString());
                            break;
                        case "DESTREZA":
                            edMod = activity.getEdDestrezaMod();
                            modRaca = Integer.parseInt(activity.getTvDestreza().getText().toString());
                            break;
                        case "CONSTITUICAO":
                            edMod = activity.getEdConstituicaoMod();
                            modRaca = Integer.parseInt(activity.getTvConstituicao().getText().toString());
                            break;
                        case "SABEDORIA":
                            edMod = activity.getEdSabedoriaMod();
                            modRaca = Integer.parseInt(activity.getTvSabedoria().getText().toString());
                            break;
                        case "INTELIGENCIA":
                            edMod = activity.getEdInteligenciaMod();
                            modRaca = Integer.parseInt(activity.getTvInteligencia().getText().toString());
                            break;
                        case "CARISMA":
                            edMod = activity.getEdCarismaMod();
                            modRaca = Integer.parseInt(activity.getTvCarisma().getText().toString());
                            break;
                    }

                } catch (java.lang.NumberFormatException e) {
                    modRaca = 0;
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {
                    edMod.setText(Habilidade.calcularModificador(Integer.parseInt(charSequence.toString()) + modRaca));
                } catch (java.lang.NumberFormatException e) {
                    edMod.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                modRaca = 0;
//                edMod = null;
            }
        };
    }
}
