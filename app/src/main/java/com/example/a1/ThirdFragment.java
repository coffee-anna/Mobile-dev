package com.example.a1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_text_fragment, container, false);
        FourthFragment fragment = new FourthFragment();

        editText = view.findViewById(R.id.editTextFrag);
        Bundle bundle = new Bundle();
        Button button = view.findViewById(R.id.buttonToFourthFragment);
        button.setOnClickListener(
                v -> {
                        bundle.putString("data", editText.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    }
        );
        return view;
    }
}
