package com.example.fabricio.inacio.starwarswiki.http;


import com.example.fabricio.inacio.starwarswiki.model.Pessoa;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PessoaSearchResult {

    @SerializedName("result")
    List<Pessoa> pessoas;
}
