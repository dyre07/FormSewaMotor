package id.sch.smktelkom_mlg.tugas01.xiirpl3037.formsewamotor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAlamat;
    Button bSimpan;
    RadioGroup rgJK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        bSimpan = (Button) findViewById(R.id.buttonSewa);
        rgJK = (RadioGroup) findViewById(R.id.radioGroup);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Anda belum memilih jenis kelamin");
        } else {
            tvHasil.setText("Nama\t:" + nama + "\nAlamat\t: " + alamat + "\nJenis Kelamin\t:" + hasil);
        }
    }
}
