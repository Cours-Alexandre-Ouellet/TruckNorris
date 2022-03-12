package edu.uqtr.livraison;

/**
 * Client de l'entreprise Truck Norris
 */
public class Client {

    /**
     * Nom du client
     */
    private String nom;

    /**
     * Crée un nouveau client en renseignant son nom.
     * @param nom le nom du client.
     */
    public Client(String nom) {
        this.nom = nom;
    }

    /**
     * Envoie une notification au coordonnateur que l'état d'une commande a changé.
     * @param commande la commande dont l'état a changé.
     */
    public void notifierLivraison(Commande commande) {
        System.out.println(String.format("Le client %s est informe du traitement de la livraison de la commande : %s",
                nom, commande));
    }

    @Override
    public String toString() {
        return nom;
    }
}
