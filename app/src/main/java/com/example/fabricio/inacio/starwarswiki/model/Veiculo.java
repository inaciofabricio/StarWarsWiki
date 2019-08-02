package com.example.fabricio.inacio.starwarswiki.model;

import com.google.gson.annotations.SerializedName;

public class Veiculo {

    @SerializedName("name")
    public String nome;
    @SerializedName("model")
    public String modelo;
    @SerializedName("manufacturer")
    public String fabricante;
    @SerializedName("cost_in_credits")
    public String valor;
}
