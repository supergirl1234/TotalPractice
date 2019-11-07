package comm;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class QQServer {

    private static Set<SocketChannel> set = new HashSet<>();
    private static ByteBuffer byteBuffer=ByteBuffer.allocate(512);
    static  byte[] bytes=new byte[1024];

    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(8080));
            serverSocket.configureBlocking(false);//设置为非阻塞的
            while (true) {
                System.out.println("等待连接");
                SocketChannel socket = serverSocket.accept();
                if (socket == null) {

                    Thread.sleep(1000);
                    System.out.println("无人连接");
                } else {
                    socket.configureBlocking(false);//将其设置为非阻塞
                    set.add(socket);
                    System.out.println("连接成功");
                    System.out.println("等待读取数据");
                }

                for (SocketChannel item : set) {
                    //int value=item.read(byteBuffer);
                    int value=item.read(ByteBuffer.wrap(bytes));

                  /*  if(value>0) {
                        byteBuffer.flip();
                        System.out.println(byteBuffer.toString());
                    }*/


                    if(value>0) {

                        String content=new String(bytes);
                        System.out.println(content);
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
