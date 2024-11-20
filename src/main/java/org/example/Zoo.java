package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int visiteurs;
    private List<Secteur> secteursAnimaux;
    private int nbVisiteurMaxParSecteur = 15;

    public Zoo() {
        this.visiteurs = 0;
        this.secteursAnimaux = new ArrayList<>();
    }

    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }

    public void nouveauVisiteur() {
        if (visiteurs >= secteursAnimaux.size() * nbVisiteurMaxParSecteur) {
            throw new RuntimeException("Limite de visiteurs atteinte !");
        }
        visiteurs++;
    }

    public int getNombreVisiteurs() {
        return visiteurs;
    }

    public void nouvelAnimal(Animal animal) {
        for (Secteur secteur : secteursAnimaux) {
            if (secteur.obtenirType() == animal.getTypeAnimal()) {
                secteur.ajouterAnimal(animal);
                return;
            }
        }
        throw new RuntimeException("Aucun secteur pour ce type d'animal !");
    }

    public int nombreAnimaux() {
        return secteursAnimaux.stream().mapToInt(Secteur::getNombreAnimaux).sum();
    }
}
