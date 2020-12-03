import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

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
                    lengtes[i] = BoeBot.pulseIn(0, false, 20000);
                }

                // Door de array lopen en de lengtes omzetten 0 of 1
                for (int i = 0; i < 12; i++) {
                    // Waardes omzetten en aan de binary string toevoegen
                    iBinary += getBinary(lengtes[i]);
                }

                // Knop van afstandsbediening ophalen
                iAfstandKnop = getNumberRemote(iBinary);
                // Knop afstandsbediening uitprinten
                System.out.println("Kmop = " + iAfstandKnop);
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
    public static int getNumberRemote(String iBinary) {
        // Switch om de knop te herkennen, -1 als het niet bestaat
        switch (iBinary) {
            case "000000010000": return 1;
            case "100000010000": return 2;
            case "010000010000": return 3;
            case "110000010000": return 4;
            case "001000010000": return 5;
            case "101000010000": return 6;
            case "011000010000": return 7;
            case "111000010000": return 8;
            case "000100010000": return 9;
            case "100100010000": return 0;
            default: return -1;
        }
    }
}
