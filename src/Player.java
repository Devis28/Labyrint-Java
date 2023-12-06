public class Player {
    private final char hrac = 'O';
    private int x = 10;
    private int y = 3;

    /*public char getHrac() {
        return hrac;
    }

    public void setHrac(char hrac) {
        this.hrac = hrac;
    }*/

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player(char hrac, int x, int y) {
        setX(x);
        setY(y);
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
}
