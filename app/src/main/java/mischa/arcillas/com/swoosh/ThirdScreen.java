package mischa.arcillas.com.swoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdScreen extends AppCompatActivity {
    private Button finishBtn;
    private Button beginnerBtn;
    private Button ballerBtn;
    public static final String PASS_STRING = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);
        findViews();
        beginnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ballerBtn.getAlpha()!=finishBtn.getAlpha()) {
                    beginnerBtn.setAlpha(1f);
                    ballerBtn.setAlpha(0.5f);
                    finishBtn.setAlpha(1f);
                    finishBtn.setEnabled(true);
                    finishBtn.setText("Finish");
                }
                else{
                    beginnerBtn.setAlpha(1f);
                    ballerBtn.setAlpha(1f);
                    finishBtn.setAlpha(0.5f);
                    finishBtn.setEnabled(false);
                    finishBtn.setText("");
                }
            }
        });
        ballerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ballerBtn.getAlpha()!=finishBtn.getAlpha()) {
                    beginnerBtn.setAlpha(0.5f);
                    ballerBtn.setAlpha(1f);
                    finishBtn.setAlpha(1f);
                    finishBtn.setEnabled(true);
                    finishBtn.setText("Finish");
                }
                else{
                    beginnerBtn.setAlpha(1f);
                    ballerBtn.setAlpha(1f);
                    finishBtn.setAlpha(0.5f);
                    finishBtn.setEnabled(false);
                    finishBtn.setText("");
                }
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iAm = "";
                if(beginnerBtn.getAlpha()==1f) {
                    iAm = beginnerBtn.getText().toString();
                }
                else if(ballerBtn.getAlpha()==1f) {
                    iAm = ballerBtn.getText().toString();
                }
                Intent data = new Intent();
                data.putExtra(PASS_STRING, iAm);
                setResult(Activity.RESULT_OK, data);

                finish();


            }
        });
    }

    private void findViews()
    {
        finishBtn = (Button) findViewById(R.id.finishBtn);
        beginnerBtn = (Button) findViewById(R.id.beginnerBtn);
        ballerBtn = (Button) findViewById(R.id.ballerBtn);
    }

}

