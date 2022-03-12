package edu.uqtr.livraison;

/**
 * Interface de l'observateur
 */
public interface IObservateurCommande {

    /**
     * Réaction lorsqu'un commande est assignée.
     * @param commande la commande dont l'état a changé.
     */
    void onAssignationCommande(Commande commande);

}
