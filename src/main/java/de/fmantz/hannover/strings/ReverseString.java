package de.fmantz.hannover.strings;

public class ReverseString {

    static String[] Data = {
      "E.T.",                      //0
      "Sie nannten ihn Mücke",     //1
      "Sie nannten ihn M\u00FCcke",//2, Ist wirklich das gleiche wie oben drüber (siehe Vergleiche unten)
      "Les Misérables",           //3
      "Les Mise\u0301rables",     //4 Ist wirklich das gleiche wie oben drüber (siehe Vergleiche unten)
      "Les Misérables",           //5 Ist eine andere Codierung wie die beiden oben drüber (ohne Bindecharacter!)
      "Les Mis\u00E9rables"       //6 Ist wirklich das gleiche wie oben drüber (siehe Vergleiche unten)
    };

    public static void main(String[] args) {
        for(int i=0; i < Data.length; i++){
            String in = Data[i];
            System.out.print(String.format("D%d %s", i, in));
            System.out.println("\tREVERSE:\t" + reverse(in)
                    + "\tODER:\t" + new StringBuilder(in).reverse());
        }
        
        Object[] test = new String[10];
        test[4] = new Double(1);

        System.out.println();
        System.out.println("D1 == D2: " + Data[1].equals(Data[2])); //check: "Sie nannten ihn Mücke"
        System.out.println("D3 == D4: " + Data[3].equals(Data[4])); //check: "Les Misérables"
        System.out.println("D3 == D5: " + Data[3].equals(Data[5])); //check: "Les Misérables mit "eu0301" und 'u00E9'
        System.out.println("D5 == D6: " + Data[5].equals(Data[6]));
        System.out.println();
        System.out.println("Nochmal der 'Fehlerfall':"); //oder besser nicht erwartete Fall
        System.out.println("reverse(D3): " + reverse(Data[3])); //Der "accent aigu" ist jetzt über dem "r" anstelle des "e"
    }

    /**
     * Reverse a string
     * Note, there is a bug with combined characters!
     */
    static String reverse(String in){
        int strLength = in.length();
        char[] buffer = new char[strLength];
        int i =0;
        while(i < strLength){
           buffer[strLength - i - 1] = in.charAt(i);
           i++;
        }
        return String.valueOf(buffer);
    }

}
