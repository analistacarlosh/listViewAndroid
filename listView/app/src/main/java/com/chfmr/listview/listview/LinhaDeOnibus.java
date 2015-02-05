package com.chfmr.listview.listview;

/**
 * Created by carlosfmr on 04/02/15.
 */
public class LinhaDeOnibus {

    public String nome;
    public int numero;
    public String sentido_id;
    public String sentido_volda;

    public LinhaDeOnibus(String nome, int numero, String sentido_id,
                         String sentido_volda){
        this.nome = nome;
        this.numero = numero;
        this.sentido_id = sentido_id;
        this.sentido_volda = sentido_volda;
    }
}
