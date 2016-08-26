package br.edu.ifrn.projetobraile.dominio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {

    private String letter; /** alfabeto (a, b, c, ..., z) */
    private String braille; /** posicoes (1, 2, 3, 4, 5, 6) */

    private String[] brailleAlphabet; /** alfabeto em braille */

    private int mode; /** modo de treino (1 - letras, 2 - número) */

    public App() {
        letter = "";
        braille = "";
        mode = 1;

        createAlphabet();
    }

    public boolean brailleToLetter(String braille) {

        int iBraille = organizeBraille(braille);

        switch(mode) {
            case 123456: setLetter("a"); break;
            default: return false;
        }

        return true;

    }

    public int organizeBraille(String braille) {
        char[] cBraille = braille.toLowerCase().toCharArray();

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < cBraille.length; i++) {
            numbers.add(Integer.parseInt(""+cBraille[i]));
        }

        int bigger = 0;
        int smaller = 0;

        for(int i : numbers) {
            bigger = Math.max(bigger, i);
            smaller = Math.min(smaller, i);
        }

        String result = "";

        if(smaller != 0) {
            result += smaller;

            int secondSmaller = bigger;

            for(int i : numbers) {
                if(i > smaller && i < bigger && i < secondSmaller) {
                    secondSmaller = i;
                }
            }

            if(secondSmaller != 0) {
                result += secondSmaller;

                int thirdSmaller = bigger;

                for(int i : numbers) {
                    if(i < bigger && i > secondSmaller && i < thirdSmaller) {
                        thirdSmaller = i;
                    }

                    if(thirdSmaller != 0) {
                        result += thirdSmaller;
                        result += bigger;
                    }
                }

            } else {
                result += smaller;
                return Integer.parseInt(result);
            }

        } else {
            result += bigger;
            return Integer.parseInt(result);
        }

        return Integer.parseInt(result);

    }

    public boolean letterToBraille(String letter) {

        switch(letter.toLowerCase().charAt(0)) {

            /** LETRAS */
            case 'a': setBraille("1"); break;
            case 'b': setBraille("13"); break;
            case 'c': setBraille("12"); break;
            case 'd': setBraille("124"); break;
            case 'e': setBraille("14"); break;
            case 'f': setBraille("123"); break;
            case 'g': setBraille("1234"); break;
            case 'h': setBraille("134"); break;
            case 'i': setBraille("23"); break;
            case 'j': setBraille("234"); break;
            case 'k': setBraille("15"); break;
            case 'l': setBraille("135"); break;
            case 'm': setBraille("125"); break;
            case 'n': setBraille("1245"); break;
            case 'o': setBraille("145"); break;
            case 'p': setBraille("1235"); break;
            case 'q': setBraille("1345"); break;
            case 'r': setBraille("1345"); break;
            case 's': setBraille("235"); break;
            case 't': setBraille("2345"); break;
            case 'u': setBraille("156"); break;
            case 'v': setBraille("1356"); break;
            case 'w': setBraille("2346"); break;
            case 'x': setBraille("1256"); break;
            case 'y': setBraille("12456"); break;
            case 'z': setBraille("1456"); break;

            /** NÚMEROS */
            case '1': setBraille("1"); break;
            case '2': setBraille("13"); break;
            case '3': setBraille("12"); break;
            case '4': setBraille("124"); break;
            case '5': setBraille("14"); break;
            case '6': setBraille("123"); break;
            case '7': setBraille("1234"); break;
            case '8': setBraille("134"); break;
            case '9': setBraille("23"); break;
            case '0': setBraille("234"); break;

            /** SÍMBOLOS */
            case '!': setBraille("345"); break;
            case '\'': setBraille("5"); break;
            case ',': setBraille("3"); break;
            case '-': setBraille("56"); break;
            case '.': setBraille("346"); break;
            case '?': setBraille("356"); break;
            default: return false;
        }

        return true;
    }

    public boolean numberAdded(String number) {
        for(char c : braille.toLowerCase().toCharArray()) {
            if(number.toLowerCase().charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getBraille() {
        return braille;
    }

    public void setBraille(String braille) {
        this.braille = braille;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void addBraille(String number) {
        if(!numberAdded(number)) {
            this.braille += number;
        }
    }

    public void clearBraille() {
        setBraille("");
    }

    public void createAlphabet() {
        brailleAlphabet = new String[] {

            "1", "13", "12", "124", "14", "123", "1234", "134", "23", "234", "15",
            "135", "125", "1245", "145", "1235", "1345", "1345", "235", "2345", "156",
            "1356", "2346", "1256", "12456", "1456", "345", "5", "3", "56", "346", "356"

        };
    }

}
