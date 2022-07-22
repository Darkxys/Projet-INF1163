public class Unite {
    private String identifiant;
    private String adresse;
    // On stocke le prix en int (cents) car les nombre flotants peuvent être imprécis
    private int prix_base_cents;

    public String getIdentifiant() {
        return this.identifiant;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public float getPrix() {
        return (float)this.prix_base_cents / 100;
    }
}
