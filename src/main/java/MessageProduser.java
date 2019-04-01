import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MessageProduser {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("user");
        factory.setPassword("user");
        factory.setVirtualHost("/");
        factory.setHost("192.168.2.141");
        factory.setPort(5672);
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        String exhangeName = "amq.direct";
        String routingKey = "testRoute";

        for (int i =1 ; i<100; i ++){
            byte [] messageBodyBytes = ("test" +i).getBytes();
            channel.basicPublish(exhangeName,routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
        }
channel.close();
conn.close();

    }



    }

