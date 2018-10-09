package id.co.asyst.gabriella.louisa.pizzaorderlouisa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = findViewById(R.id.textViewResult);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            textViewResult.setText(bundle.getString("result"));
        } else {
            textViewResult.setText("Tidak Ada Data Masuk");
        }
    }
}
