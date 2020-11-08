package com.ga.millionaire;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;



public class ShowDialog {
    AlertDialog dialogCancel;
    private Context QuestionView;


    public ShowDialog(Context questionView) {
        QuestionView = questionView;

    }
    public void confirmAnswer(final int intAnswer) {
        //Ask the user to confirm the answer that was submitted.
        AlertDialog dialog;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(QuestionView);
        builder.setTitle(("Do you really want to quit the game ?"));
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Toast toast = Toast.makeText(QuestionView, "Your answer " +
                  //              "was recorded...congrats",
                       // Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                //toast.show();
                Boolean result = true;
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(QuestionView, "Please select an answer",
                       Toast.LENGTH_SHORT).show();
                Boolean result =false;

            }
        });
       // dialogCancel = builder.show();  //save a reference so dialog can be closed if time elapses
        builder.show();

    }

    public interface QuestionDialogLister{
        void returnAnswer(Boolean Answer);
    }

}