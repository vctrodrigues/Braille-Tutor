package br.edu.ifrn.projetobraile.apresentacao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.projetobraile.R;
import br.edu.ifrn.projetobraile.apresentacao.extras.GridAdapter;
import br.edu.ifrn.projetobraile.apresentacao.extras.MyImageButton;
import br.edu.ifrn.projetobraile.dominio.App;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private GridView gridView;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        gridView = (GridView)findViewById(R.id.main_gridview);

        List<View> list = new ArrayList<>();
        list.add(new MyImageButton(this));
        list.add(new MyImageButton(this));
        list.add(new MyImageButton(this));
        list.add(new MyImageButton(this));
        list.add(new MyImageButton(this));
        list.add(new MyImageButton(this));
        
        gridView.setAdapter(new GridAdapter(this, list));
    }




}
