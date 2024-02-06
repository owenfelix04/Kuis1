package latihan.membuat.kuis1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class LatihanMembuatKomponen extends AppCompatActivity {

        private EditText editNama;
        private RadioGroup radioGroup;
        private CheckBox cbOlahraga, cbJalan_jalan, cbMakan, cbBelajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_membuat_komponen);

            // Initialize your views
            editNama = findViewById(R.id.editNama);
            radioGroup = findViewById(R.id.radioGroup);
            cbOlahraga = findViewById(R.id.cbOlahraga);
            cbJalan_jalan = findViewById(R.id.cbJalan_jalan);
            cbMakan = findViewById(R.id.cbMakan);
            cbBelajar = findViewById(R.id.cbBelajar);

            // Initialize ImageButtons
            ImageButton imgButtonAdd = findViewById(R.id.imgButtonAdd);
            ImageButton imgButtonCancel = findViewById(R.id.imgButtonCancel);

            // Set click listeners for ImageButtons
            imgButtonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Show Snackbar with the input values
                    showSnackbar();
                    // Clear input fields
                    clearInputs();
                }
            });

            imgButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Clear input fields
                    clearInputs();
                }
            });
        }

        private void showSnackbar() {
            // Get input values
            String nama = editNama.getText().toString();
            String gender = getSelectedRadioButtonText();
            String hobbies = getSelectedCheckBoxesText();

            // Create a message for the horizontal Snackbar
            String message = "Nama: " + nama + " | Gender: " + gender + " | Hobbies: " + hobbies;

            // Show the horizontal Snackbar
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            snackbarView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR); // Set layout direction to right-to-left
            snackbar.show();
        }


        private String getSelectedRadioButtonText() {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";
        }

        private String getSelectedCheckBoxesText() {
            StringBuilder selectedHobbies = new StringBuilder();

            if (cbOlahraga.isChecked()) {
                selectedHobbies.append("Olahraga, ");
            }

            if (cbJalan_jalan.isChecked()) {
                selectedHobbies.append("Jalan-jalan, ");
            }

            if (cbMakan.isChecked()) {
                selectedHobbies.append("Makan");
            }

            if (cbBelajar.isChecked()) {
                selectedHobbies.append("Belajar");
            }

            return selectedHobbies.toString();
        }

        private void clearInputs() {
            editNama.getText().clear();
            radioGroup.clearCheck();
            cbOlahraga.setChecked(false);
            cbJalan_jalan.setChecked(false);
            cbMakan.setChecked(false);
            cbBelajar.setChecked(false);
    }
}