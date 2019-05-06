package br.arpigi.fichaTormenta.util;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Banco.init(this);
    }
}
