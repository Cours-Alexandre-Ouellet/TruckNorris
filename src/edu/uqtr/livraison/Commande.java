package edu.uqtr.livraison;

/**
 * Commande passée par un client de l'entreprise Truck Norris.
 */
public class Commande {

    /**
     * Numero de la commande
     */
    private int numero;

    /**
     * Expéditeur de la commande
     */
    private Client expediteur;

    /**
     * Destinataire de la commande
     */
    private Client destinataire;

    /**
     * Conducteur effectuant la livraions
     */
    private Conducteur livreur;

    /**
     * Crée un nouvelle commande vide
     */
    public Commande() {
        numero = 0;
    }

    /**
     * Crée un nouvelle commande dont on connait l'expéditeur et le destinataire.
     * @param expediteur l'expéditeur de la commande.
     * @param destinataire le destinataire de la commande.
     */
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

    /**
     * Affecte un numéro à la commande. Celui-ci doit être plus grand ou égal à 1.
     * @param numero le numéro de la commande.
     * @throws IllegalArgumentException si le numéro de commande est 0 ou négatif.
     */
    public void setNumero(int numero) {
        if(numero < 1) {
            throw new IllegalArgumentException("Le numéro de commande doit être égal ou supérieur à 1.");
        }

        this.numero = numero;
    }

    public void setLivreur(Conducteur livreur) {
        this.livreur = livreur;
    }

    @Override
    public String toString() {
        return String.format("Commande %d de %s à %s.", numero, expediteur, destinataire);
    }
}
