package org.example;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        // Ajouter des secteurs
        zoo.ajouterSecteur(TypeAnimal.CHIEN);
        zoo.ajouterSecteur(TypeAnimal.CHAT);

        // Ajouter des animaux
        zoo.nouvelAnimal(new Chien("bob") );
        zoo.nouvelAnimal(new Chat("Mimi"));

        // Ajouter des visiteurs
        try {
            for (int i = 0; i < 31; i++) {
                zoo.nouveauVisiteur();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Afficher le nombre d'animaux et de visiteurs
        System.out.println("Nombre d'animaux dans le zoo : " + zoo.nombreAnimaux());
        System.out.println("Nombre de visiteurs dans le zoo : " + zoo.getNombreVisiteurs());







    }
}