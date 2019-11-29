package com.bawei.my1129zuoye.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.my1129zuoye.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_other, container, false);
        tv = inflate.findViewById(R.id.tv);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String key = getArguments().getString("key");
        tv.setText(key);
    }

    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
