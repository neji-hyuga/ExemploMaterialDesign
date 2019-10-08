package br.com.appcaminhao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class CaminhaoActivity extends AppCompatActivity {

    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caminhao);

        //recupera bundle da tela anterior
        Bundle bundle = getIntent().getExtras();

        //(a chave tem q ser exatamente a mesma, se não não acha) cast pelo filtro, nem td serializable é um quiz por exemplo
        quiz = (Quiz)bundle.getSerializable("QUIZ");

        Button buttonCaminhao = findViewById(R.id.btn_caminhao);
        buttonCaminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCores();
            }
        });
    }

    private void irParaCores() {
        Intent intent = new Intent(this, CoresActivity.class );

        Bundle bundle = new Bundle();

        RadioButton rbCarreto = findViewById(R.id.radio_carreto);
        RadioButton rbCegonha = findViewById(R.id.radio_cegonha);
        RadioButton rbLixo = findViewById(R.id.radio_lixo);
        RadioButton rbFrigorifico = findViewById(R.id.radio_frigo);

        if (rbCarreto.isChecked()){
            quiz.setCaminhao("carreto");
        } else if(rbCegonha.isChecked()){
            quiz.setCaminhao("cegonha");
        }else if(rbFrigorifico.isChecked()){
            quiz.setCaminhao("frigorifico");
        }else if(rbLixo.isChecked()){
            quiz.setCaminhao("lixo");
        }

        bundle.putSerializable("Quiz", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
