package ru.mydomain.raspisanieusatu.FilesOpen;

import android.app.Activity;
import android.content.res.Resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.mydomain.raspisanieusatu.R;

public class Open_Files {

    public int n = 0;



    String[] vizov;
    String FileText;
    String[] names;
    String[] finalname;

    public void setFileText(String fileText) {
        this.FileText = fileText;
    }

    public String getFileText() {
        return FileText;
    }

    public void openFile(int fileName) {
        try {
            StringBuilder sb = new StringBuilder(FileText);
            StringBuilder sb1 = new StringBuilder(FileText);
            while (sb1.toString().indexOf(";")!=-1){
                n=n+1;
                sb1.delete(0, sb1.indexOf(";")+1);
            }

            vizov = new String[n];
            names = new String[n];
            finalname = new String[n];
            finalname = null;

        } catch (Throwable t) {
            System.out.println("Exception: " + t.toString());;
        }
    }

    public String[] getFinalname() {
        return finalname;
    }

    public String[] Name(String FileText) {

        StringBuilder sb = new StringBuilder(FileText);
        StringBuilder sb1 = new StringBuilder(FileText);
        sb = sb1;
        for (int i = 0; i < n; i++) {
            String uame = sb.toString();

            int index = uame.indexOf(",");
            if (!sb.toString().isEmpty()) {
                names[i] = sb.toString().substring( 0, index );
            }

            String tel = sb.toString();
            int index2 = tel.indexOf(",") + 2;
            int index3 = tel.indexOf(";");
//            tel = sb.toString().substring(index2, index3);
           //  = uame;
            vizov[i] = tel;
            System.out.println("Длина:" + sb.length());
            sb.delete(0, index3 + 1);
        }
        sb = sb1;
        if(finalname==null) {
            finalname = names;
            System.out.println( "Теперь не пусто!" );
        }
        return finalname;
    }


    public String  getStringFromRawFile(Activity activity) {
        Resources r = activity.getResources();
        InputStream is = r.openRawResource(R.raw.sample);
        String myText = null;
        String edit = null;
        try {
            myText = convertStreamToString(is);
            edit = myText;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (myText.contains("[")){
            myText.replace("[","");
        }
        if (myText.contains("]")) {
            myText.replace("]", "");
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
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String[] getNames() {
        return names;
    }
}
