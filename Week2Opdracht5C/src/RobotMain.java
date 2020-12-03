import TI.BoeBot;
import TI.Servo;

public class RobotMain {

    // Servo motoren defineren
    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    public static void main(String[] args) {
        BoeBot.wait(5000);
        // Functie aanspreken met verschillende waardes
        turn(-200);
        turn(200);
        turn(0);
    }

    // Functie om de snelheid van de Boebot aan te passen
    public static void turn(int turningSpeed) {
        // Standaard snelheid
        int iDefault = 1500;

        // Als de snelheid hoger is dan 0
        if (turningSpeed > 0) {
            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
            for (int i = 0; i < turningSpeed; i++) {
                // Nieuwe snelheid op de Boebot zetten
                RobotMain.sRechts.update(iDefault + i);
                BoeBot.wait(20);
                System.out.println(iDefault + i);
            }
            // Noodrem activeren
            emergencyBrake();
        } else if (turningSpeed < 0) {
            // De Boebot achteruit laten rijden
            for (int i = 0; i > turningSpeed; i--) {
                // Snelheid op de Boebot
                RobotMain.sLinks.update(iDefault + turningSpeed);
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

        BoeBot.wait(1000);
    }
}
