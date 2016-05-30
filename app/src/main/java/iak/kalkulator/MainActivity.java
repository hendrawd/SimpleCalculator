package iak.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etResult;
    private double firstNumber = 0;
    private double secondNumber = 0;
    boolean number1Available = false;
    boolean number2Available = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etResult = (EditText) findViewById(R.id.et_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addToEditText(String adder) {
        Log.v("test", etResult.getText().toString());
        if (etResult.getText().toString().equals("0")) {
            etResult.setText(adder);
        } else {
            etResult.setText(etResult.getText() + adder);
        }
    }

    public void number1(View view) {
        addToEditText("1");
    }

    public void number2(View view) {
        addToEditText("2");
    }

    public void number3(View view) {
        addToEditText("3");
    }

    public void number4(View view) {
        addToEditText("4");
    }

    public void number5(View view) {
        addToEditText("5");
    }

    public void number6(View view) {
        addToEditText("6");
    }

    public void number7(View view) {
        addToEditText("7");
    }

    public void number8(View view) {
        addToEditText("8");
    }

    public void number9(View view) {
        addToEditText("9");
    }

    public void number0(View view) {
        addToEditText("0");
    }

    public void addDot(View view) {
        addToEditText(".");
    }

    public void result(View view) {
    }


    public void operationTambah(View view) {
        if (lastNumber == 0) {
            lastNumber = Double.parseDouble(etResult.getText().toString());
            etResult.setText("0");
        } else {
            if (currentNumber == 0) {
                currentNumber = Double.parseDouble(etResult.getText().toString());
            }
        }

        double result = lastNumber + currentNumber;
        etResult.setText(result + "");
    }

    public void operationKurang(View view) {
    }

    public void operationKali(View view) {
    }

    public void operationBagi(View view) {
    }

    public void clear(View view) {
        lastNumber = 0;
        currentNumber = 0;
        etResult.setText("0");
    }

    /**
     * format result with 2 numbers after dot
     * @param number to format
     * @return a formatted number
     */
    private String formatResult(double number) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(number);
    }
}
