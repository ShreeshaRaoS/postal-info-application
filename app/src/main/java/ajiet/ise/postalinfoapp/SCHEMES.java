package ajiet.ise.postalinfoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SCHEMES#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SCHEMES extends Fragment {

    TextView scheme1,scheme2,scheme3,scheme4,scheme5,scheme6,scheme7,scheme8,scheme9,scheme10,scheme11,scheme12;

    public SCHEMES() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SCHEMES.
     */
    // TODO: Rename and change types and number of parameters
    public static SCHEMES newInstance(String param1, String param2) {
        SCHEMES fragment = new SCHEMES();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_schemes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scheme1=view.findViewById(R.id.scheme1);
        scheme2=view.findViewById(R.id.scheme2);
        scheme3=view.findViewById(R.id.scheme3);
        scheme4=view.findViewById(R.id.scheme4);
        scheme5=view.findViewById(R.id.scheme5);
        scheme6=view.findViewById(R.id.scheme6);
        scheme7=view.findViewById(R.id.scheme7);
        scheme8=view.findViewById(R.id.scheme8);
        scheme9=view.findViewById(R.id.scheme9);
        scheme10=view.findViewById(R.id.scheme10);
        scheme11=view.findViewById(R.id.scheme11);
        scheme12=view.findViewById(R.id.scheme12);


        scheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme1.class);
                startActivity(intent);
            }
        });

        scheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme2.class);
                startActivity(intent);
            }
        });

        scheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme3.class);
                startActivity(intent);
            }
        });

        scheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme4.class);
                startActivity(intent);
            }
        });

        scheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme5.class);
                startActivity(intent);
            }
        });
        scheme6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme6.class);
                startActivity(intent);
            }
        });

        scheme7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme7.class);
                startActivity(intent);
            }
        });
        scheme8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme8.class);
                startActivity(intent);
            }
        });
        scheme9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme9.class);
                startActivity(intent);
            }
        });
        scheme10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme10.class);
                startActivity(intent);
            }
        });
        scheme11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme11.class);
                startActivity(intent);
            }
        });
        scheme12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Scheme12.class);
                startActivity(intent);
            }
        });


    }
}