package element.solve;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.Date;

/**
 * @author Hanz
 * @date 2019/8/22
 */
public class testDocument {
    public static void main(String[] args){
        MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
        MongoDatabase db = mongoClient.getDatabase("test");

        BsonDocument document = new BsonDocument();
        document.put("name", "Sony");
        document.put("age", 30);
        document.put("createdDate", new Date());
        db.getCollection("tes123").insertOne(document);
    }

}
