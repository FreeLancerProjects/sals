package com.creativeshare.sals.activities_fragments.home.fragments.frgment_more.fragment_help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.creativeshare.sals.activities_fragments.home.activity.Home_Activity;
import com.creativeshare.sals.R;
import com.creativeshare.sals.models.Questions_Model;
import com.creativeshare.sals.models.UserModel;
import com.creativeshare.sals.preferences.Preferences;

import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Question extends Fragment {
    private Home_Activity activity;
    private ImageView back_arrow;
    private String current_lang;

private Preferences preferences;
private UserModel userModel;
private TextView tv_ques,tv_answer;
private Button bt_no,bt_yes;
    final static private String Tag = "question";
private Questions_Model.Faqs faqss;
    public static Fragment_Question newInstance(Questions_Model.Faqs faqs) {

    Fragment_Question fragment_question=new Fragment_Question();
    Bundle bundle=new Bundle();
    bundle.putSerializable(Tag,faqs);
    fragment_question.setArguments(bundle);
    return fragment_question;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_question, container, false);
initView(view);
        return view;
    }



    private void initView(View view) {
        assert getArguments() != null;
        faqss= (Questions_Model.Faqs) getArguments().getSerializable(Tag);
        activity = (Home_Activity) getActivity();
        preferences=Preferences.getInstance();
        userModel=preferences.getUserData(activity);
        Paper.init(activity);
        current_lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        back_arrow = view.findViewById(R.id.arrow);
        tv_ques=view.findViewById(R.id.tv_question);
        tv_answer=view.findViewById(R.id.tv_ans);
        bt_no=view.findViewById(R.id.bt_no);
        bt_yes=view.findViewById(R.id.bt_yes);
        if(faqss!=null){
            tv_ques.setText(faqss.getQuestion());
            tv_answer.setText(faqss.getAnswer());
        }
       // arrow5=view.findViewById(R.id.arrow5);
        //arrow6=view.findViewById(R.id.arrow6);
bt_no.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        activity.DisplayFragmentTicket();
    }
});
        if (current_lang.equals("ar")) {
            back_arrow.setRotation(180.0f);
        }
bt_yes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        activity.Back();
    }
});
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.Back();
            }
        });
    }
}