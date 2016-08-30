package br.edu.ifrn.projetobraile.apresentacao.extras;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.projetobraile.MySingleton;
import br.edu.ifrn.projetobraile.R;

public class GridAdapter extends BaseAdapter {

    private List<View> mViews = new ArrayList<>();
    private LayoutInflater mInflater;

    private Context context;

    public GridAdapter(Context context, List<View> mViews) {

        mInflater = LayoutInflater.from(context);
        this.mViews = mViews;
        this.context = context;

    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public View getItem(int i) {
        return mViews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return R.drawable.bg_btn;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        final MyImageButton myImageButton;

        if (v == null) {
            v = mInflater.inflate(R.layout.main_grid_items, viewGroup, false);
            v.setTag(R.id.btn, v.findViewById(R.id.btn));
        }

        View item = getItem(i);

        myImageButton = (MyImageButton) v.getTag(R.id.btn);
        myImageButton.setBackground(context.getResources().getDrawable(R.drawable.bg_btn));

        myImageButton.setPosRef(i);

        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySingleton.getApp().addBraille(""+myImageButton.getPosRef());
            }
        });

        return v;
    }
}
