package com.example.dell.calculatorforprogmmers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    TextView v1;
    int base;
    int newbase;
    String num;
    String newNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /*num = e1.getText().toString();
        base=Integer.parseInt(e2.getText()+"");
        newbase=Integer.parseInt(e3.getText()+"");*/

        v1=(TextView)findViewById(R.id.textView);


    }

  public void bt_1(View v) {
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
      num = e1.getText().toString();
      base=Integer.parseInt(e2.getText()+"");
      newbase=Integer.parseInt(e3.getText()+"");

       ValidateBase(base);
            ValidateNumInBase(num, base);
            newNumber = NewConvertBase(num, base, newbase);
            v1.setText(newNumber);


    }
        private  void ValidateBase (int base) {
            if (base < 2 || base > 36)
                Toast.makeText(getApplicationContext(), "check base", Toast.LENGTH_SHORT).show();
            System.exit(1);
        }




    private void ValidateNumInBase(String number, int base) {
        char digit;
       // String G
        for (int i = 0; i < number.length(); i++) {
            digit = number.toUpperCase().charAt(i);
            if (Character.isDigit(digit) && (digit-'0' ) >= base) {
                System.exit(1);
                //Toast.makeText(getApplicationContext(), "check base", Toast.LENGTH_SHORT).show();
             //   System.exit(1);
            } else if (Character.isLetter(digit) && (digit - 'A') + 10 >= base) {
             // Toast.makeText(getApplicationContext(), "check base", Toast.LENGTH_SHORT).show();
               System.exit(1);
                //v1.setText("check base");
            } else if (!Character.isDigit(digit) && !Character.isLetter(digit)) {
                //Toast.makeText(getApplicationContext(), "check your number", Toast.LENGTH_SHORT).show();
                //v1.setText("uncorrected number");
              System.exit(1);
            }

        }

    }

    private String NewConvertBase(String number, int base, int newbase) {
        double v = 0;
        double dec = 0;
        char d;
        int l = number.length();
        for (int i = 0; i < l; i++) {
            d = Character.toUpperCase(number.charAt(l - 1 - i));
            if (Character.isLetter(d)) {
                dec = d - 'A' + 10;
            } else if (Character.isDigit(d)) {
                dec = d-'0' ;
            } else {
               // v1.setText("");
                //Toast.makeText(this, "uncorrected digit", Toast.LENGTH_SHORT).show();
                //v1.setText("uncorrected number");
                System.exit(1);
            }
            v += dec * Math.pow(base, i);


        }
        char s;
        int a=1;
        for ( ; Math.pow(newbase, a) <= v; a++) {
        }
        char[] newnumber = new char[a];
        double p;
        for (int i = a - 1; i >= 0; i--) {
            p = Math.pow(newbase, i);
            dec = Math.floor(v / p);
            v -= dec * p;
            if (dec <= 9) {
                newnumber[a - 1 - i] = (char) ('0' + (int) dec);
            } else {
               newnumber[a - 1 - i] = (char) ('A' + (int) dec -10);

            }
        }

        return new String(newnumber);

    }
    public void bt_2(View v)
    {

        v1.setText("");
        e1.setText("");
        e2.setText("");
        e3.setText("");
    }

}