package com.ga.millionaire;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class QuestionDialog  extends AppCompatDialogFragment
{
    private QuestionDialogLister listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity(),R.style.MyDialogTheme);
        builder.setTitle(("Do you really want to stop here ?"));

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                listener.returnAnswer(true);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(getActivity(), "Please select an answer",
                        Toast.LENGTH_SHORT).show();
                //dialog.cancel();
            }
        });





        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener =(QuestionDialogLister) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must Implement Listener");
        }
    }

    public interface QuestionDialogLister{
        void returnAnswer(Boolean Answer);
    }
}
