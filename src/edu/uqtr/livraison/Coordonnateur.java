package edu.uqtr.livraison;

/**
 * Employé de l'entreprise en charge de la coordination.
 */
public class Coordonnateur {

    /**
     * Nom du coordonnateur
     */
    private String nom;

    /**
     * Crée un nouveau coordonnateur en renseignant son nom.
     * @param nom le nom du coordonnateur.
     */
    public Coordonnateur(String nom) {
        this.nom = nom;
    }

    /**
     * Envoie une notification au coordonnateur que l'état d'une commande a changé.
     * @param commande la commande dont l'état a changé.
     */
    public void notifierLivraison(Commande commande) {
        System.out.println(String.format("Le coordonateur %s est informe du traitement de la livraison de la commande : %s",
                nom, commande));
    }

}
