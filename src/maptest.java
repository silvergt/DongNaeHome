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
                    try {
                        Thread th = new Thread(new Runnable() {
                            int status;
                            int order;
                            String search;
                            int startNum;
                            boolean[] filterState;
                            boolean[] dayOfWeek;

                            private boolean retrieveInformationFrom(ArrayList<Object> obj){
                                try {
                                    status = (int) obj.get(0);
                                    order = (int) obj.get(1);
                                    search = obj.get(2).toString();
                                    startNum = (int) obj.get(3);
                                    filterState = (boolean[]) obj.get(4);
                                    dayOfWeek=(boolean[])obj.get(5);
                                    return true;
                                }catch (Exception e){
                                    System.out.println("retrieving information failed!!");
                                    return false;
                                }

                            }


                            private ArrayList<HashMap<String,Object>> postersFromSTATUS_RECOMMENDATION(){
                                ArrayList<HashMap<String,Object>> posterList=new ArrayList<>();

                                //******TEMPORARY METHOD!!!!!!
                                int[] test = {1, 2, 3};

                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dthumb.phinf.naver.net/?src=%22http%3A%2F%2Fdbscthumb.phinf.naver.net%2F3329_000_25%2F20140925020328314_I5DE0YIR5.jpg%2F05-509391.jpg%3Ftype%3Dw690_fst_n%26wm%3DY%22&twidth=690&theight=509&opts=17"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://postfiles3.naver.net/20150715_82/1st_realize_1436938769715fLGLx_JPEG/%B1%B9%B0%A1%BA%B0_%B8%F0%BA%B4%C6%F7%BD%BA%C5%CD9.jpg?type=w1"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://postfiles13.naver.net/20150715_124/1st_realize_1436938770309nnh5g_JPEG/%B1%B9%B0%A1%BA%B0_%B8%F0%BA%B4%C6%F7%BD%BA%C5%CD6.jpg?type=w1"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://postfiles12.naver.net/20130216_43/suney_k0304_1360991836913Dxvhv_JPEG/1_%284%29.jpg?type=w2"
                                        , test, 100, 1413));

                                //******TEMPORARY METHOD!!!!!!

                                System.out.println("returning RECOMM poster");
                                return posterList;
                            }

                            private ArrayList<HashMap<String,Object>> postersFromSTATUS_POSTER_ABBREVIATED(){
                                ArrayList<HashMap<String,Object>> posterList=new ArrayList<>();

        //******TEMPORARY METHOD!!!!!!
                                int[] test = {1, 2, 3};
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://cafeptthumb1.phinf.naver.net/20101214_30/qaz9949_1292263897384EE4cK_jpg/%B2%DC%B9%FA%C7%CF%C4%A1%C0%C7%B4%EB%B8%F0%C7%E81_qaz9949.jpg?type=w740"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://imgnews.naver.net/image/382/2015/07/29/72768009.2_99_20150729145527.jpg?type=w540"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://cafeptthumb3.phinf.naver.net/20150328_180/comic567_1427493620200sEkh1_JPEG/%B4%D9%C0%CC%B3%EB_%C5%B8%C0%D3_main_poster.jpg?type=w740"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://mimgnews1.naver.net/image/009/2011/10/19/0090002556687_0.jpg?type=w540"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                        , test, 100, 1413));
                                posterList.add(makePosterResource(1, "a", test, test, 1000, 124, "http://dbscthumb.phinf.naver.net/0903_000_2/20120314151219525_6Y6JPKNKN.jpg/he1_733_i1.jpg?type=w492_2&wm=Y"
                                        , test, 100, 1413));
        //******TEMPORARY METHOD!!!!!!
                                System.out.println("returning ABBR poster");

                                return posterList;
                            }

                            private ArrayList<HashMap<String,Object>> postersFromSTATUS_POSTER_FULL(){
                                ArrayList<HashMap<String,Object>> posterList=new ArrayList<>();


                                System.out.println("returning FULL poster");
                                return posterList;
                            }

                            private ArrayList<HashMap<String,Object>> makePosterLists(){
                                if(status==TempData.STATUS_RECOMMENDATION){
                                    return postersFromSTATUS_RECOMMENDATION();
                                }else if(status==TempData.STATUS_POSTER_ABBREVIATED){
                                    return postersFromSTATUS_POSTER_ABBREVIATED();
                                }else if(status==TempData.STATUS_POSTER_FULL){
                                    return postersFromSTATUS_POSTER_FULL();
                                }

                                return null;
                            }



                            @Override
                            public void run() {
                                try {
                                    Socket socket = server.accept();
                                    System.out.println("GOTCHA!");
                                    threadCounterAndAccepter(false);

                                    InputStream IS = socket.getInputStream();
                                    ObjectInputStream OIS = new ObjectInputStream(IS);

                                    if(!retrieveInformationFrom((ArrayList<Object>) OIS.readObject())){
                                        System.out.println("retrieving failed... closing socket!");
                                        //******SEND FAILURE STATUS POSTER TO CLIENT HERE!
                                        OIS.close();
                                        IS.close();
                                        socket.close();
                                        return;
                                    }
                                    System.out.println("receive completed from socket - " + socket.toString() +" $ "+Integer.toString(status)
                                            +" $ "+Integer.toString(order)+" $ "+search+" $ "+Integer.toString(startNum));
                                    if(filterState!=null) for (int i=0;i<filterState.length;i++)System.out.print(filterState[i]+" * ");System.out.println();
                                    if(dayOfWeek!=null)for (int i=0;i<dayOfWeek.length;i++)System.out.print(dayOfWeek[i]+" * ");System.out.println();

                                    OutputStream OS = socket.getOutputStream();
                                    ObjectOutputStream OOS = new ObjectOutputStream(OS);

                                    OOS.writeObject(makePosterLists());


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

