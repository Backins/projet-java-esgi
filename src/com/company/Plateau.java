package com.company;
import java.util.*;

class Plateau {
    /* Contient toutes les pièces */
    private HashMap<String, Case> tableau = new HashMap<String, Case>();
    private boolean partieFinie;
    private String[] listeColonne = {"A","B","C","D","E","F","G","H"};
    /*  Permet d'associer à une lettre de colonne un numéro ; ex A = 0*/
    HashMap<String, Integer> mapKeyTableau = new HashMap<String, Integer>();
    /*
        Déclaration des pièces
    */
    //Piece noir (couleur == 0)
    private Pion p1 = new Pion(0);private Pion p2 = new Pion(0);
    private Pion p3 = new Pion(0);private Pion p4 = new Pion(0);
    private Pion p5 = new Pion(0);private Pion p6 = new Pion(0);
    private Pion p7 = new Pion(0);private Pion p8 = new Pion(0);

    private Tour t1 = new Tour(0);private Tour t2 = new Tour(0);
    private Fou f1 = new Fou(0);private Fou f2 = new Fou(0);
    private Cavalier c1 = new Cavalier(0);private Cavalier c2 = new Cavalier(0);
    private Roi r1 = new Roi(0);private Reine d1 = new Reine(0);

    //Pieces blanches (couleur == 1)
    private Pion P1 = new Pion(1);private Pion P2 = new Pion(1);
    private Pion P3 = new Pion(1);private Pion P4 = new Pion(1);
    private Pion P5 = new Pion(1);private Pion P6 = new Pion(1);
    private Pion P7 = new Pion(1);private Pion P8 = new Pion(1);

    private Tour T1 = new Tour(1);private Tour T2 = new Tour(1);
    private Fou F1 = new Fou(1);private Fou F2 = new Fou(1);
    private Cavalier C1 = new Cavalier(1);private Cavalier C2 = new Cavalier(1);
    private Roi R1 = new Roi(1);private Reine D1 = new Reine(1);


    public Plateau(){
        partieFinie = false;
        mapKeyTableau.put("A",0);mapKeyTableau.put("B",1); mapKeyTableau.put("C",2); mapKeyTableau.put("D",3); mapKeyTableau.put("E",4); mapKeyTableau.put("F",5); mapKeyTableau.put("G",6); mapKeyTableau.put("H",7);
    /*
        Affectation des pièces
    */
        // Pieces noires
        tableau.put(listeColonne[0]+2, new Case(p1, "p1"));tableau.put(listeColonne[1]+2, new Case(p2, "p2"));
        tableau.put(listeColonne[2]+2, new Case(p3, "p3"));tableau.put(listeColonne[3]+2, new Case(p4, "p4"));
        tableau.put(listeColonne[4]+2, new Case(p5, "p5"));tableau.put(listeColonne[5]+2, new Case(p6, "p6"));
        tableau.put(listeColonne[6]+2, new Case(p7, "p7"));tableau.put(listeColonne[7]+2, new Case(p8, "p8"));

        tableau.put(listeColonne[0]+1, new Case(t1, "t1"));tableau.put(listeColonne[7]+1, new Case(t2, "t2"));
        tableau.put(listeColonne[1]+1, new Case(c1, "c1"));tableau.put(listeColonne[6]+1, new Case(c2, "c2"));
        tableau.put(listeColonne[2]+1, new Case(f1, "f1"));tableau.put(listeColonne[5]+1, new Case(f2, "f2"));
        tableau.put(listeColonne[3]+1, new Case(r1, "r1"));tableau.put(listeColonne[4]+1, new Case(d1, "d1"));

        for(int i = 0; i<8; i++){
            for(int j=3; j<7; j++){
                tableau.put(listeColonne[i]+j, new Case());
            }
        }

        // Pieces blanches
        tableau.put(listeColonne[0]+7, new Case(P1, "P1"));tableau.put(listeColonne[1]+7, new Case(P2, "P2"));
        tableau.put(listeColonne[2]+7, new Case(P3, "P3"));tableau.put(listeColonne[3]+7, new Case(P4, "P4"));
        tableau.put(listeColonne[4]+7, new Case(P5, "P5"));tableau.put(listeColonne[5]+7, new Case(P6, "P6"));
        tableau.put(listeColonne[6]+7, new Case(P7, "P7"));tableau.put(listeColonne[7]+7, new Case(P8, "P8"));

        tableau.put(listeColonne[0]+8, new Case(T1, "T1"));tableau.put(listeColonne[7]+8, new Case(T2, "T2"));
        tableau.put(listeColonne[1]+8, new Case(C1, "C1"));tableau.put(listeColonne[6]+8, new Case(F2, "C2"));
        tableau.put(listeColonne[2]+8, new Case(F1, "F1"));tableau.put(listeColonne[5]+8, new Case(C2, "F2"));
        tableau.put(listeColonne[3]+8, new Case(R1, "R1"));tableau.put(listeColonne[4]+8, new Case(D1, "D1"));

    }

    public boolean getPartieFinie(){
        return partieFinie;
    }

    public void getPlateau(){
        System.out.println("X-AA-BB-CC-DD-EE-FF-GG-HH-X");
        for(int i=1; i<9;i++){
            System.out.print((i)+"-");
            for(int j=0; j<8;j++){
                System.out.print(tableau.get(listeColonne[j]+i).getNomAffiche()+"-");
            }
            System.out.println(i);
        }
        System.out.println("X-AA-BB-CC-DD-EE-FF-GG-HH-X");
    }

