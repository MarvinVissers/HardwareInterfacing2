import TI.BoeBot;
import TI.Servo;

public class RobotMain {
    // Servo motoren defineren
    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    /**
     * Opdracht 5 - A/B
     */
    public static void main(String[] args) {
        // Functie aanspreken met verschillende waardes
        toSpeed(-200);
        toSpeed(200);
        toSpeed(0);
    }

    // Functie om de snelheid van de Boebot aan te passen
    public static void toSpeed(int speed) {
        // Standaard snelheid
        int iDefault = 1500;

        // Als de snelheid hoger is dan 0
        if (speed > 0) {
            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
            for (int i = 0; i < speed; i++) {
                // Nieuwe snelheid op de Boebot zetten
                RobotMain.sLinks.update(iDefault - i);
                RobotMain.sRechts.update(iDefault + i);
                BoeBot.wait(20);
                System.out.println(iDefault + i);
            }
            // Noodrem activeren
            emergencyBrake();
        } else if (speed < 0) {
            // De Boebot achteruit laten rijden
            for (int i = 0; i > speed; i--) {
                // Snelheid op de Boebot
                RobotMain.sLinks.update(iDefault - i);
                RobotMain.sRechts.update(iDefault + i);
                BoeBot.wait(20);
                System.out.println(i);
            }
            // Noodrem activeren
            emergencyBrake();
        } else {
            // Boebot stil laten staan
            RobotMain.sLinks.update(iDefault);
            RobotMain.sRechts.update(iDefault);
        }
    }

    public static void emergencyBrake() {
        // Boebot stil laten staan
        RobotMain.sLinks.update(1500);
        RobotMain.sRechts.update(1500);
    }
}