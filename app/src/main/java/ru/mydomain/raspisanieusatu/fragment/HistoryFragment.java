package ru.mydomain.raspisanieusatu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mydomain.raspisanieusatu.FilesOpen.Basic_Open;
import ru.mydomain.raspisanieusatu.FilesOpen.Open_Files;
import ru.mydomain.raspisanieusatu.MainActivity;
import ru.mydomain.raspisanieusatu.R;
import ru.mydomain.raspisanieusatu.adapter.RemindListAdapter;
import ru.mydomain.raspisanieusatu.dto.RemindDTO;


public class HistoryFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_history;

    private int t;
    private String FileText;
    boolean wtf = true;





    public static HistoryFragment getInstanse(Context context){
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new RemindListAdapter(creatMockRemindListData()));


        return view;
    }

    private List<RemindDTO> creatMockRemindListData() {
        String group;
        int GroupID;
        Open_Files opn = new Open_Files();
        MainActivity ma = new MainActivity();
        Basic_Open bo = new Basic_Open();
        group = bo.getStringFromRawFile( getActivity() );
        bo.setGroup( group );
        GroupID = bo.getGroupID();
        FileText = opn.getStringFromRawFile(getActivity(), GroupID);
        opn.setFileText(FileText);
        opn.openFile(GroupID);
        t = opn.getN();
        System.out.println(t);
        opn.Name(FileText);


        List<RemindDTO> data = new ArrayList<>();
        String[] names = opn.getFinalname();
        String[] rooms = opn.getRooms();
        String[] prepods = opn.getPrepods();
            if(names.length==0){
                System.out.println("names пуст!");
            }
            for (int i =0;i<t;i++) {
                data.add( new RemindDTO( names[i].toString(), rooms[i].toString(), prepods[i].toString()  ) );
            }




        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
