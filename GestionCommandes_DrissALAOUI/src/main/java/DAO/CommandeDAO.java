package DAO;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import entities.Commande;
import metier.ICommande;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class CommandeDAO implements ICommande{
    private final MongoClient client = Singelton.getInstance();
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;
    public CommandeDAO(){
        mongoDatabase = client.getDatabase("my_db");
        mongoCollection = mongoDatabase.getCollection("commandes");
    }
    @Override
    public Commande findById(String _id) {
        Commande ma_commande = new Commande();
        Document mongoCursor = mongoCollection.find(new Document("_id",new ObjectId(_id))).first();
        if (mongoCursor != null){
            ma_commande.set_id(mongoCursor.get("_id").toString());
            ma_commande.setArticle((String) mongoCursor.get("article"));
            ma_commande.setQte((String) mongoCursor.get("qte"));
            ma_commande.setPrix_total((String) mongoCursor.get("prix_total"));
            ma_commande.setPrix_unit((String) mongoCursor.get("prix_unit"));
            ma_commande.setClient((String) mongoCursor.get("client")) ;

        }
        return ma_commande;
    }

    @Override
    public List<Commande> findAll() {
        MongoCursor<Document> cursor = mongoCollection.find().iterator();
        List<Commande>mes_commandes = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                mes_commandes.add(parseDocument(cursor.next()));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return mes_commandes;
    }

    @Override
    public void delete(String _id) {
        mongoCollection.deleteOne(new Document("_id",new ObjectId(_id)));
    }

    @Override
    public void update(Commande ma_commande) {
        mongoCollection.updateOne(
                new Document("_id",new ObjectId(ma_commande.get_id())),
                new Document("$set",createDBObject(ma_commande))
        );
    }

    @Override
    public void save(Commande ma_commande) {
        System.out.println(ma_commande);
        mongoCollection.insertOne(createDBObject(ma_commande));
    }

    private Document createDBObject(Commande ma_commande) {
        Document docBuilder = new Document();
        docBuilder.append("article",ma_commande.getArticle());
        docBuilder.append("qte",ma_commande.getQte());
        docBuilder.append("prix_unit",ma_commande.getPrix_unit());
        docBuilder.append("prix_total",ma_commande.getPrix_total());
        docBuilder.append("client",ma_commande.getClient());
        return docBuilder;
    }
    private Commande parseDocument(Document document){
        if(document == null){
            return null;
        }
        final Commande ma_commande = new Commande();
        ma_commande.set_id(document.getObjectId("_id").toString());
        ma_commande.setArticle(document.getString("article"));
        ma_commande.setQte(document.getString("qte"));
        ma_commande.setPrix_total(document.getString("prix_total"));
        ma_commande.setPrix_unit(document.getString("prix_unit"));
        ma_commande.setClient(document.getString("client"));
        return ma_commande;
    }
}
