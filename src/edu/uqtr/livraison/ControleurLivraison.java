package edu.uqtr.livraison;

/**
 * Contrôleur de la livraison
 */
public class ControleurLivraison {

    /**
     * Carnet de commandes de l'entreprise
     */
    private CarnetCommandes carnetCommandes;

    /**
     * Liste des clients
     */
    private Client[] clients;

    /**
     * Liste des conducteurs
     */
    private Conducteur[] conducteurs;

    /**
     * Liste des coordonnateurs
     */
    private Coordonnateur[] coordonnateurs;

    /**
     * Point d'entrée du système.
     * @param args
     */
    public static void main(String args[]) {
        ControleurLivraison app = new ControleurLivraison();
        app.creerDonneesFictives();

        app.initialisation();

        app.simuler();
    }

    /**
     * Informe tous les coordonnateurs de la livraison d'une commande.
     * @param commande la commande dont l'état a changé.
     */
    public void notifierCoordonnateurs(Commande commande) {
        for(Coordonnateur coordonnateur : coordonnateurs) {
            coordonnateur.notifierLivraison(commande);
        }
    }


    private void initialisation() {
        /**
         * Insérer vos opérations ici
         */
    }

    /**
     * Crée des données pour tester le système.
     */
    private void creerDonneesFictives() {
        clients = new Client[]{
                new Client("Export Rosemont"),
                new Client("Snack chez Raymond"),
                new Client("Entrepot de la patate"),
                new Client("Buffet des oceans")
        };

        Commande[] commandes = new Commande[]{
                new Commande(clients[0], clients[2]),
                new Commande(clients[0], clients[3]),
                new Commande(clients[3], clients[1]),
        };

        carnetCommandes = new CarnetCommandes();
        carnetCommandes.ajouterListe(commandes);

        conducteurs = new Conducteur[]{
                new Conducteur("Aline"),
                new Conducteur("Borris"),
                new Conducteur("Clementine"),
                new Conducteur("Damien")
        };

        coordonnateurs = new Coordonnateur[]{
                new Coordonnateur("Zoe"),
                new Coordonnateur("Yvon"),
                new Coordonnateur("Xavier")
        };
    }

    /**
     * Simule l'assignation de livraison à des conducteurs
     */
    private void simuler() {
        // Aline livre la commande # 2
        carnetCommandes.assignerLivraison(2, conducteurs[0], this);

        // Damien livre la commande #1
        carnetCommandes.assignerLivraison(1, conducteurs[1], this);
    }
}
