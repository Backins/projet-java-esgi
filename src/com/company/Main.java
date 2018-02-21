package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Plateau Echec = new Plateau();
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        int tourDuJoueur = 0;
        boolean continuerPartie = true;
        int choixMenu;

        do{
            System.out.println("0. Stopper la partie");
            System.out.println("1. Voir le tableau");
            System.out.println("2. Choisir une case");
            System.out.print("Choix du menu (valeur entiere): ");
            choixMenu = scInt.nextInt();
            switch (choixMenu){
                case 0:
                    continuerPartie = false;
                    break;
                case 1:
                    System.out.println("");
                    Echec.getPlateau();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    if(tourDuJoueur%2 == 0){
                        System.out.println("Tour du joueur 1 : Pièce blanc");
                    } else{
                        System.out.println("Tour du joueur 2 : Pièce noire");
                    }
                    System.out.println("");
                    tourDuJoueur++;
                    System.out.print("Veuillez saisir la case :");
                    String caseChoix = scString.nextLine();
                    Case caseSelection = Echec.getPieceCase(caseChoix);
                    if(caseSelection.getContentPiece()){
                        System.out.println("Case " + caseChoix + " contenant : " + caseSelection.getNomAffiche());
                        System.out.print("Veuillez saisir la case cible : ");
                        String caseCible = scString.nextLine();

                        Echec.deplacerPiece(caseChoix, caseCible);
                        System.out.println("++++++++++++++++++++++++++");
                        System.out.println("+    Etat du Plateau     +");
                        Echec.getPlateau();
                        System.out.println("+    Etat du Plateau     +");
                        System.out.println("++++++++++++++++++++++++++");
                    } else {
                        System.out.println("La case est vide, retour au menu");
                    }
                    System.out.println("");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Erreur, la partie s'arrête");
                    break;
            }
        }while(continuerPartie);
    }
}
