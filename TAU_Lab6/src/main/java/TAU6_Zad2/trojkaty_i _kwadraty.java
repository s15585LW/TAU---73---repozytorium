package Zadanie2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class trojkaty_i _kwadraty {

    static Scanner sc = new Scanner(System.in);
    static String feedback = "";

    public static String getFeedback() {
        return feedback;
    }

    public static void setFeedback(String feedback) {
        trojkaty_i.feedback = feedback;
    }


        static void trojkaty(int a, int b, int c) {

            if (a + b > c && a + c > b && b + c > a) {

                if (a == b && b == c)  this.setFeedback("Trojkąt równoboczny");
                else if ((a != b) && (b != c) && (a != c))  this.setFeedback("Trójkąt różnoramienny");
                else if ((a == b && a != c) || (a == c && b != c) || (b == c && a != c)) this.setFeedback("równoramienny");

            } else {

                this.setFeedback("Nie mozna utworzyc trojkata");

            }

            System.out.println(this.getFeedback());
        }

        static void kwadraty(int a, int b, int c, int d) {
            if (a + b + d > c && a + c + d > b && b + c + d > a && a + b + c > d) {

                if (a == b && c == d && a == c) this.setFeedback("kwadrat");
                else if ((a == c && b == d && a!=b) || (a == b && c == d  && a!=c) ||  (a == d && b == c  && a!=c)) this.setFeedback("prostokąt");
                else this.setFeedback("czworobok roznoramienny");

            } else {

                this.setFeedback("nie mozna utworzyc kwadratu");

            }

            System.out.println(this.getFeedback());
        }

        static String printFunction() {
            int choice, a1,a2, b1, b2, c1, c2, d2;

            try {
                System.out.print(" **MENU** \n Która figurę chcesz sprawdzić? \n \n  3 - trójkąty \n 4 - wielobok");

                choice = sc.nextInt();
                if(choice!=3 && choice!=4){
                    System.out.println("Nie wybrano zadnej figury spróbuj jeszcze raz \n \n ");
                    printFunction();
                }else
                    switch (choice) {
                        case 3:
                            System.out.print("Podaj bok: a= ");
                            a1 = sc.nextInt();
                            System.out.print("Podaj bok: b= ");
                            b1 = sc.nextInt();
                            System.out.print("Podaj bok: c= ");
                            c1 = sc.nextInt();
                            trojkaty(a1,b1,c1);
                            break;
                        case 4:
                            System.out.print("Podaj bok: a= ");
                            a2 = sc.nextInt();
                            System.out.print("Podaj bok: b= ");
                            b2 = sc.nextInt();
                            System.out.print("Podaj bok: c= ");
                            c2 = sc.nextInt();
                            System.out.print("Podaj bok: d= ");
                            d2 = sc.nextInt();
                            kwadraty(a2, b2, c2, d2);
                            break;
                    }
            } catch (InputMismatchException e){
                System.out.println("Bledna wartosc, spróbuj ponownie");
                printFunction();
            }return feedback;
        }

    public static void main(String[] args) {
        printFunction();
    }
}
