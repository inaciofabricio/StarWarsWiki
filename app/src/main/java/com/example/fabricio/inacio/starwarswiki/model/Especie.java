package com.example.fabricio.inacio.starwarswiki.model;


import com.google.gson.annotations.SerializedName;

public class Especie {

    @SerializedName("name")
    public String nome;
    @SerializedName("classification")
    public String classificacao;
    @SerializedName("language")
    public String lingua;
    @SerializedName("average_height")
    public String altutaMedia;
}
