package com.example.calculadorasimple;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton zero, one , two, three, four, five, six, seven, eight, nine;
    MaterialButton plus,less, mult, div, mod, clearChar, clear, point,ac, equal;
    TextView result, action;
    String r, a, proceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton();
        actionOnclickAdd();
    }

    private void actionOnclickAdd() {
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        point.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        less.setOnClickListener(this);
        plus.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        mod.setOnClickListener(this);
        clearChar.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    private void loadButton(){
        zero = findViewById(R.id.id_zero);
        one = findViewById(R.id.id_one);
        two = findViewById(R.id.id_two);
        three = findViewById(R.id.id_three);
        four = findViewById(R.id.id_four);
        five = findViewById(R.id.id_five);
        six = findViewById(R.id.id_six);
        seven = findViewById(R.id.id_seven);
        eight = findViewById(R.id.id_eight);
        nine = findViewById(R.id.id_nine);
        plus = findViewById(R.id.id_plus);
        less = findViewById(R.id.id_less);
        mult = findViewById(R.id.id_mult);
        div = findViewById(R.id.id_div);
        mod = findViewById(R.id.id_mod);
        clearChar = findViewById(R.id.id_clearChar);
        clear = findViewById(R.id.id_clear);
        point = findViewById(R.id.id_point);
        ac = findViewById(R.id.id_ac);
        equal = findViewById(R.id.id_equal);
        result = findViewById(R.id.id_text_result);
        action = findViewById(R.id.id_text_operation);
    }

    @Override
    public void onClick(View view) {
        a = action.getText() + "";
        switch (view.getId()){
            case R.id.id_zero:
                a = a + "0";
                action.setText(a);
                break;
            case R.id.id_one:
                a = a + "1";
                action.setText(a);
                break;
            case R.id.id_two:
                a = a + "2";
                action.setText(a);
                break;
            case R.id.id_three:
                a = a + "3";
                action.setText(a);
                break;
            case R.id.id_four:
                a = a + "4";
                action.setText(a);
                break;
            case R.id.id_five:
                a = a + "5";
                action.setText(a);
                break;
            case R.id.id_six:
                a = a + "6";
                action.setText(a);
                break;
            case R.id.id_seven:
                a = a + "7";
                action.setText(a);
                break;
            case R.id.id_eight:
                a = a + "8";
                action.setText(a);
                break;
            case R.id.id_nine:
                a = a + "9";
                action.setText(a);
                break;
            case R.id.id_point:
                a = a + ".";
                action.setText(a);
                break;
            case R.id.id_less:
                a = a + "-";
                action.setText(a);
                break;
            case R.id.id_plus:
                a = a + "+";
                action.setText(a);
                break;
            case R.id.id_mult:
                a = a + "*";
                action.setText(a);
                break;
            case R.id.id_div:
                a = a + "/";
                action.setText(a);
                break;
            case R.id.id_mod:
                a = a + "%";
                action.setText(a);
                break;
            case R.id.id_clear:
                a = "";
                result.setText("");
                action.setText(a);
                break;
            case R.id.id_clearChar:
                clearChar();
                break;
            case R.id.id_equal:
                resultOperation();
                break;
        }
    }

    private void clearChar() {
        int l = (a.length());
        if(l > 0){
            a = a.substring(0, l-1);
            action.setText(a);
        }
    }

    private void resultOperation() {
        if(!a.isEmpty() || a.length() > 1){
            proceso = this.a.toString();
            proceso = proceso.replaceAll("x", "*");
            proceso = proceso.replaceAll("%","/100");
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            String finalResut = "";
            try {
                Scriptable scriptable = context.initStandardObjects();
                finalResut = context.evaluateString(scriptable,
                        proceso, "javascript",
                        1, null).toString();
            }catch (Exception e){
                finalResut = "0";
                Toast.makeText(this, "Error, la entrada no es la adecuada", Toast.LENGTH_SHORT).show();
            }
            result.setText(finalResut);
        }
    }
}