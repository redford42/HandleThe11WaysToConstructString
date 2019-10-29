package element.solve;

import org.bson.Document;

import java.util.Map;

/**
 * @author Hanz
 * @date 2019/8/22
 */
public class BsonDocument extends Document {

    public BsonDocument() {
        super();
    }

    public BsonDocument(Map<String, Object> map) {
        super(map);
    }

    public BsonDocument(String key, Object value){
        super(key, value);
    }
}
