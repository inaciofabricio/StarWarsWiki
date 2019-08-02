package com.example.fabricio.inacio.starwarswiki.http;


import android.util.Log;

import com.example.fabricio.inacio.starwarswiki.model.Pessoa;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PessoaParser{

    public static List<Pessoa>  searchPessoas() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();

        String url = String.format("http://swapi.co/api/people/?page=1");
        Log.i("Teste","Teste");
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        PessoaSearchResult result = gson.fromJson(json, PessoaSearchResult.class);

        return result.pessoas;
    }

}
