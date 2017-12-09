package edu.eci.arsw.bombermanx.model.game.entities;

/**
 *
 * @author Kevin S. Sanchez
 */
public class Espacio implements Elemento,DejaMover {
    private String key;
    private int posRow;
    private int posCol;

    public Espacio(String key, int posRow, int posCol) {
        this.key = key;
        this.posRow = posRow;
        this.posCol = posCol;
    }

    @Override
    public int getPosRow() {
        return this.posRow;
    }

    @Override
    public void setPosRow(int pos) {
        this.posRow = pos;
    }

    @Override
    public int getPosCol() {
        return this.posCol;
    }

    @Override
    public void setPosCol(int pos) {
        this.posCol = pos;
    }
    
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setKey(String k) {
        this.key = k;
    }
    
    @Override
    public String toString() {
        return "{\"x\":\"" + posCol + "\", \"y\":\"" + posRow + "\", \"key\":\"" + key + "\"}";        
    }
}
