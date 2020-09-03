package com.curso.viewmodeltarea.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private int textoId;
    private boolean respuesta;

    public MainViewModel(int textoId, boolean respuesta) {
        this.textoId = textoId;
        this.respuesta = respuesta;
    }

    public int getTextoId() {
        return textoId;
    }

    public void setTextoId(int textoId) {
        this.textoId = textoId;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }



}