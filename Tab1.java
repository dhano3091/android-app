package dhamraj.jindal.tourism;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Tab1 extends Fragment {

    TextView textView;

    public Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        //textView = (TextView) view.findViewById(R.id.text_scroll);
        //textView.setMovementMethod(new ScrollingMovementMethod());
        //textView.setText(getResources().getString(R.string.home));
        return view;
    }

}