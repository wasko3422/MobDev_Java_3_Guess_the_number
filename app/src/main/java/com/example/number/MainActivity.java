package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand;
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button ExitButton;
    Button ModeButton;
    int randomNumber;
    Boolean hardMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

        rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        //tvInfo.setText(randomNumber);

        ExitButton = findViewById(R.id.ExitButton);

        ExitButton.setOnClickListener(new View.OnClickListener() {  //хз чё тут с форматированием атас полный
                                          @Override
                                          public void onClick(View v) {
                                              finish();
                                              System.exit(0);
                                          }
                                      }

        );

        ModeButton = findViewById(R.id.mode);

        ModeButton.setOnClickListener(new View.OnClickListener() {  //same story
                                          @Override
                                          public void onClick(View v) {
                                              if(!hardMode){
                                                  randomNumber = rand.nextInt(10000000) + 1;
                                                  hardMode = true;
                                                  ModeButton.setText("Easy mode");
                                                  tvInfo.setText("Теперь хард моуд - угадать от 1 до 10000000");
                                              }else{
                                                  randomNumber = rand.nextInt(100) + 1;
                                                  hardMode = false;
                                                  ModeButton.setText("Hard mode");
                                                  tvInfo.setText("Обратно в легкий режим - от 1 до 100");
                                              }
                                          }
                                      }

        );



    }

    public void onClick(View view) {
        String buff = etInput.getText().toString();
        if (buff.length() == 0){  //если введено ничего
            tvInfo.setText("Введите число!!!!!");
            return;
        }
        int value = Integer.parseInt(etInput.getText().toString());

        if(!hardMode) {
            if (value < 0 || value > 100) {
                tvInfo.setText("Число находится вне диапазона!!!!!");
                return;
            }
        }else{
            if (value < 0 || value > 10000000) {
                tvInfo.setText("Число находится вне диапазона!!!!!");
                return;
            }
        }

        if (value == randomNumber){
            tvInfo.setText(String.format("Попал число - %d", randomNumber));
        }else {
            tvInfo.setText(getResources().getString(R.string.ahead) + randomNumber);  //для проверки
        }
    }
}

