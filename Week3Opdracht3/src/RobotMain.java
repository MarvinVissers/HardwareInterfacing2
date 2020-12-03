import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    // Servo motoren defineren
    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    public static void main(String[] args) {
        System.out.println("starten...");

        BoeBot.wait(5000);

        toSpeed(200);

        while (true) {
            // Geluid versturen
            BoeBot.digitalWrite(0, true);
            BoeBot.wait(1);
            BoeBot.digitalWrite(0, false);

            // Tijd die het duurt ontvangen
            int pulseLength = BoeBot.pulseIn(1, true, 10000) / 58;

            // Kijken of er een object in de buurt is
            if (pulseLength <= 20) {
                // Boebot achteruit rijden
                toSpeed(-125);
                // boebot omdraaien
                turnDegrees(180, 50);
                // Boebot weer laten rijden
                toSpeed(200);
            }
            BoeBot.wait(50);
        }
    }

    public static void toSpeed(int speed) {
        // Standaard snelheid
        int iDefault = 1500;

        // Als de snelheid hoger is dan 0
        if (speed > 0) {
            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
            for (int i = 0; i < speed; i++) {
                // Nieuwe snelheid op de Boebot zetten
                sLinks.update(iDefault - i);
                sRechts.update(iDefault + i);
                BoeBot.wait(20);
            }
        } else if (speed < 0) {
            // De Boebot achteruit laten rijden
            for (int i = 0; i > speed; i--) {
                // Snelheid op de Boebot
                sLinks.update(iDefault - i);
                sRechts.update(iDefault + i);
                BoeBot.wait(20);
            }
        }
    }

    public static void turnDegrees(int degrees, int turningSpeed) {
        // kijken of het getal groter is dan 0
        if (turningSpeed > 0){
            // Tijd om te draaien bereken
            int timePerDegree = 420 / turningSpeed;

            // Boebot laten draaien
            sLinks.update(1500 + turningSpeed);
            sRechts.update(1500 + turningSpeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * degrees);
        } else if (turningSpeed < 0) {
            // Negatieve snelheid omdraaien naar positieve snelheid
            turningSpeed = Math.abs(turningSpeed);

            // Tijd om te draaien bereken
            int timePerDegree = 400 / turningSpeed;

            // Boebot laten draaien
            sLinks.update(1500 - turningSpeed);
            sRechts.update(1500 - turningSpeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * degrees);
        }

        emergencyBrake();
    }

    public static void emergencyBrake() {
        // Boebot stil laten staan
        sLinks.update(1600);
        sRechts.update(1400);

        sLinks.update(1500);
        sRechts.update(1500);
    }
}
