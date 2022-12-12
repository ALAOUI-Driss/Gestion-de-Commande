package DAO;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Singelton {
    private static MongoClient instance = null;
    public static MongoClient getInstance(){
        if(instance !=null){
            return instance;
        }
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
            instance = new MongoClient(uri);
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}
