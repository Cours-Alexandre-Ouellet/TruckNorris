package edu.uqtr.livraison;

public class Coordonnateur {

    private String nom;

    public Coordonnateur(String nom) {
        this.nom = nom;
    }

    public void notifierLivraison(Commande commande) {
        System.out.println(String.format("Le coordonateur %s est informe du traitement de la livraison de la commande : %s",
                nom, commande));
    }

}
