import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Labyrint l = new Labyrint("scene_01.txt");
        Scanner input = new Scanner(System.in);
        String ovladanie;
        do {
            ovladanie = input.next();
            l.updateLabyrint(ovladanie);
            System.out.println(l.showLabyrint());
        } while (l.p.getY() != 19);
        System.out.println("! ! !Gratulujem! ! !\n    Vyhrali ste!");
    }
}
