import java.util.Scanner;

public class FreitagUebung {
    public static void main(String[] args) {
        eingabe();
    }

    // Passwort festsetzen
    public static void eingabe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib dein Passwort ein.");
        String a = scanner.nextLine();
        while (!(pruefungzahlen(a)) || pruefunglaenge(a) || leerz(a) || schlecht(a) || !buchstaben(a)) {
            if (leerz(a)) {
                System.out.println("Schreibe dein Passwort bitte ohne Leerzeichen.");
                a = scanner.nextLine();
            }
            else if (pruefunglaenge(a)) {
                System.out.println("Dein Passwort muss mind. 5 Zeichen lang sein. Bitte erneut eingeben.");
                a = scanner.nextLine();
            }
            else if (!pruefungzahlen(a)){
                    System.out.println("Dein Passwort muss Zahlen umfassen.");
                    a = scanner.nextLine();
                }
            else if (schlecht(a)) {
                System.out.println("Dein Passwort ist leicht zu erraten! Wähle ein schwierigeres Passwort!");
                a = scanner.nextLine();
            }
            else if (!buchstaben(a)) {
                System.out.println("Dein Passwort soll Groß- als auch Kleinbuchstaben enthalten!");
                a = scanner.nextLine();
            }
            }
        eingabe2(a);
    }
    // Checke, ob kleine/große Buchstaben enthalten sind
    public static boolean buchstaben (String a) {
        boolean großundklein = false;
        int gross = 0;
        int klein = 0;
        for (int i=0; i < a.length(); i++) {
            if ((gross >= 1) && (klein >= 1)) {
                großundklein = true;
                break;
            }
            else if (Character.isUpperCase(a.charAt(i))) {
                gross++;
            }
            else if (Character.isLowerCase(a.charAt(i))) {
                klein++;
            }
        }
        return großundklein;
    }

    // Schlechtes Passwort
    public static boolean schlecht(String a){
        return switch (a) {
            case    "123456",
                    "123456789",
                    "qwerty",
                    "Passwort",
                    "password",
                    "1234567",
                    "12345678",
                    "12345",
                    "iloveyou",
                    "111111",
                    "123123" -> true;
            default -> false;
        };
    }

    // Prüfen, ob Zahlen enthalten sind
    public static boolean leerz(String a){
        boolean leer = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                leer = true;
                break;
            }
        }
        return leer;
    }

    // String eine Mindestlänge von 5?
    public static boolean pruefunglaenge(String a) {
        return (a.length() < 5);
    }

    // Prüfen, ob Zahlen enthalten sind
    public static boolean pruefungzahlen(String a){
        boolean zahlda = false;
        for (char c : a.toCharArray()) {
            if (Character.isDigit(c) != zahlda) {
                zahlda = true;
                break;
            }
        }
    return zahlda;
    }

    // Passwort nochmal eingeben
    // Passwörter nochmals miteinander vergleichen
    public static void eingabe2(String a) {
        Scanner scanner = new Scanner(System.in);
        char[] c = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            c[i] = '_';
            System.out.print(c[i]);
        }
        System.out.println();
        System.out.println("Bitte gib dein Passwort zur Validierung nochmal ein.");
        String b = scanner.nextLine();
        while (!b.equals(a)) {
            System.out.println("Das Passwort ist falsch. Bitte nochmal eingeben.");
            b = scanner.nextLine();
        }
        System.out.println("Du hast das Passwort erfolgreich wiederholt.");
    }
    }