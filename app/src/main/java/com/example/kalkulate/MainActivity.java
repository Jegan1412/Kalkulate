package com.example.kalkulate;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    double firstNum, secondNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Numbers
        Button num0 = findViewById(R.id.num0);
        Button num00 = findViewById(R.id.num00);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        //Symbols
        Button modulus = findViewById(R.id.modulus);
        Button square_root = findViewById(R.id.square_root);
        Button power = findViewById(R.id.power);
        Button equals = findViewById(R.id.equals);
        Button average= findViewById(R.id.Average);
        Button factorial = findViewById(R.id.factorial);
        Button klear = findViewById(R.id.klear);
        Button backspace = findViewById(R.id.backspace);
        Button sum = findViewById(R.id.sum);
        Button difference = findViewById(R.id.difference);
        Button product = findViewById(R.id.product);
        Button division = findViewById(R.id.division);
        Button dot = findViewById(R.id.dot);

        TextView screen = findViewById(R.id.screen);

        klear.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });

        //off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        //on.setOnClickListener(view -> {
        //    screen.setVisibility(View.VISIBLE);
        //    screen.setText("0");
        //});

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num00);
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums){
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operations = new ArrayList<>();
        operations.add(modulus);
        operations.add(square_root);
        operations.add(power);
        operations.add(equals);
        operations.add(average);
        operations.add(factorial);
        operations.add(klear);
        operations.add(backspace);
        operations.add(sum);
        operations.add(difference);
        operations.add(product);
        operations.add(division);
        operations.add(dot);

        for (Button b : operations) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        backspace.setOnClickListener(view -> {
           String num = screen.getText().toString();
           if (num.length() > 1){
               screen.setText(num.substring(0, num.length()-1));
           }
           else if (num.length() == 1 && !num.equals("0")){
               screen.setText("0");
           }
        });

        dot.setOnClickListener(view -> {
           if (!screen.getText().toString().contains(".")){
               screen.setText(screen.getText().toString() + ".");
           }
        });

        equals.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch(operation){
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "%":
                    result = firstNum % secondNum;
                    break;
                case "^":
                    result = Math.pow(firstNum, secondNum);
                    break;
                case "√":
                    result = Math.sqrt(secondNum);
                    break;
                case "AVG":
                    result = (firstNum + secondNum) / 2;
                    break;
                case "!":
                    int factorial_value = 1;
                    if (firstNum == 0){
                        result = factorial_value;
                    }else {
                        for (int i = 1; i <= firstNum; i++) {
                            factorial_value =  factorial_value * i;
                        }
                        result = factorial_value;
                    }
                    break;
                default:
                    result = firstNum + secondNum;
                    break;

            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });

    }
}