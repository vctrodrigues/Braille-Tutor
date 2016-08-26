package br.edu.ifrn.projetobraile.apresentacao.activity;

import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import br.edu.ifrn.projetobraile.R;
import br.edu.ifrn.projetobraile.dominio.App;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageButton btn_1;
    private ImageButton btn_2;
    private ImageButton btn_3;
    private ImageButton btn_4;
    private ImageButton btn_5;
    private ImageButton btn_6;

    private View.OnClickListener onClickListener;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        btn_1 = (ImageButton) findViewById(R.id.btn_1);
        btn_2 = (ImageButton) findViewById(R.id.btn_2);
        btn_3 = (ImageButton) findViewById(R.id.btn_3);
        btn_4 = (ImageButton) findViewById(R.id.btn_4);
        btn_5 = (ImageButton) findViewById(R.id.btn_5);
        btn_6 = (ImageButton) findViewById(R.id.btn_6);
    }

    private void setupListeners() {
        btn_1.setOnClickListener(onClickListener);
        btn_2.setOnClickListener(onClickListener);
        btn_3.setOnClickListener(onClickListener);
        btn_4.setOnClickListener(onClickListener);
        btn_5.setOnClickListener(onClickListener);
        btn_6.setOnClickListener(onClickListener);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.btn_1:
                        app.addBraille("1");
                        break;
                    case R.id.btn_2:
                        app.addBraille("2");
                        break;
                    case R.id.btn_3:
                        app.addBraille("3");
                        break;
                    case R.id.btn_4:
                        app.addBraille("4");
                        break;
                    case R.id.btn_5:
                        app.addBraille("5");
                        break;
                    case R.id.btn_6:
                        app.addBraille("6");
                        break;
                    default:
                        //show error message
                        break;
                }
            }
        };
    }


}
