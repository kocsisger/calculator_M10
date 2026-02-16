package hu.unideb.inf.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void handleButtonPress(View view) {
        Button button = (Button)view;
        switch (button.getText().toString()){
            case "CE": resultTextView.setText("0"); break;
            case "=" : resultTextView.setText(
                           calculate(resultTextView.getText().toString())
                       ); break;
            default : resultTextView.append(button.getText());
        }
    }

    private String calculate(String expression) {
        String op1_str = expression.split("[+-/*]")[0];
        int op1 = Integer.parseInt(op1_str);
        int op2 = Integer.parseInt(expression.split("[+-/*]")[1]);

        char operator = expression.charAt(op1_str.length());

         Log.d("TEST_OP", "Operands: " + op1 + " "  + operator + " " + op2);

         return "-";
    }
}