package com.example.fabricio.inacio.starwarswiki.model;

import com.google.gson.annotations.SerializedName;

public class Pessoa {

    @SerializedName("name")
    public String nome;
    @SerializedName("mass")
    public String peso;
    @SerializedName("height")
    public String altura;
    @SerializedName("gender")
    public String genero;

}
