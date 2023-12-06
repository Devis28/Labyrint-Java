import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labyrint {
    private int dlzka = 20;
    private int vyska = 20;
    private final char stena = '#';
    private char[][] bludisko = new char[this.dlzka][this.vyska];

    Player p = new Player('O', 10, 2);

    public int getDlzka() {
        return dlzka;
    }

    public void setDlzka(int dlzka) {
        this.dlzka = dlzka;
    }

    public int getVyska() {
        return vyska;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
    }

    public char getStena() {
        return stena;
    }

    public char[][] getBludisko() {
        return bludisko;
    }

    public void setBludisko(char[][] bludisko) {
        this.bludisko = bludisko;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Labyrint(String file) {
        int index = 0;
        String riadok = "";
        BufferedReader bR = null;
        try {
            bR = new BufferedReader(new FileReader(file));
            do {
                riadok = bR.readLine();

                if (riadok != null) {
                    System.out.println(riadok);

                    for (int i = 0; i < bludisko[index].length; i++) {
                        bludisko[index][i] = riadok.charAt(i);
                    }
                    index++;
                }
            } while (riadok != null);
            bR.close();
        } catch (FileNotFoundException e) {
            System.out.println("nenasiel som subor");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        p.setPosition(10, 2);
    }

    public String showLabyrint() {
        String output = "";
        for (int i = 0; i < bludisko.length; i++) {
            for (int j = 0; j < bludisko[i].length; j++) {
                if (j == 19) {
                    output += bludisko[i][j];
                    output += "\n";

                }
                else output += bludisko[i][j];

            }
        }
        return output.substring(0, output.length()-1);
    }

    public void updateLabyrint(String znak) {
        if (znak.length() == 1) {
            char z = znak.charAt(0);
            if (z == 'd') {
                if (bludisko[p.getY()][p.getX()+1] == ' ') {
                    bludisko[p.getY()][p.getX()+1] = '0';
                    bludisko[p.getY()][p.getX()] = ' ';
                    p.setX(p.getX()+1);
                }
            }
            else if (z == 'a') {
                if (bludisko[p.getY()][p.getX()-1] == ' ') {
                    bludisko[p.getY()][p.getX()-1] = 'O';
                    bludisko[p.getY()][p.getX()] = ' ';
                    p.setX(p.getX()-1);
                }
            }
            else if (z == 'w') {
                if (bludisko[p.getY()-1][p.getX()] == ' ') {
                    bludisko[p.getY()-1][p.getX()] = '0';
                    bludisko[p.getY()][p.getX()] = ' ';
                    p.setY(p.getY()-1);
                }
            }
            else if (z == 's') {
                if (bludisko[p.getY()+1][p.getX()] == ' ') {
                    bludisko[p.getY()+1][p.getX()] = '0';
                    bludisko[p.getY()][p.getX()] = ' ';
                    p.setY(p.getY()+1);
                }
            }
        }
        else {
            System.out.println("w --> hore\ns --> dole\na --> vľavo\nd --> vpravo");
        }
    }
}
