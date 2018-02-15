package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Plateau Echec = new Plateau();
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
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
                    Echec.affichePlateau();
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Veuillez saisir la case :");
                    String caseChoix = scString.nextLine();
                    Case test = Echec.getPieceCase(caseChoix);
                    if(test.getContent()){
                        System.out.println("Case " + caseChoix + " contenant : " + test.getNomAfficher());
                        System.out.print("Veuillez saisir la case cible : ");
                        String caseCible = scString.nextLine();
                        Echec.deplacerPiece(caseChoix, caseCible);
                    } else {
                        System.out.println("La case est vide, recommencez votre choix.");
                    }
                    break;
                default:
                    System.out.println("Erreur, la partie s'arrête");
                    break;
            }
        }while(continuerPartie);


    }
}
