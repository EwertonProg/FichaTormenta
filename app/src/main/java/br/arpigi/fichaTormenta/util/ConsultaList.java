package br.arpigi.fichaTormenta.util;

import android.os.AsyncTask;

import io.objectbox.query.Query;

public class ConsultaList extends AsyncTask<Query<?>, Void, Object> {
        @Override
        protected Object doInBackground(Query<?>... queries) {
            return queries[0].findFirst();
        }
    }
