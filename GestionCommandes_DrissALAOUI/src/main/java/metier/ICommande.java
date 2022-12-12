package metier;


import java.util.List;

import entities.Commande;

public interface ICommande {
    Commande findById(String _id);
    List<Commande> findAll();
    void delete(String _id);
    void update(Commande ma_commande);
    void save(Commande ma_commande);
}
