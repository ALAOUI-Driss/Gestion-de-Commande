package entities;


public class Commande {
    private String _id;
    private String article;
    private String qte;
    private String prix_unit;
    private String prix_total;
    private String client;
    public Commande(){}

    public Commande(String _id, String article, String qte, String prix_unit, String prix_total, String client) {
        this._id = _id;
        this.article = article;
        this.qte = qte;
        this.prix_unit = prix_unit;
        this.prix_total = prix_total;
        this.client = client;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String name) {
        this.article = name;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public String getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(String prix_unit) {
        this.prix_unit = prix_unit;
    }

    public String getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(String prix_total) {
        this.prix_total = prix_total;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "{" +
            " _id='" + get_id() + "'" +
            ", article='" + getArticle() + "'" +
            ", qte='" + getQte() + "'" +
            ", prix_unit='" + getPrix_unit() + "'" +
            ", prix_total='" + getPrix_total() + "'" +
            ", client='" + getClient() + "'" +
            "}";
    }

}
