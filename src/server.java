import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//   /Users/junyeoulyang/PycharmProjects/untitled
public class server {
    public static void main(String[] args) {
        client clts=new client();
        clts.clt();
        //mainClass mainCLS = new mainClass();
    }

}


class mainClass{
    ServerSocket server=null;
    Socket socket=null;
    String buffer;
    char num;
    public mainClass(){
        try{
            server=new ServerSocket(8104);
            while(true){
                System.out.print("waiting client...");
                socket=server.accept();
                System.out.println("gotcha!");
                BufferedReader BR=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("BR ready!");
                buffer=BR.readLine();
                System.out.println("read!");
                num=buffer.charAt(0);
                System.out.println(num+" is num");
                if(num=='1'){
                    sendDoorData();
                    System.out.println("send completed");
                }else{
                    System.out.println("no sign!");
                }
                BR.close();
                System.out.println("BR1");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                server.close();
                System.out.println("server");
                socket.close();
                System.out.println("socket");
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    private void sendDoorData(){
        try {
            String line;

            FileInputStream FIS = new FileInputStream("/Users/junyeoulyang/PycharmProjects/untitled/doordata.txt");
            InputStreamReader ISR=new InputStreamReader(FIS);
            BufferedReader BR=new BufferedReader(ISR);

            BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while((line=BR.readLine())!=null){
                    System.out.println(line);
                    BW.write(line+"\n");
            }
            BW.close();
            System.out.println("BW");
            FIS.close();
            System.out.println("FIS");
            ISR.close();
            System.out.println("ISR");
            BR.close();
            System.out.println("BR2");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
