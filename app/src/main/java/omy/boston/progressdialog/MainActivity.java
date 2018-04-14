package omy.boston.progressdialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import omy.boston.progressdialog.ProgresDialog.SeparateThread;

public class MainActivity extends AppCompatActivity {

    private Button btnDiCircle;
    private Button btnDiProgres;
    private ProgressDialog progDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDiCircle = (Button) findViewById(R.id.btnCircle);
        btnDiProgres = (Button) findViewById(R.id.btnLinear);

        btnDiCircle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                progDialog = ProgressDialog.show(MainActivity.this, "Prikupljanje podataka!", "Ček koju sec...");
                SeparateThread ovoSeTh = new SeparateThread(progDialog, false);
                ovoSeTh.start();
            }
        });

        btnDiProgres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                progDialog = new ProgressDialog(MainActivity.this);
                progDialog.setTitle("Dohvačanje podataka!");
                progDialog.setMessage("Preostalo još...");
                progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progDialog.show();

                SeparateThread ovoSeTh = new SeparateThread(progDialog, true);
                ovoSeTh.start();
            }
        });
    }
}
