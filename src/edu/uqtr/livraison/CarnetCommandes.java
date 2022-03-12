package edu.uqtr.livraison;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Liste des commandes de l'entreprise.
 */
public class CarnetCommandes {

    /**
     * Liste des observateurs de commandes
     */
    private ArrayList<IObservateurCommande> observateursCommande;

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
        observateursCommande = new ArrayList<>();
    }

    /**
     * Ajoute un nouvel observateur d'état de commande
     * @param observateur
     */
    public void ajouterObservateurCommande(IObservateurCommande observateur){
        // Évite les ajout en double.
        if(!observateursCommande.contains(observateur)) {
            observateursCommande.add(observateur);
        }
    }

    /**
     * Retire un des observateurs d'état de commande
     * @param observateur
     */
    public void retirerObservateurCommande(IObservateurCommande observateur) {
        // Évite le déclenchement d'une exception si l'objet n'est pas dans la liste.
        if(!observateursCommande.contains(observateur)) {
            observateursCommande.remove(observateur);
        }
    }

    /**
     * Notifie les observateurs d'un changement
     * @param commande
     */
    private void notifier(Commande commande){
        for(IObservateurCommande obs : observateursCommande) {
            obs.onAssignationCommande(commande);
        }
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
     */
    public void assignerLivraison(int numeroCommande, Conducteur conducteur) {
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
            notifier(commandeLivree);
        } else {
            System.err.println(String.format("Impossible d'assigner la commande #", numeroCommande));
        }


    }

}
