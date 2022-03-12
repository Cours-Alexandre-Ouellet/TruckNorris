package edu.uqtr.livraison;

public class ControleurLivraison {

    private CarnetCommandes carnetCommandes;

    private Client[] clients;

    private Conducteur[] conducteurs;

    private Coordonnateur[] coordonnateurs;

    public static void main(String args[]) {
        ControleurLivraison app = new ControleurLivraison();
        app.creerDonneesFictives();

        app.initialisation();

        app.simuler();
    }

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

    private void simuler() {
        // Aline livre la commande # 2
        carnetCommandes.assignerLivraison(2, conducteurs[0], this);

        // Damien livre la commande #1
        carnetCommandes.assignerLivraison(1, conducteurs[1], this);
    }
}
