package com.innovatesolutions.organizetorneios.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.innovatesolutions.organizetorneios.R;

public class BottomSheetTermsFragment extends BottomSheetDialogFragment {

    @Override public int getTheme() {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false);

        LinearLayout terms = view.findViewById(R.id.terms);
        Button btnOk = view.findViewById(R.id.btnOK);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

}
