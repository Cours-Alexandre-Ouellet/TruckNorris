package edu.uqtr.livraison;

import java.util.ArrayList;

public class CarnetCommandes {

    private int compteurCommande;

    private ArrayList<Commande> commandes;

    public CarnetCommandes() {
        compteurCommande = 1;
        commandes = new ArrayList<>();
    }

    public void ajouterListe(Commande ... commandes) {
        for(Commande c : commandes) {
            ajouter(c);
        }
    }

    public void ajouter(Commande commande) {
        commande.setNumero(compteurCommande++);
        commandes.add(commande);
    }

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
             * Code à supprimer
             */
            controleurLivraison.notifierCoordonnateurs(commandeLivree);
            commandeLivree.getExpediteur().notifierLivraison(commandeLivree);
            commandeLivree.getDestinataire().notifierLivraison(commandeLivree);

        } else {
            System.err.println(String.format("Impossible d'assigner la commande #", numeroCommande));
        }
    }

}
