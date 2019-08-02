package com.example.fabricio.inacio.starwarswiki.model;


import com.google.gson.annotations.SerializedName;

public class Planeta {

    @SerializedName("name")
    public String nome;
    @SerializedName("diameter")
    public String diametro;
    @SerializedName("climate")
    public String clima;
    @SerializedName("population")
    public String populacao;
}
