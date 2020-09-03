package com.curso.viewmodeltarea.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.curso.viewmodeltarea.MainActivity;
import com.curso.viewmodeltarea.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private Button btnVerdadero;
    private Button btnFalso;
    private Button btnSiguiente;
    private Button btnAnterior;
    private TextView tvPregunta;

    private MainViewModel[] mainViewModels = new MainViewModel[]{
            new MainViewModel(R.string.pregunta_1, true),
            new MainViewModel(R.string.pregunta_2, true),
            new MainViewModel(R.string.pregunta_3, true),
            new MainViewModel(R.string.pregunta_4, true),
            new MainViewModel(R.string.pregunta_5, false)
    };

    private int actual = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btnVerdadero = (Button) btnVerdadero.findViewById();
        btnFalso = (Button) btnFalso.findViewById();
        btnAnterior = (Button) btnAnterior.findViewById();
        btnSiguiente = (Button) btnSiguiente.findViewById();
        tvPregunta = (TextView) tvPregunta.findViewById();

        setText();

        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(true);
            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(false);
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (actual == 0) {
                    actual = mainViewModels.length - 1;
                } else {
                    actual--;
                }

                setText();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actual = (actual + 1) % mainViewModels.length;
                setText();
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=mainViewModels[actual].isRespuesta();
                Intent i = btnAnterior.newIntent(MainActivity.this,result);
                startActivity(i);
            }
        });
    }

    private void setContentView(int main_activity) {
    }

    public void setText() {
        tvPregunta.setText(mainViewModels[actual].getTextoId());
    }

    public void verificarRespuesta(boolean result) {
        if (result == mainViewModels[actual].isRespuesta()) {
            Toast.makeText(MainFragment.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainFragment.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }







    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}