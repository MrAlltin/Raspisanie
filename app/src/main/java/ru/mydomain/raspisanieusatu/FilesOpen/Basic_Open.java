package ru.mydomain.raspisanieusatu.FilesOpen;

import android.app.Activity;
import android.content.res.Resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.mydomain.raspisanieusatu.R;

public class Basic_Open {
    public int GroupID;
    private String Group;

    public String  getStringFromRawFile(Activity activity) {
        Resources r = activity.getResources();
        InputStream is = r.openRawResource( R.raw.group);
        String myText = null;
        try {
            myText = convertStreamToString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  myText;
    }

    private String  convertStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = is.read();
        while( i != -1)
        {
            baos.write(i);
            i = is.read();
        }

        return  baos.toString();
    }

    public void setGroup(String group) {
        this.Group = group;
    }

    public int getGroupID() {

        switch (Group.toString()){
            case "bps_209":
                GroupID = R.raw.bps_209;
                System.out.println("Заполнили Group: "+Group+" ID: "+GroupID);
                break;
            case "mo_112":
                GroupID = R.raw.mo_112;
                System.out.println("Заполнили Group: "+Group+" ID: "+GroupID);
                break;
        }
        return GroupID;
    }
}
