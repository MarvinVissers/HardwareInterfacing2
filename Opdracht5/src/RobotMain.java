import TI.BoeBot;
import TI.Servo;
import TI.Timer;

public class RobotMain {
    // Servo motoren defineren
    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    /**
     * Opdracht 5 - A/B
     */
//    public static void main(String[] args) {
//        // Functie aanspreken met verschillende waardes
//        toSpeed(-200);
//        toSpeed(200);
//        toSpeed(0);
//    }
//
//    // Functie om de snelheid van de Boebot aan te passen
//    public static void toSpeed(int speed) {
//        // Standaard snelheid
//        int iDefault = 1500;
//
//        // Als de snelheid hoger is dan 0
//        if (speed > 0) {
//            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
//            for (int i = 0; i < speed; i++) {
//                // Nieuwe snelheid op de Boebot zetten
//                RobotMain.sLinks.update(iDefault - i);
//                RobotMain.sRechts.update(iDefault + i);
//                BoeBot.wait(20);
//                System.out.println(iDefault + i);
//            }
//            // Noodrem activeren
//            emergencyBrake();
//        } else if (speed < 0) {
//            // De Boebot achteruit laten rijden
//            for (int i = 0; i > speed; i--) {
//                // Snelheid op de Boebot
//                RobotMain.sLinks.update(iDefault - i);
//                RobotMain.sRechts.update(iDefault + i);
//                BoeBot.wait(20);
//                System.out.println(i);
//            }
//            // Noodrem activeren
//            emergencyBrake();
//        } else {
//            // Boebot stil laten staan
//            RobotMain.sLinks.update(iDefault);
//            RobotMain.sRechts.update(iDefault);
//        }
//    }
//
//    public static void emergencyBrake() {
//        // Boebot stil laten staan
//        RobotMain.sLinks.update(1500);
//        RobotMain.sRechts.update(1500);
//    }

    /**
     * Opdracht 5 - C
     */
//    public static void main(String[] args) {
//        BoeBot.wait(5000);
//        // Functie aanspreken met verschillende waardes
//        turn(-200);
//        turn(200);
//        turn(0);
//    }
//
//    // Functie om de snelheid van de Boebot aan te passen
//    public static void turn(int turningSpeed) {
//        // Standaard snelheid
//        int iDefault = 1500;
//
//        // Als de snelheid hoger is dan 0
//        if (turningSpeed > 0) {
//            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
//            for (int i = 0; i < turningSpeed; i++) {
//                // Nieuwe snelheid op de Boebot zetten
//                RobotMain.sRechts.update(iDefault + i);
//                BoeBot.wait(20);
//                System.out.println(iDefault + i);
//            }
//            // Noodrem activeren
//            emergencyBrake();
//        } else if (turningSpeed < 0) {
//            // De Boebot achteruit laten rijden
//            for (int i = 0; i > turningSpeed; i--) {
//                // Snelheid op de Boebot
//                RobotMain.sLinks.update(iDefault + turningSpeed);
//                BoeBot.wait(20);
//                System.out.println(i);
//            }
//            // Noodrem activeren
//            emergencyBrake();
//        } else {
//            // Boebot stil laten staan
//            RobotMain.sLinks.update(iDefault);
//            RobotMain.sRechts.update(iDefault);
//        }
//    }
//
//    public static void emergencyBrake() {
//        // Boebot stil laten staan
//        RobotMain.sLinks.update(1500);
//        RobotMain.sRechts.update(1500);
//
//        BoeBot.wait(1000);
//    }

    /**
     * Opdracht 5 - D
     */
    public static void main(String[] args) {
        // Even wachten zodat ik de Boebot op de grond kan zetten
        BoeBot.wait(10000);

        while(true) {
            // Functie aanspreken met verschillende waardes
            turnDegrees(90, 25);
            turnDegrees(270, 75);
            turnDegrees(60, -50);
        }
    }

    public static void turnDegrees(int degrees, int turningSpeed) {
        // kijken of het getal groter is dan 0
        if (turningSpeed > 0){
            // Tijd om te draaien bereken
            int timePerDegree = 400 / turningSpeed;

            // Boebot laten draaien
            RobotMain.sLinks.update(1500 + turningSpeed);
            RobotMain.sRechts.update(1500 + turningSpeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * degrees);

            // Boebot stoppen
            emergencyBrake();
        } else if (turningSpeed < 0) {
            // Negatieve snelheid omdraaien naar positieve snelheid
            turningSpeed = Math.abs(turningSpeed);

            // Tijd om te draaien bereken
            int timePerDegree = 400 / turningSpeed;

            // Boebot laten draaien
            RobotMain.sLinks.update(1500 - turningSpeed);
            RobotMain.sRechts.update(1500 - turningSpeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * degrees);

            // Boebot stoppen
            emergencyBrake();
        }
    }

    public static void emergencyBrake() {
        // Boebot stil laten staan
        RobotMain.sLinks.update(1500);
        RobotMain.sRechts.update(1500);

        BoeBot.wait(1000);
    }
}