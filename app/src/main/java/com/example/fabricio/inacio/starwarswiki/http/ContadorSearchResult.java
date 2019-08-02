package com.example.fabricio.inacio.starwarswiki.http;


import com.example.fabricio.inacio.starwarswiki.model.Contador;
import com.google.gson.annotations.SerializedName;

public class ContadorSearchResult {

    @SerializedName("count")
    Contador contador;
}
