import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    // Servo motoren defineren
    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    public static void main(String[] args) {

        // Starten met luisteren
        System.out.println("Luisteren");

        while (true) {
            // Maken van variabele voor de binary die uit de knop komt
            String iBinary = "";
            // Maken van variabele voor de knop van de afstandsbediening
            int iAfstandKnop ;

            // Pulse van afstandsbediening ophalen
            int PulseLength = BoeBot.pulseIn(0, false, 6000);
            // Kijken of de lengte niet te hoog is
            if (PulseLength > 2000) {
                // Variabele aanmaken voor de waardes uit de pulselengte
                int lengtes[] = new int[12];

                // Door de waardes lopen en in de array zetten
                for (int i = 0; i < 12; i++) {
                    // Waardes in de Array zetten
                    lengtes[i] = BoeBot.pulseIn(0, false, 20000);
                    // Waardes omzetten en aan de binary string toevoegen
                    iBinary += getBinary(lengtes[i]);
                }

                // Actie op de boebot zetten
                getNumberRemote(iBinary);
            }
            // Even wachten
            BoeBot.wait(10);
        }
    }

    /**
     * Functie om puslewaardes om te zetten
     * @param iPulseIn de pulswaarde
     * @return 0 als het onder de 1000 is
     * @return 1 als het boven de 1000 is
     */
    public static int getBinary(int iPulseIn) {
        // Kijken of de pulse waarde boven of onder de 1000 is
        if (iPulseIn > 1000) {
            // Groter als 1000
            return 1;
        } else {
            // Kleiner als 1000
            return 0;
        }
    }

    /**
     * Functie om de knop van de afstandsbediening te herkennen
     * @param iBinary de binary string
     * @return De knop van de afstandsbediening.
     * @return -1 als het ongelding is
     */
    public static void getNumberRemote(String iBinary) {
        // Switch om de knop te herkennen, -1 als het niet bestaat
        switch (iBinary) {
            // Knop = 1
            case "000000010000":
                turn(50);
                toSpeed(200);
                break;
            // Knop = 2
            case "100000010000":
                toSpeed(200);
                break;
            // Knop = 3
            case "010000010000":
                turn(-50);
                toSpeed(200);
                break;
            // Knop = 4
            case "110000010000":
                turnDegrees(45, 50);
                break;
            // Knop = 5
            case "001000010000":
                emergencyBrake();
                break;
            // Kmop = 6
            case "101000010000":
                turnDegrees(315, 50);
                break;
            // Knop = 7
            case "011000010000":
                turnDegrees(45, -50);
            // Knop = 8
            case "111000010000":
                toSpeed(-200);
            // Kmop = 9
            case "000100010000":
                turnDegrees(315, -50);
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


    public static void turn(int turningSpeed) {
        // Standaard snelheid
        int iDefault = 1500;

        // Als de snelheid hoger is dan 0
        if (turningSpeed > 0) {
            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
            for (int i = 0; i < turningSpeed; i++) {
                // Nieuwe snelheid op de Boebot zetten
                sRechts.update(iDefault + i);
                BoeBot.wait(20);
            }
        } else if (turningSpeed < 0) {
            // De Boebot achteruit laten rijden
            for (int i = 0; i > turningSpeed; i--) {
                // Snelheid op de Boebot
                RobotMain.sLinks.update(iDefault + turningSpeed);
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
            RobotMain.sLinks.update(1500 + turningSpeed);
            RobotMain.sRechts.update(1500 + turningSpeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * degrees);
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
