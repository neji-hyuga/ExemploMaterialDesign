package br.com.appcaminhao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView percentual;
    private SeekBar seekBar;
    private Button buttonPercentual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentual = findViewById(R.id.percentualSeek);


        seekBar = findViewById(R.id.seekBarId);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentual.setText(progress+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonPercentual = findViewById(R.id.btn_percentual);
        buttonPercentual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCaminhao();
            }
        });
    }

    private void irParaCaminhao() {
        Intent intent = new Intent(this, CaminhaoActivity.class);
        Bundle bundle = new Bundle();
        Quiz quiz = new Quiz();

        quiz.setPercentual(seekBar.getProgress());

        //chave sempre identica, se não não acha
        bundle.putSerializable("QUIZ", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }


}
