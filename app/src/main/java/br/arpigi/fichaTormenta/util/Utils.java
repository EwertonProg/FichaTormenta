package br.arpigi.fichaTormenta.util;

import android.widget.EditText;

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
}
