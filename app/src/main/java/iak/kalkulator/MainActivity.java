package iak.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etResult;
    private double firstNumber = 0;
    boolean flagAdd, flagSubtract, flagMultiply, flagDivide, flagNew = true, flagFirstNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etResult = (EditText) findViewById(R.id.et_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void addToEditText(String adder) {
        if (flagNew) {
            etResult.setText(adder);
            flagNew = false;
        } else {
            String result = etResult.getText() + adder;
            etResult.setText(removeLeadingZeros(result));
        }
    }

    public void addNumber1(View view) {
        addToEditText("1");
    }

    public void addNumber2(View view) {
        addToEditText("2");
    }

    public void addNumber3(View view) {
        addToEditText("3");
    }

    public void addNumber4(View view) {
        addToEditText("4");
    }

    public void addNumber5(View view) {
        addToEditText("5");
    }

    public void addNumber6(View view) {
        addToEditText("6");
    }

    public void addNumber7(View view) {
        addToEditText("7");
    }

    public void addNumber8(View view) {
        addToEditText("8");
    }

    public void addNumber9(View view) {
        addToEditText("9");
    }

    public void addNumber0(View view) {
        addToEditText("0");
    }

    public void addDot(View view) {
        addToEditText(".");
    }

    public void showResult(View view) {
        double secondNumber = Double.parseDouble(etResult.getText().toString());
        if (flagAdd) {
            firstNumber += secondNumber;
        }
        if (flagSubtract) {
            firstNumber -= secondNumber;
        }
        if (flagMultiply) {
            firstNumber *= secondNumber;
        }
        if (flagDivide) {
            firstNumber /= secondNumber;
        }
        etResult.setText(formatResult(firstNumber));
        flagNew = true;
    }

    public void doAdd(View view) {
        flagAdd = true;
        if (flagFirstNumber) {
            firstNumber = Double.parseDouble(etResult.getText().toString());
            flagFirstNumber = false;
        } else {
            double secondNumber = Double.parseDouble(etResult.getText().toString());
            firstNumber += secondNumber;
            etResult.setText(formatResult(firstNumber));
        }
        flagNew = true;
    }

    public void doSubstract(View view) {
        flagSubtract = true;
        if (flagFirstNumber) {
            firstNumber = Double.parseDouble(etResult.getText().toString());
            flagFirstNumber = false;
        } else {
            double secondNumber = Double.parseDouble(etResult.getText().toString());
            firstNumber -= secondNumber;
            etResult.setText(formatResult(firstNumber));
        }
        flagNew = true;
    }

    public void doMultiply(View view) {
        flagMultiply = true;
        if (flagNew) {
            firstNumber = Double.parseDouble(etResult.getText().toString());
            flagFirstNumber = false;
        } else {
            double secondNumber = Double.parseDouble(etResult.getText().toString());
            firstNumber *= secondNumber;
            etResult.setText(formatResult(firstNumber));
        }
        flagNew = true;
    }

    public void doDivide(View view) {
        flagDivide = true;
        if (flagNew) {
            firstNumber = Double.parseDouble(etResult.getText().toString());
            flagFirstNumber = false;
        } else {
            double secondNumber = Double.parseDouble(etResult.getText().toString());
            firstNumber /= secondNumber;
            etResult.setText(formatResult(firstNumber));
        }
        flagNew = true;
    }

    public void switchPositiveNegative(View view) {
    }

    public void doPercent(View view) {
    }

    public void doC(View view) {
//        secondNumber = 0;
        etResult.setText("0");
    }

    public void doAC(View view) {
        firstNumber = 0;
        flagFirstNumber = true;
        flagNew = true;
        etResult.setText("0");
    }

    /**
     * format result with 2 numbers after dot
     * or the original result without dot if the result ends with .00
     *
     * @param number to format
     * @return a formatted number
     */
    private String formatResult(double number) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        String returnString = formatter.format(number);
        return returnString.endsWith(".00") ? returnString.split("\\.")[0] : returnString;
    }

    private String removeLeadingZeros(String input) {
        return input.replaceFirst("^0+(?!$)", "");
    }
}
