package com.ljj.ljjgame.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityDialogBinding;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDialogBinding dialogBinding = DataBindingUtil.setContentView(this,R.layout.activity_dialog);
        DialogViewModel viewModel = new DialogViewModel(getApplication(),this,dialogBinding);
        dialogBinding.setViewModel(viewModel);
    }
}
