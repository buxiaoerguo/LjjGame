package com.ljj.ljjgame.dialog;

import android.app.Application;
import android.view.View;

import com.ljj.ljjgame.databinding.ActivityDialogBinding;
import com.ljj.ljjgame.util.DialogUtil;


public class DialogViewModel {
    DialogActivity dialogActivity;
    ActivityDialogBinding binding;
    public DialogViewModel(Application application, DialogActivity dialogActivity, ActivityDialogBinding binding){
        this.dialogActivity = dialogActivity;
        this.binding = binding;
    }
    public void showDialog(View view){
        DialogUtil.getInstance().showDialog(dialogActivity);
    }
}
