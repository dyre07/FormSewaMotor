package id.sch.smktelkom_mlg.tugas01.xiirpl3037.formsewamotor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAlamat;
    Button bSimpan;
    RadioGroup rgJK;
    Spinner spJenisMotor;
    EditText etLama;
    CheckBox cbH, cbJH, cbM;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        bSimpan = (Button) findViewById(R.id.buttonSewa);
        rgJK = (RadioGroup) findViewById(R.id.radioGroup);
        spJenisMotor = (Spinner) findViewById(R.id.spinnerMotor);
        etLama = (EditText) findViewById(R.id.editTextLama);
        cbH = (CheckBox) findViewById(R.id.checkBoxH);
        cbJH = (CheckBox) findViewById(R.id.checkBoxJH);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
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
        String lama = etLama.getText().toString();
        String motor = spJenisMotor.getSelectedItem().toString();
        int ls = Integer.parseInt(lama);
        String acc = "\nAccessories\t\t: ";
        int startlen = acc.length();
        int a, b, c;

        if (nama == null) {
            etNama.setError("Nama Belum diisi");
        } else if (alamat == null) {
            etAlamat.setError("Alamat Belum diisi");
        } else if (lama == null) {
            etLama.setError("Lama sewa belum ditentukan");
        }
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (cbH.isChecked()) {
            acc += "\n\t\t\t\t\t\t- " + cbH.getText();
            a = 15000;
        } else {
            a = 0;
        }
        if (cbJH.isChecked()) {
            acc += "\n\t\t\t\t\t\t- " + cbJH.getText();
            b = 10000;
        } else {
            b = 0;
        }

        if (cbM.isChecked()) {
            acc += "\n\t\t\t\t\t\t- " + cbM.getText();
            c = 5000;
        } else {
            c = 0;
        }
        if (acc.length() == startlen) acc += "-";

        if (hasil == null) {
            tvHasil.setText("Anda belum memilih jenis kelamin");
        } else {
            tvHasil.setText("Nama\t\t\t\t\t: " + nama
                    + "\nAlamat\t\t\t\t: " + alamat
                    + "\nJenis Kelamin\t: " + hasil
                    + "\nJenis Motor\t\t: " + motor
                    + "\nLama Sewa\t\t: " + lama + " Hari"
                    + acc
                    + "\nBiaya Sewa\t\t: Rp." + ((ls * 60000) + (ls * a) + (ls * b) + (ls * c)));
            etNama.setText("");
            etAlamat.setText("");
            etLama.setText("");
            rgJK.clearCheck();
            cbJH.setChecked(false);
            cbM.setChecked(false);
            cbH.setChecked(false);
        }
    }
}
