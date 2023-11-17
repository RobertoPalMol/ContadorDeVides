package com.example.contadordevides;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contadordevides.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

    }

    private ImageButton life2;
    private ImageButton life22;
    private Button Poison2;
    private Button Poison11;
    private Button Poison22;
    private ImageButton arrowDown;
    private ImageButton arrowUp;
    private Button Poison1;
    private ImageButton life1;
    private ImageButton life11;
    private TextView Text1;
    private TextView Text2;

    private int vida1;
    private int vida2;
    private int veneno1;
    private int veneno2;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Vida1", vida1);
        outState.putInt("Vida2", vida2);
        outState.putInt("Veneno1", veneno1);
        outState.putInt("Veneno2", veneno2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);


        life2 = view.findViewById(R.id.life2);
        life22 = view.findViewById(R.id.life22);
        Poison2 = view.findViewById(R.id.Poison2);
        Poison11 = view.findViewById(R.id.Poison11);
        Poison22 = view.findViewById(R.id.Poison22);
        arrowDown = view.findViewById(R.id.arrowDown);
        arrowUp = view.findViewById(R.id.arrowUp);
        Poison1 = view.findViewById(R.id.Poison1);
        life1 = view.findViewById(R.id.life1);
        life11 = view.findViewById(R.id.life11);
        Text1 = view.findViewById(R.id.Text1);
        Text2 = view.findViewById(R.id.Text2);

        if (savedInstanceState != null) {
            vida1 = savedInstanceState.getInt("Vida1");
            vida2 = savedInstanceState.getInt("Vida2");
            veneno1 = savedInstanceState.getInt("Veneno1");
            veneno2 = savedInstanceState.getInt("Veneno2");
        } else {
            reset();
        }
        if (savedInstanceState != null) {
            vida1 = savedInstanceState.getInt("Vida1"); // Extraiem les dades
            vida2 = savedInstanceState.getInt("Vida2");
            veneno1 = savedInstanceState.getInt("Veneno1");
            veneno2 = savedInstanceState.getInt("Veneno2");

            updateViews(); // Actualitzem els comptadors
        }else{
            reset();
        }

        life1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    vida1++;
                updateViews();
            }
        });
        life2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vida1>0) {
                    vida1--;
                }
                updateViews();
            }
        });

        life11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida2++;
                updateViews();
            }
        });

        life22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vida2>0) {
                    vida2--;
                }
                updateViews();
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vida1>0) {
                    vida1--;
                    vida2++;
                }
                updateViews();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vida2>0) {
                    vida2--;
                    vida1++;
                }
                updateViews();
            }
        });

        Poison1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno1++;
                updateViews();
            }
        });
        Poison11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno2++;
                updateViews();
            }
        });

        Poison2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(veneno1>0) {
                    veneno1--;
                }
                updateViews();
            }
        });

        Poison22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(veneno2>0) {
                    veneno2--;
                }
                updateViews();
            }
        });

        return view;
    }

    private void reset() {
        veneno1 = 0;
        veneno2 = 0;
        vida1 = 25;
        vida2 = 25;

        updateViews();

    }

    private void updateViews() {
        Text1.setText(String.format("%d/%d", vida1, veneno1 ));
        Text2.setText(String.format("%d/%d", vida2, veneno2 ));
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_reset, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reset) {
            reset();
            Snackbar.make(requireView(), "Nuevo Juego!", Snackbar.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}