package edu.uqtr.livraison;

/**
 * Employé de l'entreprise qui peut effectuer des livraisons
 */
public class Conducteur {

    /**
     * Nom du conducteur
     */
    private String nom;

    /**
     * Crée un nouveau conducteur en renseignant son nom.
     * @param nom le nom du conducteur.
     */
    public Conducteur(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
