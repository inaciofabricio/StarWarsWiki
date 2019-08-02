package com.example.fabricio.inacio.starwarswiki.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.fabricio.inacio.starwarswiki.R;
import com.example.fabricio.inacio.starwarswiki.fragments.AeronavesFragment;
import com.example.fabricio.inacio.starwarswiki.fragments.EspeciesFragment;
import com.example.fabricio.inacio.starwarswiki.fragments.FilmesFragment;
import com.example.fabricio.inacio.starwarswiki.fragments.PessoasFragment;
import com.example.fabricio.inacio.starwarswiki.fragments.PlanetasFragment;
import com.example.fabricio.inacio.starwarswiki.fragments.VeiculosFragment;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private int[] icones = new int[]{
            R.drawable.ic_personagem,
            R.drawable.ic_especie,
            R.drawable.ic_filme,
            R.drawable.ic_veiculo,
            R.drawable.ic_espaconave,
            R.drawable.ic_planeta};
    private int tamanhoIcone;

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
        double escala = this.context.getResources().getDisplayMetrics().density;
        tamanhoIcone = (int)(36 * escala);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position){

            case 0:
                fragment = new PessoasFragment();
            break;
            case 1:
                fragment = new EspeciesFragment();
                break;
            case 2:
                fragment = new FilmesFragment();
                break;
            case 3:
                fragment = new VeiculosFragment();
                break;
            case 4:
                fragment = new AeronavesFragment();
                break;
            case 5:
                fragment = new PlanetasFragment();
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        //Recupera o icone de acordo com a posição
        Drawable drawable = ContextCompat.getDrawable(this.context, icones[position]);
        drawable.setBounds(0,0,tamanhoIcone,tamanhoIcone);

        //Permite colocar uma imagem dentro de um texto
        ImageSpan imageSpan = new ImageSpan(drawable);

        //Classe utilizada para retornar CharSequence
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    @Override
    public int getCount() {

        return icones.length;
    }
}
