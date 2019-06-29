package br.arpigi.fichaTormenta.util;

import android.os.AsyncTask;

public class DialogHabAsync extends AsyncTask<HabilidadesDialog,Void,HabilidadesDialog> {
    @Override
    protected HabilidadesDialog doInBackground(HabilidadesDialog... dialog) {
        dialog[0].show(dialog[0].getManager(),"DialogHabilidadesVariaveis");
        return dialog[0];
    }
}
