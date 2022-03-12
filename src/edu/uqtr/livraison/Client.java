package edu.uqtr.livraison;

public class Client {

    private String nom;

    public Client(String nom) {
        this.nom = nom;
    }

    public void notifierLivraison(Commande commande) {
        System.out.println(String.format("Le client %s est informe du traitement de la livraison de la commande : %s",
                nom, commande));
    }

    public String toString() {
        return nom;
    }
}
