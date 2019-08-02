package com.example.fabricio.inacio.starwarswiki.model;


import com.google.gson.annotations.SerializedName;

public class Aeronave {

    @SerializedName("name")
    public String nome;
    @SerializedName("model")
    public String modelo;
    @SerializedName("manufacturer")
    public String fabricante;
    @SerializedName("starship_class")
    public String classe;
    @SerializedName("cost_in_credits")
    public String valor;
}
