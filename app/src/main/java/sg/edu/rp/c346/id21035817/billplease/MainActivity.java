package sg.edu.rp.c346.id21035817.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // step 1 - handles
    EditText etAmount;
    EditText etPax;
    EditText etDiscount;
    ToggleButton tbtnGST;
    ToggleButton tbtnSVS;
    TextView tvTotalBill;
    TextView tvEachPays;
    Button btnSplit;
    Button btnReset;
    RadioGroup rgMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // step 2 - bridges/links
        etAmount = findViewById(R.id.etAmount);
        etPax = findViewById(R.id.etPax);
        tvTotalBill = findViewById(R.id.tvTotalBill);
        tvEachPays = findViewById(R.id.tvEachPays);
        tbtnSVS = findViewById(R.id.tbtnSVS);
        tbtnGST = findViewById(R.id.tbtnGST);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);
        etDiscount = findViewById(R.id.etDiscount);
        rgMode = findViewById(R.id.rgMode);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = etAmount.getText().toString();
                String data2 = etPax.getText().toString();

                double amount = Double.parseDouble(data1);
                double newAmount = 0;
                int pax = Integer.parseInt(data2);

                if (tbtnGST.isChecked() == true && tbtnSVS.isChecked() == true) {
                    newAmount = amount * 1.10 * 1.07;
                } else if (tbtnGST.isChecked() == false && tbtnSVS.isChecked() == true) {
                    newAmount = amount * 1.10;
                } else if (tbtnGST.isChecked() == true && tbtnSVS.isChecked() == false) {
                    newAmount = amount * 1.07;
                } else {
                    newAmount = amount;
                }

                double eachPays = newAmount / pax;
                tvTotalBill.setText("$" + newAmount + "");
                tvEachPays.setText("$" + eachPays);
            }
        });
    }
}