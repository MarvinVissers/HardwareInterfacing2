import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        System.out.println("Spoorzoeken");

        while (true) {
            // Waarde lijnzoeker ophalen
            int analogeWaarde = BoeBot.analogRead(0);
            BoeBot.wait(100);
            // Waarde uitprinten
            System.out.println("Analoge Waarde = " + analogeWaarde);
            BoeBot.wait(50);
        }
    }
}
