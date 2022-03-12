package edu.uqtr.livraison;

import java.util.ArrayList;

/**
 * Liste des commandes de l'entreprise.
 */
public class CarnetCommandes {

    /**
     * Numéro séquentiel de commandes
     */
    private int compteurCommande;

    /**
     * Liste des commandes
     */
    private ArrayList<Commande> commandes;

    /**
     * Crée un nouveau carnet de commande vide.
     */
    public CarnetCommandes() {
        compteurCommande = 1;
        commandes = new ArrayList<>();
    }

    /**
     * Ajoute une liste de commandes au carnet.
     * @param commandes la liste des commandes à ajouter.
     */
    public void ajouterListe(Commande ... commandes) {
        for(Commande c : commandes) {
            ajouter(c);
        }
    }

    /**
     * Ajoute une commande au carnet de commandes.
     * @param commande la commande à ajouter.
     */
    public void ajouter(Commande commande) {
        commande.setNumero(compteurCommande++);
        commandes.add(commande);
    }

    /**
     * Assigne une commande à un conducteur (la commande devient alors une livraison).
     * @param numeroCommande le numéro de la commande à assigner.
     * @param conducteur le conducteur à qui assigner la livraison.
     * @param controleurLivraison le contrôleur de livraison. (Supprimez ce paramètre !)
     */
    public void assignerLivraison(int numeroCommande, Conducteur conducteur, ControleurLivraison controleurLivraison) {
        Commande commandeLivree = null;

        for(Commande commande : commandes) {
            if(commande.getNumero() == numeroCommande) {
                commandeLivree = commande;
                break;      // On a trouvée la commande, pas besoin de continuer
            }
        }

        // Pour les amateurs de lambda, on peut remplacer la boucle par l'instruction suivante
        //commandeLivree = commandes.stream().filter(c -> c.getNumero() == numeroCommande).findFirst().orElse(null);

        if(commandeLivree != null) {
            commandeLivree.setLivreur(conducteur);

            /**
             * Code à supprimer / réécrire !
             */
            controleurLivraison.notifierCoordonnateurs(commandeLivree);
            commandeLivree.getExpediteur().notifierLivraison(commandeLivree);
            commandeLivree.getDestinataire().notifierLivraison(commandeLivree);

        } else {
            System.err.println(String.format("Impossible d'assigner la commande #", numeroCommande));
        }
    }

}
