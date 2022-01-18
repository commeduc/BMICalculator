package cm.clear.bmicalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;
import cm.clear.bmicalculator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MaterialNumberPicker sizeMaterialNumberPicker;
    private MaterialNumberPicker weightMaterialNumberPicker;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sizeMaterialNumberPicker = binding.sizeNumberPicker;
        weightMaterialNumberPicker = binding.weightNumberPicker;

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int weight = weightMaterialNumberPicker.getValue();
                int size = sizeMaterialNumberPicker.getValue();

                double sizeInMeter = (double)size/100;
                double bmi = weight / (sizeInMeter*sizeInMeter);

                Log.d("Hosirus", "Weight : "+weight);
                Log.d("Hosirus", "Size : "+size);
                Log.d("Hosirus", "SizeInMeter : "+sizeInMeter);
                Log.d("Hosirus", "BMI : "+bmi);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}