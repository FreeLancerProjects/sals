package com.creativeshare.sals.activities_fragments.home.fragments.fragment_calculate_price.fragment_calculate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.creativeshare.sals.activities_fragments.home.activity.Home_Activity;
import com.creativeshare.sals.R;

import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Shipping_Dementions extends Fragment {
    private Home_Activity activity;
    private String current_lang;
    private ImageView back_arrow;

    public static Fragment_Shipping_Dementions newInstance() {
        return new Fragment_Shipping_Dementions();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipping_dimintions, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        activity = (Home_Activity) getActivity();
        Paper.init(activity);
        current_lang = Paper.book().read("lang", Locale.getDefault().getLanguage());

        back_arrow = view.findViewById(R.id.arrow);
        if (current_lang.equals("ar")) {
            back_arrow.setRotation(180.0f);
        }
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.Back();
            }
        });

    }


}
