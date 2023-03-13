package com.soern.androidcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//SEVKETCAN KALYONCUOGLU


public class MainActivity extends AppCompatActivity {
    Button bb1,bb2,bac,bc,bsin,bcos,btan,blog,bln,bfact,bsquare,bsqrt,binv,bdiv,bmul,bminus,bplus,bequ,bnine,beight,bseven,bsix,bfive,bfour,bthree,btwo,bone,bzero,bdot;
    TextView tvmain,tvsec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bb1=findViewById(R.id.bb1);
        bb2=findViewById(R.id.bb2);
        bac=findViewById(R.id.bac);
        bc=findViewById(R.id.bc);
        bsin=findViewById(R.id.bsin);
        bcos=findViewById(R.id.bcos);
        btan=findViewById(R.id.btan);
        blog=findViewById(R.id.blog);
        bfact=findViewById(R.id.bfact);
        bln=findViewById(R.id.bln);
        bsquare=findViewById(R.id.bsquare);
        bsqrt=findViewById(R.id.bsqrt);
        binv=findViewById(R.id.binv);
        bdiv=findViewById(R.id.bdiv);
        bmul=findViewById(R.id.bmul);
        bminus=findViewById(R.id.bminus);
        bplus=findViewById(R.id.bplus);
        bequ=findViewById(R.id.bequ);
        bnine=findViewById(R.id.bnine);
        beight=findViewById(R.id.beight);
        bseven=findViewById(R.id.bseven);
        bsix=findViewById(R.id.bsix);
        bfive=findViewById(R.id.bfive);
        bfour=findViewById(R.id.bfour);
        bthree=findViewById(R.id.bthree);
        btwo=findViewById(R.id.btwo);
        bone=findViewById(R.id.bone);
        bzero=findViewById(R.id.bzero);
        bdot=findViewById(R.id.bdot);

        tvmain = findViewById(R.id.tvmain);
        tvsec = findViewById(R.id.tvsec);


        //ONCLICK
        bb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"(");
            }
        });
        bb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+")");
            }
        });
        bac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText("");
                tvsec.setText("");
            }
        });
        bc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String val = tvmain.getText().toString();
                if (!val.isEmpty()){
                    val = val.substring(0,val.length()-1);
                    tvmain.setText(val);
                }
            }
        });

        bsin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText("sin"+tvmain.getText());
            }
        });
        bcos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText("cos"+tvmain.getText());
            }
        });
        btan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText("tan"+tvmain.getText());
            }
        });
        blog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvmain.setText("log"+tvmain.getText());
            }
        });
        bln.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText("ln"+tvmain.getText());
            }
        });
        bfact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    int val = Integer.parseInt(tvmain.getText().toString());
                    int fact = factorial(val);
                    tvmain.setText(String.valueOf(fact));
                    tvsec.setText(val+"!");
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bsquare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    double d = Double.parseDouble((tvmain.getText().toString()));
                    double square = d*d;
                    tvmain.setText(String.valueOf(square));
                    tvsec.setText(d+"²");
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    String val = tvmain.getText().toString();
                    double r = Math.sqrt(Double.parseDouble(val));
                    tvmain.setText(String.valueOf(r));
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+"^"+"(-1)");
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"÷");
            }
        });
        bmul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"×");
            }
        });
        bminus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"-");
            }
        });
        bplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"+");
            }
        });

        bequ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String val = tvmain.getText().toString();
                char oldChar;
                String replacedstr = val.replace('÷','/').replace('×','*');
                try {
                    double result = eval(replacedstr);
                    tvmain.setText(String.valueOf(result));
                    tvsec.setText(val);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bnine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"9");
            }
        });
        beight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"8");
            }
        });
        bseven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"7");
            }
        });
        bsix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"6");
            }
        });
        bfive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"5");
            }
        });
        bfour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"4");
            }
        });
        bthree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"3");
            }
        });
        btwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"2");
            }
        });
        bone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"1");
            }
        });
        bzero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+"0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmain.setText(tvmain.getText()+",");
            }
        });




    }

    //factorial function
    int factorial(int n)
    {
        return ((n == 1) || (n == 0)) ? 1 : (n * factorial(n - 1));
    }

    //eval function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (x < Math.pow(10,-10)){
                    x=0;
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}