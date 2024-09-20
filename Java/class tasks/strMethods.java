public class strMethods{
    public static void main(String[] args) {
        System.out.println("\n---String Methods Program---");
        String name = "Virat Kohli";
        System.out.println("(1) name = " + name);
        System.out.println("(2) name.length() = " + name.length());
        System.out.println("(3) name.toLowerCase() = " + name.toLowerCase());
        System.out.println("(4) name.toUpperCase() = " + name.toUpperCase());
        System.out.println("(5) name.trim() = " + name.trim());
        System.out.println("(6) name.substring(6) = " + name.substring(6));
        System.out.println("(7) name.substring(0,5) = " + name.substring(0,5));
        System.out.println("(8) name.replace('V','K') = " + name.replace('V', 'K'));
        System.out.println("(9) name.startsWith(\"Virat\") = " + name.startsWith("Virat"));
        System.out.println("(10) name.endsWith(\"Kohli\") = " + name.endsWith("Kohli"));
        System.out.println("(11) name.charAt(0) = " + name.charAt(0));
        System.out.println("(12) name.indexOf(\"i\") = " + name.indexOf("i"));
        System.out.println("(13) name.indexOf(\"i\",6) = " + name.indexOf("i",6));
        System.out.println("(14) name.lastIndexOf(\"i\") = " + name.lastIndexOf("i"));
        System.out.println("(15) name.equals(\"Virat Kohli\") = " + name.equals("Virat Kohli"));
        System.out.println("(16) name.equalsIgnoreCase(\"virat kohli\") = " + name.equalsIgnoreCase("virat kohli"));
    }
}