package mischa.arcillas.com.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Swoosh_Second_Screen extends AppCompatActivity {
    private Button mensBtn;
    private Button womensBtn;
    private Button coEdBtn;
    private Button nextBtn;
    private TextView iAmtxt;
    private TextView iAm;
    public static final String PASS_STRING = "";
    public static final int REQ_CODE = 1111;

    public Swoosh_Second_Screen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swoosh__second__screen);

        findViews();

        mensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mensBtn.getAlpha() != nextBtn.getAlpha()) {
                    mensBtn.setAlpha(1f);
                    womensBtn.setAlpha(0.5f);
                    coEdBtn.setAlpha(0.5f);
                    nextBtn.setAlpha(1f);
                    nextBtn.setEnabled(true);
                }
                else if(iAm.getText().toString().isEmpty()){
                    mensBtn.setAlpha(1f);
                    womensBtn.setAlpha(1f);
                    coEdBtn.setAlpha(1f);
                    nextBtn.setAlpha(0.5f);
                    nextBtn.setEnabled(false);
                }
            }
        });
        womensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(womensBtn.getAlpha() != nextBtn.getAlpha()) {
                    mensBtn.setAlpha(0.5f);
                    womensBtn.setAlpha(1f);
                    coEdBtn.setAlpha(0.5f);
                    nextBtn.setAlpha(1f);
                    nextBtn.setEnabled(true);
                }
                else if(iAm.getText().toString().isEmpty()){
                    mensBtn.setAlpha(1f);
                    womensBtn.setAlpha(1f);
                    coEdBtn.setAlpha(1f);
                    nextBtn.setAlpha(0.5f);
                    nextBtn.setEnabled(false);
                }
            }
        });
        coEdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coEdBtn.getAlpha() != nextBtn.getAlpha()) {
                    mensBtn.setAlpha(0.5f);
                    womensBtn.setAlpha(0.5f);
                    coEdBtn.setAlpha(1f);
                    nextBtn.setAlpha(1f);
                    nextBtn.setEnabled(true);

                }
                else if(iAm.getText().toString().isEmpty()){
                    mensBtn.setAlpha(1f);
                    womensBtn.setAlpha(1f);
                    coEdBtn.setAlpha(1f);
                    nextBtn.setAlpha(0.5f);
                    nextBtn.setEnabled(false);

                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skillIntent = new Intent(v.getContext(), ThirdScreen.class);
                startActivityForResult(skillIntent, REQ_CODE);
            }
        });
    }
    private void findViews(){
        mensBtn = (Button) findViewById(R.id.mensBtn);
        womensBtn = (Button) findViewById(R.id.womensBtn);
        coEdBtn = (Button) findViewById(R.id.coedBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        iAm = (TextView)findViewById(R.id.rplyTxt);
        iAmtxt = (TextView)findViewById(R.id.iamTxt);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE) {
                String replyMsg = data.getStringExtra(Swoosh_Second_Screen.PASS_STRING);
                iAmtxt.setVisibility(View.VISIBLE);
                iAm.setVisibility(View.VISIBLE);
                iAm.setText(replyMsg);
                nextBtn.setVisibility(View.GONE);
                if(mensBtn.getAlpha()!=0.9f)
                    mensBtn.setEnabled(false);
                if(womensBtn.getAlpha()!=0.9f)
                    womensBtn.setEnabled(false);
                if(coEdBtn.getAlpha()!=0.9f)
                    coEdBtn.setEnabled(false);
            }
        }
    }
}
