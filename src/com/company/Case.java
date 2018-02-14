package com.company;

public class Case {
    private boolean content;
    private Piece piece;
    private String nomAfficher;

    public Case() {
        content = false;
        nomAfficher = "  ";
    }

    public Case(Piece pNomPiece, String pNomAfficher) {
        content = true;
        piece = pNomPiece;
        nomAfficher = pNomAfficher;
    }

    public String getNomAfficher() {
        return nomAfficher;
    }
    public boolean getContent(){
        return content;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece pPiece, String pNomAfficher){
        piece = pPiece;
        nomAfficher = pNomAfficher;
        content = true;
    }
    public void removePiece(){
        piece = null;
        nomAfficher = "  ";
        content = false;
    }
}
