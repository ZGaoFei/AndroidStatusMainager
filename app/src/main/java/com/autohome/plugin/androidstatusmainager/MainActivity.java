package com.autohome.plugin.androidstatusmainager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private LinearLayout linearLayout;

    private StatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.ll);
        statusView = findViewById(R.id.status_view);

        ((CheckBox)findViewById(R.id.ck_0)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_1)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_2)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_3)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_4)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_5)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_6)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_7)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_8)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.ck_9)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.ck_0:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_0);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_0);
                }
                break;
            case R.id.ck_1:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_1);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_1);
                }
                break;
            case R.id.ck_2:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_2);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_2);
                }
                break;
            case R.id.ck_3:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_3);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_3);
                }
                break;
            case R.id.ck_4:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_4);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_4);
                }
                break;
            case R.id.ck_5:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_5);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_5);
                }
                break;
            case R.id.ck_6:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_6);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_6);
                }
                break;
            case R.id.ck_7:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_7);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_7);
                }
                break;
            case R.id.ck_8:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_8);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_8);
                }
                break;
            case R.id.ck_9:
                if (isChecked) {
                    statusView.addStatus(StatusView.STATUS_9);
                } else {
                    statusView.deleteStatus(StatusView.STATUS_9);
                }
                break;
        }
    }
}
