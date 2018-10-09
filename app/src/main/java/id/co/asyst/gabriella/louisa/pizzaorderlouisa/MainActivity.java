package id.co.asyst.gabriella.louisa.pizzaorderlouisa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    String editName;
    String toggle = "Ukuran size Normal";
    String selectedSize1 = "";
    String selectedSize2 = "";
    String selectedSize3 = "";
    EditText editTextName;
    Button buttonSubmit, buttonOrder;
    RadioButton radioButtonSmall, radioButtonMedium, radioButtonLarge, radioButtonSmall2, radioButtonMedium2, radioButtonLarge2, radioButtonSmall3, radioButtonMedium3, radioButtonLarge3;
    CheckBox checkBoxPizzaBakso, checkBoxPizzaMakaroni, checkBoxPizzaDaging;
    RadioGroup radioGroupPizza1, radioGroupPizza2, radioGroupPizza3;
    ToggleButton toggleButton;
    ImageView imageViewCancel;
    ArrayList<String> listPizza = new ArrayList<>();
    String pizza = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonOrder = findViewById(R.id.buttonOrder);
        checkBoxPizzaBakso = findViewById(R.id.checkboxPizzaBakso);
        checkBoxPizzaMakaroni = findViewById(R.id.checkboxPizzaMakaroni);
        checkBoxPizzaDaging = findViewById(R.id.checkboxPizzaDaging);
        radioGroupPizza1 = findViewById(R.id.radioGroupPizza1);
        radioGroupPizza2 = findViewById(R.id.radioGroupPizza2);
        radioGroupPizza3 = findViewById(R.id.radioGroupPizza3);
        checkBoxPizzaBakso = findViewById(R.id.checkboxPizzaBakso);
        checkBoxPizzaMakaroni = findViewById(R.id.checkboxPizzaMakaroni);
        checkBoxPizzaDaging = findViewById(R.id.checkboxPizzaDaging);
        toggleButton = findViewById(R.id.toggleButton);
        radioButtonSmall = findViewById(R.id.radioButtonSmall);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        radioButtonLarge = findViewById(R.id.radioButtonLarge);
        radioButtonSmall2 = findViewById(R.id.radioButtonSmall2);
        radioButtonMedium2 = findViewById(R.id.radioButtonMedium2);
        radioButtonLarge2 = findViewById(R.id.radioButtonLarge2);
        radioButtonSmall3 = findViewById(R.id.radioButtonSmall3);
        radioButtonMedium3 = findViewById(R.id.radioButtonMedium3);
        radioButtonLarge3 = findViewById(R.id.radioButtonLarge3);
        imageViewCancel = findViewById(R.id.imageViewCancel);

        buttonSubmit.setOnClickListener(this);
        buttonOrder.setOnClickListener(this);
        imageViewCancel.setOnClickListener(this);
        radioGroupPizza1.setOnCheckedChangeListener(this);
        radioGroupPizza2.setOnCheckedChangeListener(this);
        radioGroupPizza3.setOnCheckedChangeListener(this);
        checkBoxPizzaBakso.setOnCheckedChangeListener(this);
        checkBoxPizzaMakaroni.setOnCheckedChangeListener(this);
        checkBoxPizzaDaging.setOnCheckedChangeListener(this);
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        editName = editTextName.getText().toString();
        switch (id) {
            case R.id.buttonSubmit:
                if (!TextUtils.isEmpty(editName)) {
                    checkBoxPizzaDaging.setEnabled(true);
                    checkBoxPizzaBakso.setEnabled(true);
                    checkBoxPizzaMakaroni.setEnabled(true);
                    buttonOrder.setEnabled(true);
                    toggleButton.setEnabled(true);

                } else {
                    Toast.makeText(getApplicationContext(), "Nama Order Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonOrder:
                pizza = "";
                for (int i = 0; i < listPizza.size(); i++) {
                    pizza = pizza + " " + listPizza.get(i);
                }
                Intent intent = new Intent(this, ResultActivity.class);
                String result = "Nama Order: " + editName + "\n" + "Pesanan: " + "\n" + pizza + "Detail Pesanan: \n" + selectedSize1 + "\n" + selectedSize2 + "\n" + selectedSize3 + "\n" + "\n" + toggle;
                intent.putExtra("result", result);
                startActivity(intent);
                break;
            case R.id.imageViewCancel:
                checkBoxPizzaDaging.setEnabled(false);
                checkBoxPizzaBakso.setEnabled(false);
                checkBoxPizzaMakaroni.setEnabled(false);
                buttonOrder.setEnabled(false);
                toggleButton.setEnabled(false);
                radioButtonSmall.setChecked(false);
                radioButtonMedium.setChecked(false);
                radioButtonLarge.setChecked(false);
                radioButtonSmall2.setChecked(false);
                radioButtonMedium2.setChecked(false);
                radioButtonLarge2.setChecked(false);
                radioButtonSmall3.setChecked(false);
                radioButtonMedium3.setChecked(false);
                radioButtonLarge3.setChecked(false);
                editTextName.setText("");
                toggleButton.setChecked(false);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButtonSmall:
                selectedSize1 = "- Pizza Bakso size Small";
                break;
            case R.id.radioButtonMedium:
                selectedSize1 = "- Pizza Bakso size Medium";
                break;
            case R.id.radioButtonLarge:
                selectedSize1 = "- Pizza Bakso size Large";
                break;
            case R.id.radioButtonSmall2:
                selectedSize2 = "- Pizza Makaroni size Small";
                break;
            case R.id.radioButtonMedium2:
                selectedSize2 = "- Pizza Makaroni size Medium";
                break;
            case R.id.radioButtonLarge2:
                selectedSize2 = "- Pizza Makaroni size Large";
                break;
            case R.id.radioButtonSmall3:
                selectedSize3 = "- Pizza Daging size Small";
                break;
            case R.id.radioButtonMedium3:
                selectedSize3 = "- Pizza Daging size Medium";
                break;
            case R.id.radioButtonLarge3:
                selectedSize3 = "- Pizza Daging size Large";
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.checkboxPizzaBakso:
                if (isChecked) {
                    listPizza.add("- Pizza Bakso\n");
                    radioButtonSmall.setEnabled(true);
                    radioButtonMedium.setEnabled(true);
                    radioButtonLarge.setEnabled(true);
                } else {
                    listPizza.remove("- Pizza Bakso\n");
                    radioButtonSmall.setEnabled(false);
                    radioButtonMedium.setEnabled(false);
                    radioButtonLarge.setEnabled(false);
                }
                break;
            case R.id.checkboxPizzaMakaroni:
                if (isChecked) {
                    listPizza.add("- Pizza Makaroni\n");
                    radioButtonSmall2.setEnabled(true);
                    radioButtonMedium2.setEnabled(true);
                    radioButtonLarge2.setEnabled(true);
                } else {
                    listPizza.remove("- Pizza Makaroni\n");
                    radioButtonSmall2.setEnabled(false);
                    radioButtonMedium2.setEnabled(false);
                    radioButtonLarge2.setEnabled(false);
                }
                break;
            case R.id.checkboxPizzaDaging:
                if (isChecked) {
                    listPizza.add("- Pizza Daging\n");
                    radioButtonSmall3.setEnabled(true);
                    radioButtonMedium3.setEnabled(true);
                    radioButtonLarge3.setEnabled(true);
                } else {
                    listPizza.remove("- Pizza Daging\n");
                    radioButtonSmall3.setEnabled(false);
                    radioButtonMedium3.setEnabled(false);
                    radioButtonLarge3.setEnabled(false);
                }
                break;
            case R.id.toggleButton:
                if (isChecked) {
                    toggle = "Ukuran size Upsize";
                } else {
                    toggle = "Ukuran size Normal";
                }
                break;
        }
    }
}
