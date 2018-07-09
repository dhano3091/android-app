package dhamraj.jindal.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class Tab2 extends Fragment {



String name[]={"RockGarden","RoseGarden","LaserValey","Le Corbusier Centre","BotanicalGarden"};
    public Tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab2,container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.list_fragment);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, name);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i=new Intent(getContext(),RockGarden.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent one=new Intent(getContext(),RoseGarden.class);
                        startActivity(one);
                        break;
                    case 2:
                        Intent two=new Intent(getContext(),LazerValey.class);
                        startActivity(two);
                        break;
                    case 3:
                        Intent three=new Intent(getContext(),Corbuzier.class);
                        startActivity(three);
                        break;
                    case 4:
                        Intent four=new Intent(getContext(),Botanical.class);
                        startActivity(four);
                        break;


                }
            }
        });
        return rootView;



    }


}
