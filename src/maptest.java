import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class maptest {
    static int serverCount=0;
    final static int totalServerAccept=10;

    public static void main(String[] args){
        maptest serv=new maptest();
        serv.server();

    }

    public void server(){
        try{
            final ServerSocket server=new ServerSocket(9491);
            while(true){
                if(threadCounterAndAccepter(true)){
                    try{
                        Thread th=new Thread(new ClientThread(server));
                        th.start();
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }

                }else{

                }
            }



        }catch (Exception e){
            System.out.print("ERROR");
            e.printStackTrace();
        }
    }

    synchronized public static boolean threadCounterAndAccepter(boolean threadIncreased){
        if(serverCount<totalServerAccept) {
            if (threadIncreased) {
                serverCount++;
            } else {
                serverCount--;
            }
        }else if(serverCount>=totalServerAccept){
            if(threadIncreased){
                return false;
            }else{
                serverCount--;
            }
        }
        System.out.println(serverCount);
        return true;
    }

    static HashMap<String,Object> makePosterResource(int id, String title, int[] startDate, int[] endDate, int price,
                                                     int place, String main_picture, int[] category, int like,int view){
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("title",title);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("price",price);
        map.put("place",place);
        map.put("main_picture",main_picture);
        map.put("main_picture",main_picture);
        map.put("category",category);
        map.put("like",like);
        map.put("view",view);

        return map;
    }

}

