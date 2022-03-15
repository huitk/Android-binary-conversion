package edu.gmu.lab1_tkarawap;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Output;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView result_binary;
    private TextView result_octal;
    private TextView result_decimal;
    private TextView result_hex;

    private EditText etUnits;
    private Button btnClear;
    private Button btnConvert;
    private RadioButton radio_binary;
    private RadioButton radio_octal;
    private RadioButton radio_decimal;
    private RadioButton radio_hex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //result_binary = (TextView) findViewById(R.id.result_binary);
        etUnits = (EditText) findViewById(R.id.units);
        btnClear = (Button) findViewById(R.id.clear_text);
        btnConvert = (Button) findViewById(R.id.convert);
        radio_binary = (RadioButton) findViewById(R.id.radio_binary);
        radio_octal = (RadioButton) findViewById(R.id.radio_octal);
        radio_decimal = (RadioButton) findViewById(R.id.radio_decimal);
        radio_hex = (RadioButton) findViewById(R.id.radio_hex);

        etUnits.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnConvert.setOnClickListener(this);
        radio_binary.setOnClickListener(this);
        etUnits.setOnClickListener(this);
        radio_decimal.setOnClickListener(this);
        radio_hex.setOnClickListener(this);
        radio_octal.setOnClickListener(this);

        AdapterView.OnClickListener ocl;
        ocl = new AdapterView.OnClickListener() {
            public void onClick(View v) {
                etUnits.setText("");
            }

        };
        btnClear.setOnClickListener(ocl);
        btnClear.setEnabled(true);


    }

    @Override
    public void onClick(View v) {
        String binaryToOct;
        int binaryToDec;
        String binaryToHex;
        TextView outputTextView = (TextView) findViewById(R.id.output_textView);


        if (v.getId() == R.id.convert) {

            if (radio_binary.isChecked()) {
                String text = etUnits.getText().toString();

                try {
                    binaryToDec = Integer.parseInt(text, 2);
                    binaryToOct = Integer.toOctalString(binaryToDec);
                    binaryToHex = Integer.toString(binaryToDec, 16);
                    outputTextView.setText("Binary is: "+ text +"\n\n" +
                            "Binary to octal is: "+ binaryToOct +"\n\n"+
                            "Binary to decimal is: "+ binaryToDec + "\n\n"+
                            "Binary to hex is: " + binaryToHex + "\n\n");


                    /*
                    Toast.makeText(this, "Binary is: " + text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Binary to Octal: " + binaryToOct, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Binary to Decimal: " + binaryToDec, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Binary to Hex: " + binaryToHex, Toast.LENGTH_SHORT).show();
                    */

                } catch (Exception e) {
                    Toast.makeText(this, "Binary number need to be only 0 or 1. Please try again: ", Toast.LENGTH_LONG).show();
                    etUnits.setText("");
                }

            } else if (radio_octal.isChecked()) {
                String text = etUnits.getText().toString();
                try {
                    int parseTextToInt = Integer.parseInt(text);
                    int octToDec = Integer.parseInt(text, 8);
                    String octToHex = Integer.toHexString(octToDec);
                    String octToBinary = Integer.toBinaryString(octToDec);

                    outputTextView.setText("octal is: "+ text +"\n\n" +
                            "Octal to binary is: "+ octToBinary +"\n\n"+
                            "octal to Decimal is: "+ octToDec + "\n\n"+
                            "Octal to Hex is: " + octToHex + "\n\n");

                    /*
                    Toast.makeText(this, "Octal : " + text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Octal to binary : " + octToBinary, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Octal to Decimal: " + octToDec, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Octal to Hex: " + octToHex, Toast.LENGTH_SHORT).show();

                     */
                } catch (Exception e) {
                    Toast.makeText(this, "Octal number can be only 0-7. Please try again.", Toast.LENGTH_LONG).show();
                    etUnits.setText("");
                }
            } else if (radio_decimal.isChecked()) {

                String text = etUnits.getText().toString();

                try {
                    String decToBinary = Integer.toString(Integer.parseInt(text), 2);
                    String decToOct = Integer.toString(Integer.parseInt(text), 8);
                    String decToHex = Integer.toString(Integer.parseInt(text), 16);

                    outputTextView.setText("Decimal is: "+ text +"\n\n" +
                            "Decimal to binary is: "+ decToBinary +"\n\n"+
                            "Decimal to  octal is: "+ decToOct + "\n\n"+
                            "Decimal to hex is: " + decToHex + "\n\n");

                    /*
                    Toast.makeText(this, "Decimal : " + text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Decimal to binary: " + decToBinary, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Decimal to octal: " + decToOct, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Decimal to Hex: " + decToHex, Toast.LENGTH_SHORT).show();
                    */

                } catch (Exception e) {
                    Toast.makeText(this, "Decimal can be only number. Please try again.", Toast.LENGTH_LONG).show();
                    etUnits.setText("");
                }

            } else if (radio_hex.isChecked()) {
                String text = etUnits.getText().toString();
                try {

                    int hexToDec = Integer.parseInt(text, 16);
                    String hexToBinary = Integer.toBinaryString(hexToDec);
                    String hexToOct = Integer.toOctalString(hexToDec);

                    outputTextView.setText("Hexadecimal is: "+ text +"\n\n" +
                            "Hex to binary is: "+ hexToBinary +"\n\n"+
                            "Hex to  octal is: "+ hexToOct + "\n\n"+
                            "Hex to decimal is: " + hexToDec + "\n\n");
                    /*
                    Toast.makeText(this, "Hexadecimal : " + text, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Hex to binary: " + hexToBinary, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Hex to octal: " + hexToOct, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Hex to Decimal: " + hexToDec, Toast.LENGTH_LONG).show();
                     */
                } catch (Exception e) {
                    Toast.makeText(this, "Hex can contain only number 0-9 or/and letter A-F. Please try again. ", Toast.LENGTH_LONG).show();
                    etUnits.setText("");
                }
            }
        }

    }
}

