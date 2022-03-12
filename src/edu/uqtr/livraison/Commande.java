package edu.uqtr.livraison;

public class Commande {

    private int numero;

    private Client expediteur;

    private Client destinataire;

    private Conducteur livreur;

    public Commande() {
        numero = 0;
    }

    public Commande(Client expediteur, Client destinataire) {
        this();
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }

    public int getNumero() {
        return numero;
    }

    public Client getExpediteur() {
        return expediteur;
    }

    public Client getDestinataire() {
        return destinataire;
    }

    public void setNumero(int numero) {
        if(numero < 1) {
            throw new IllegalArgumentException("Le numéro de commande doit être égal ou supérieur à 1.");
        }

        this.numero = numero;
    }

    public void setLivreur(Conducteur livreur) {
        this.livreur = livreur;
    }

    public String toString() {
        return String.format("Commande %d de %s à %s.", numero, expediteur, destinataire);
    }
}
