package com.example.alexandergf.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    //Camps (fields) o atributs.
    private PreguntaTest pregunta;//Aixo es el MODEL.
    private RadioGroup respostesview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String[] respostes = new String[4];
        respostes[0] = "Barcelona";
        respostes[1] = "Paris";
        respostes[2] = "Londres";
        respostes[3] = "Hanoi";

        pregunta = new PreguntaTest(
            "Quina es la capital de Vietnam?", respostes,3
        );

        //copiem dades desde el model a la vista.
        TextView textview = findViewById(R.id.textview);
        textview.setText(pregunta.getText());
        RadioButton btn_r0 = findViewById(R.id.btn_r0);
        btn_r0.setText(pregunta.getRespostes()[0]);
        RadioButton btn_r1 = findViewById(R.id.btn_r1);
        btn_r1.setText(pregunta.getRespostes()[1]);
        RadioButton btn_r2 = findViewById(R.id.btn_r2);
        btn_r2.setText(pregunta.getRespostes()[2]);
        RadioButton btn_r3 = findViewById(R.id.btn_r3);
        btn_r3.setText(pregunta.getRespostes()[3]);

        respostesview = findViewById(R.id.respostesview);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Omplir menu a partir de la descripcio del recurs quiz_menu.xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_comproba:
               comprovaResposta();
                break;
        }
        return true;
    }

    private void comprovaResposta() {
        int selected = respostesview.getCheckedRadioButtonId();
        int ids[] = {R.id.btn_r0, R.id.btn_r1, R.id.btn_r2, R.id.btn_r3};
        int index = -1;
        for(int i=0; i<4;i++){
            if (selected == ids[i]){
                index = i;
            }
        }
        if (index==pregunta.getCorrecte()){
            Toast.makeText(this, "Molt bé!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Torna a provar...", Toast.LENGTH_SHORT).show();
        }
    }
}
