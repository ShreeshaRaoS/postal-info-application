package ajiet.ise.postalinfoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import androidx.annotation.NonNull;

import ajiet.ise.postalinfoapp.activities.calculator.CalculatorMIS;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorNSC;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorPPF;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorRD;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorSCSS;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorSSYA;
import ajiet.ise.postalinfoapp.activities.calculator.CalculatorTD;
import ajiet.ise.postalinfoapp.databinding.FragmentLocationBinding;

public class LOCATION extends Fragment {

    private FragmentLocationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLocationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.nsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorNSC.class));
            }
        });

        binding.nsc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorNSC.class));
            }
        });


        binding.mis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorMIS.class));
            }
        });


        binding.mis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorMIS.class));
            }
        });


        binding.ppf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorPPF.class));
            }
        });

        binding.ppf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorPPF.class));
            }
        });


        binding.RD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorRD.class));
            }
        });


        binding.rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorRD.class));
            }
        });


        binding.scss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorSCSS.class));
            }
        });

        binding.scss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorSCSS.class));
            }
        });


        binding.ssy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorSSYA.class));
            }
        });

        binding.ssy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorSSYA.class));
            }
        });


        binding.td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorTD.class));
            }
        });

        binding.td1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalculatorTD.class));
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}


