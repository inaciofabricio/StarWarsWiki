package com.example.fabricio.inacio.starwarswiki.model;


import com.google.gson.annotations.SerializedName;

public class Filme {

    @SerializedName("title")
    public String titulo;
    @SerializedName("director")
    public String diretor;
    @SerializedName("producer")
    public String produtor;
    @SerializedName("release_date")
    public String estreia;
}
