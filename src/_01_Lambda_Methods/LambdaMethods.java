package _01_Lambda_Methods;

public class LambdaMethods {
    public static void main(String[] args) {
        // 1. Look at the SpecialPrinter function interface.

        // Here is an example of calling the printCustomMessage method with a lambda.
        // This prints the passed-in String 10 times.
        printCustomMessage((s) -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(s);
            }
        }, "repeat");

        // 2. Call the printCustomMessage method using a lambda so that the String prints backwards.
        printCustomMessage((s) -> {
            StringBuilder reversed = new StringBuilder(s).reverse();
            System.out.println(reversed);
        }, "reverse");

        // 3. Call the printCustomMessage method using a lambda so that the String prints with a mix between upper and lower case characters.
        printCustomMessage((s) -> {
            StringBuilder mixedCase = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i % 2 == 0) {
                    mixedCase.append(Character.toUpperCase(c));
                } else {
                    mixedCase.append(Character.toLowerCase(c));
                }
            }
            System.out.println(mixedCase);
        }, "mixedCase");

        // 4. Call the printCustomMessage method using a lambda so that the String prints with a period in between each character.
        printCustomMessage((s) -> {
            StringBuilder withPeriods = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                withPeriods.append(s.charAt(i));
                if (i < s.length() - 1) {
                    withPeriods.append(".");
                }
            }
            System.out.println(withPeriods);
        }, "periods");

        // 5. Call the printCustomMessage method using a lambda so that the String prints without any vowels.
        printCustomMessage((s) -> {
            String withoutVowels = s.replaceAll("[AEIOUaeiou]", "");
            System.out.println(withoutVowels);
        }, "withoutVowels");
    }

    public static void printCustomMessage(SpecialPrinter sp, String value) {
        sp.printSpecial(value);
    }
}
