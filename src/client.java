import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class client {
    public void clt(){
        Socket socket;
        ArrayList<String> array;
        try{
            socket=new Socket("203.170.122.31",9491);
            array=new ArrayList<>();
            System.out.println("gotcha");
            BufferedWriter BW=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("BW ready!");
            BW.write("1"+"\n");
            System.out.println("1 wrote!");
            BW.flush();
            System.out.println("flush!");


            System.out.println("write completed");
            BufferedReader BR=new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String line;
            while((line=BR.readLine())!=null){
                array.add(line);
            }

            for(int i=0;i<array.size();i++){
                System.out.print(array.get(i)+",");
            }

            System.out.println("read completed");

            BR.close();
            BW.close();
            socket.close();
        }catch(Exception e){
            System.out.println("rCC");
            e.printStackTrace();
        }
    }
}
