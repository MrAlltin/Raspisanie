package ru.mydomain.raspisanieusatu.FilesOpen;

import android.app.Activity;
import android.content.res.Resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.mydomain.raspisanieusatu.MainActivity;

public class Open_Files {

    public int n = 0;



    String[] rooms;
    String[] prepods;
    String FileText;

    String[] names;
    String[] finalname;

    public void setFileText(String fileText) {
        this.FileText = fileText;
    }

    public String getFileText() {
        return FileText;
    }

    public void openFile(int fileid) {
        try {
            StringBuilder sb = new StringBuilder(FileText);
            StringBuilder sb1 = new StringBuilder(FileText);
            while (sb1.toString().indexOf(";")!=-1){
                n=n+1;
                sb1.delete(0, sb1.indexOf(";")+1);
            }

            rooms = new String[n];
            names = new String[n];
            prepods = new String[n];
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
            String prepod;

            int index = uame.indexOf(",");
            names[i] = sb.toString().substring( 0, index );
            sb.delete(0, index + 2);
            String room = sb.toString();
            int index2 = sb.indexOf(",");
            rooms[i] = sb.toString().substring(0, index2);
            sb.delete(0, index2 + 2);
            int index3 = sb.indexOf(";");
            prepods[i] = sb.toString().substring( 0,index3 );
            System.out.println("Преподы:" + sb.toString().substring( 0,index3 ));
            sb.delete(0, index3 + 1);
        }
        sb = sb1;
        if(finalname==null) {
            finalname = names;
            System.out.println( "Теперь не пусто!" );
        }
        if(rooms==null){
            System.out.println("Rooms пусто!");
        }
        if(prepods==null){
            System.out.println("Prepods пусто!");
        }
        return finalname;
    }

    public String[] getRooms() {
        return rooms;
    }

    public String[] getPrepods() {
        return prepods;
    }

    public String  getStringFromRawFile(Activity activity, int ID ) {
        Resources r = activity.getResources();
        MainActivity ma = new MainActivity();
        InputStream is = r.openRawResource(ID);
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