    public Case getPieceCase(String positionCase){
        return tableau.get(positionCase);
    }

    public boolean checkCheminDesire(String caseActuelle, String caseCible){
        int largeurActuelle = mapKeyTableau.get(caseActuelle.substring(0,1));
        int hauteurActuelle = Integer.parseInt(caseActuelle.substring(1));

        int largeurCible = mapKeyTableau.get(caseCible.substring(0,1));
        int hauteurCible = Integer.parseInt(caseCible.substring(1));

        int deplacementLargeur = mapKeyTableau.get(caseCible.substring(0,1)) - mapKeyTableau.get(caseActuelle.substring(0,1));
        int deplacementHauteur = Integer.parseInt(caseCible.substring(1)) - Integer.parseInt(caseActuelle.substring(1));

        if(largeurActuelle == largeurCible && hauteurActuelle == hauteurCible){
            return true;
        }
        if(deplacementHauteur !=0){
            if(deplacementHauteur > 0){
                hauteurActuelle++;
            } else {
                hauteurActuelle--;
            }
        }
        if(deplacementLargeur !=0){
            if(deplacementLargeur > 0){
                largeurActuelle++;
            } else {
                largeurActuelle--;
            }
        }

        if(tableau.get(listeColonne[largeurActuelle]+hauteurActuelle).getContentPiece()){
            return false;
        } else {
            return checkCheminDesire(listeColonne[largeurActuelle]+hauteurActuelle, caseCible);
        }

    }

    public boolean deplacerPiece(String caseChoix, String caseCible){
        int deplacementLargeur = mapKeyTableau.get(caseCible.substring(0,1)) - mapKeyTableau.get(caseChoix.substring(0,1));
        int deplacementHauteur = Integer.parseInt(caseCible.substring(1)) - Integer.parseInt(caseChoix.substring(1));

        int debutLargeur = mapKeyTableau.get(caseChoix.substring(0,1));
        int debutColonne = Integer.parseInt(caseChoix.substring(1));

        String TypePieceChoisi = tableau.get(caseChoix).getNomAffiche().substring(0,1).toUpperCase();
        String TypePieceCible;
        if(tableau.get(caseCible).getContentPiece()){
            TypePieceCible = tableau.get(caseCible).getNomAffiche().substring(0,1).toUpperCase();
        } else{
            TypePieceCible = null;
        }

        if(tableau.get(caseChoix).getPiece().checkLegaliteMouvement(deplacementHauteur, deplacementLargeur)){
            if(checkCheminDesire(caseChoix, caseCible) || TypePieceChoisi.compareToIgnoreCase("C")==0){
                if(deplacementHauteur > 0 && deplacementLargeur > 0) {
                    //A1 vers B2
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        }
                    } else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                        }

                    }
                }
                if(deplacementHauteur > 0 && deplacementLargeur < 0){
                    // B1 vers A2
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        }
                    } else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                        }
                    }
                }
                if(deplacementHauteur < 0 && deplacementLargeur > 0){
                    //A2 vers B1
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        }
                    } else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                        }
                    }
                }
                if(deplacementHauteur < 0 && deplacementLargeur < 0){
                    //B2 vers A1
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("Le déplacement désiré n'est pas autorisé sur cette pièce");
                        }
                        else {
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        }
                    } else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                        }
                    }
                }
                if(deplacementHauteur > 0 && deplacementLargeur == 0){
                    //A1 vers A2
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                                if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                    partieFinie = true;
                                    System.out.println("Echec pour l'adversaire");
                                }
                                tableau.get(caseCible).removePiece();
                                tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                                tableau.get(caseChoix).removePiece();
                            } else{
                                System.out.println("Les pions ne peuvent manger qu'en diagonale");
                            }
                        }
                    } else {
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                }
                if(deplacementHauteur < 0 && deplacementLargeur == 0){
                    //A2 vers A1
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                                if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                    partieFinie = true;
                                    System.out.println("Echec pour l'adversaire");
                                }
                                tableau.get(caseCible).removePiece();
                                tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                                tableau.get(caseChoix).removePiece();
                            } else{
                                System.out.println("Les pions ne peuvent manger qu'en diagonale");
                            }
                        }
                    } else {
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                }
                if(deplacementHauteur == 0 && deplacementLargeur > 0){
                    //A1 vers B1
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                                if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                    partieFinie = true;
                                    System.out.println("Echec pour l'adversaire");
                                }
                                tableau.get(caseCible).removePiece();
                                tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                                tableau.get(caseChoix).removePiece();
                            } else{
                                System.out.println("Les pions ne peuvent manger qu'en diagonale");
                            }
                        }
                    } else {
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                }
                if(deplacementHauteur == 0 && deplacementLargeur < 0){
                    //B1 vers A1
                    if(tableau.get(caseCible).getContentPiece()){
                        if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                            System.out.println("La case est prise par une pièce de la même couleur");
                        }
                        else {
                            if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                                if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                    partieFinie = true;
                                    System.out.println("Echec pour l'adversaire");
                                }
                                tableau.get(caseCible).removePiece();
                                tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                                tableau.get(caseChoix).removePiece();
                            } else{
                                System.out.println("Les pions ne peuvent manger qu'en diagonale");
                            }
                        }
                    } else {
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                }
            } else {
                System.out.println("Piece sur le chemin, veuillez recommencer");
            }
        } else {
            System.out.println("Le déplacement désiré n'est pas autorisé sur cette pièce");
        }
        return true;
    }
}