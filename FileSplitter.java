import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.*;
public class FileSplitter{
    public static void main(String[] args) {
        try{
            byte b[]=new byte[1000000];
            int x=1,j=0;
            String s="";
            InputStreamReader ins=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(ins);
            System.out.println("Enter Path of Source or Original File : ");
            String path=br.readLine();
            FileInputStream fis=new FileInputStream(path);
            int read_bytes;
            while(fis.available()!=0){
                j=0;
                s="";
                if(x<=9){
                    s=path+".00"+x;
                }
                else{
                    s=path+".0"+x;
                }
                FileOutputStream fos=new FileOutputStream(s);
                while(j<=50000000 && fis.available()!=0){
                    read_bytes=fis.read(b,0,1000000);
                    j=j+read_bytes;
                    fos.write(b,0,read_bytes);
                }
                System.out.println("Part "+x+" Created.");
                x++;
            }
            System.out.println("File splitted successfully....!!!");
            fis.close();
        }
    catch(Exception e){
    e.printStackTrace();
    }
    }
}
//"D:\java\Dil Jaaniye - Khandaani Shafakhana.mp3"