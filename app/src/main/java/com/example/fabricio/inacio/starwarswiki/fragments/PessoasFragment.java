package com.example.fabricio.inacio.starwarswiki.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabricio.inacio.starwarswiki.R;
import com.example.fabricio.inacio.starwarswiki.adapter.PessoaRecycleAdapter;
import com.example.fabricio.inacio.starwarswiki.http.PessoaParser;
import com.example.fabricio.inacio.starwarswiki.model.Pessoa;

import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PessoasFragment extends Fragment implements SearchView.OnQueryTextListener{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.txt_empty_pessoa)
    TextView txtEmpty;

    List<Pessoa> pessoas;

    public PessoasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pessoas, container, false);
        ButterKnife.bind(this, view);

        if (pessoas != null) {
            updateList();
        }
        return view;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        new PessoaSearchTask().execute(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    class PessoaSearchTask extends AsyncTask<String, Void, List<Pessoa>> {

        @Override
        protected List<Pessoa> doInBackground(String... params) {
            try {
                return PessoaParser.searchPessoas();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Pessoa> m) {
            super.onPostExecute(m);
            pessoas = m;
            boolean isEmpty = pessoas == null || pessoas.size() <= 0;
            txtEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
            updateList();
        }
    }

    private void updateList() {
        PessoaRecycleAdapter adapter = new PessoaRecycleAdapter(pessoas, new PessoaRecycleAdapter.OnPessoaClickListener() {
            @Override
            public void onPessoaClick(Pessoa pessoa) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

}
