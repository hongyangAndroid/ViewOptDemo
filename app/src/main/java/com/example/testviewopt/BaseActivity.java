package com.example.testviewopt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.zhy.demo.viewopt.ViewOpt;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = ViewOpt.createView(name, context, attrs);
        if (view != null) {
            return view;
        }
        return super.onCreateView(parent, name, context, attrs);
    }
}
