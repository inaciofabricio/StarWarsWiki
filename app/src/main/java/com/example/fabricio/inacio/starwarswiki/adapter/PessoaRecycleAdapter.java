package com.example.fabricio.inacio.starwarswiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabricio.inacio.starwarswiki.R;
import com.example.fabricio.inacio.starwarswiki.model.Pessoa;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;

public class PessoaRecycleAdapter extends RecyclerView.Adapter<PessoaRecycleAdapter.VH>{

    List<Pessoa> pessoas;
    OnPessoaClickListener listener;

    public PessoaRecycleAdapter(List<Pessoa> pessoas, OnPessoaClickListener listener) {
        this.pessoas = pessoas;
        this.listener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pessoa, parent, false);

        final VH vh = new VH(v);
        vh.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            int pos = vh.getAdapterPosition();
                            Pessoa pessoa = pessoas.get(pos);
                            listener.onPessoaClick(pessoa);
                        }
                    }
                });
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int pos) {
        Pessoa pessoa = pessoas.get(pos);
        holder.txtNome.setText(pessoa.nome);
        holder.txtPeso.setText(pessoa.peso);
        holder.txtAltura.setText(pessoa.altura);
        holder.txtGenero.setText(pessoa.genero);

    }

    @Override
    public int getItemCount() {
        return pessoas != null ? pessoas.size() : 0;
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_nome_pessoa)
        public TextView txtNome;
        @BindView(R.id.txt_peso_pessoa)
        public TextView txtPeso;
        @BindView(R.id.txt_altura_pessoa)
        public TextView txtAltura;
        @BindView(R.id.txt_genero_pessoa)
        public TextView txtGenero;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnPessoaClickListener {
        void onPessoaClick(Pessoa pessoa);
    }
}
