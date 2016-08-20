import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import pre_Poster.Pre_Poster;

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
                    try {
                        Thread th = new Thread(new Runnable() {

                            @Override
                            public void run() {
                                try {
                                    //System.out.println(serverCount);
                                    Socket socket = server.accept();
                                    System.out.println("GOTCHA!");
                                    threadCounterAndAccepter(false);
                                    
                                    //receive from client's method "sendCurrentStatus"

                                    InputStream IS = socket.getInputStream();
                                    ObjectInputStream OIS = new ObjectInputStream(IS);

                                    ArrayList<Object> obj = (ArrayList<Object>) OIS.readObject();
                                    System.out.println((int) obj.get(0));
                                    System.out.println((int) obj.get(1));
                                    System.out.println(obj.get(2).toString());
                                    System.out.println((int) obj.get(3));
                                    boolean[] bol=(boolean[])obj.get(4);
                                    if(bol!=null) {
                                        for (int i = 0; i < bol.length;i++) {
                                            System.out.print("*** "+bol[i]+" ");
                                        }
                                    }





                                    //******analyze received data here

                                    //******search proper poster data and make 'posters' variable




                                    int[] test = {1, 2, 3};
                                    Pre_Poster post = new Pre_Poster(1, "a", test, test, 1000, 124, "http://cafeptthumb1.phinf.naver.net/20101214_30/qaz9949_1292263897384EE4cK_jpg/%B2%DC%B9%FA%C7%CF%C4%A1%C0%C7%B4%EB%B8%F0%C7%E81_qaz9949.jpg?type=w740"
                                            , test, 100, 1413);
                                    Pre_Poster post2 = new Pre_Poster(1, "a", test, test, 1000, 124, "http://imgnews.naver.net/image/382/2015/07/29/72768009.2_99_20150729145527.jpg?type=w540"
                                            , test, 100, 1413);
                                    Pre_Poster post3 = new Pre_Poster(1, "a", test, test, 1000, 124, "http://cafeptthumb3.phinf.naver.net/20150328_180/comic567_1427493620200sEkh1_JPEG/%B4%D9%C0%CC%B3%EB_%C5%B8%C0%D3_main_poster.jpg?type=w740"
                                            , test, 100, 1413);
                                    Pre_Poster post4 = new Pre_Poster(1, "a", test, test, 1000, 124, "http://mimgnews1.naver.net/image/009/2011/10/19/0090002556687_0.jpg?type=w540"
                                            , test, 100, 1413);
                                    Pre_Poster post5 = new Pre_Poster(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                            , test, 100, 1413);

                                    Pre_Poster[] p=new Pre_Poster[8];
                                    p[0]=post;
                                    p[1]=post2;
                                    p[2]=post3;
                                    p[3]=post4;
                                    p[4]=post5;
                                    p[5]=post5;
                                    p[6]=post5;
                                    p[7]=post5;

                                    OutputStream OS = socket.getOutputStream();
                                    ObjectOutputStream OOS = new ObjectOutputStream(OS);

                                    OOS.writeObject(p);


                                    System.out.println("END!");
                                    OIS.close();
                                    IS.close();
                                    OOS.close();
                                    OS.close();
                                    socket.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        
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

    synchronized public boolean threadCounterAndAccepter(boolean threadIncreased){
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
}

