package com.company;

import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        int[] tab = { -1, -3, 2, -2, 3, 0, 4, 2, -2, -1 };
        //int[] tab = { -7, 6, 3, -5, 0, 1, -3, 0, 5, -4 };
        int maximum = max(tab);
        int minimum = min(tab);
        int nbLine = Math.abs(maximum) + Math.abs(minimum) + 1;
        int nbCol = tab.length;
        int abcisseLine = nbLine - maximum;
        int temp;

        System.out.println("Minimum : " + minimum);
        System.out.println("Maximum : " + maximum);
        System.out.println("Nombre de ligne : " + nbLine);
        System.out.println("Nombre de colonne : " + nbCol);
        System.out.println("Abcisse line : " + abcisseLine);
        System.out.println();

        for (int line = 0; line < nbLine; line++) {
            for (int col = 0; col < nbCol; col++) {
                if (line == abcisseLine) {
                    if (tab[col] == 0) {
                        System.out.print('*');
                    } else {
                        System.out.print('+');
                    }
                } else {
                    // Calcul de l'index max de notre ligne à afficher
                    /*{
                    -1 => 5
                    -3 => 7
                    2 => 2
                    -2 => 6
                    3 => 1
                    0 => 4
                    4 => 0
                    2 => 2
                    -2 => 6
                    -1 => 5
                    }*/
                    temp = abcisseLine - tab[col];

                    if (tab[col] != 0) {
                        if (temp > abcisseLine) {
                            // Ici on est dans les négatif;
                            if (tab[col] < 0 && line > abcisseLine) {
                                if (temp < line) {
                                    System.out.print(' ');
                                } else {
                                    System.out.print('*');
                                }
                            } else {
                                System.out.print(' ');
                            }
                        } else {
                            // Ici on est dans les positifs;
                            if (tab[col] > 0 && line < abcisseLine) {
                                if (temp > line) {
                                    System.out.print(' ');
                                } else {
                                    System.out.print('*');
                                }
                            } else {
                                System.out.print(' ');
                            }
                        }
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Renvoie l'entier maximum pour le tableau passé en paramètre
     *
     * @param arr
     * @return
     */
    public static int max(int[] arr) {
        int max = 0;

        // Parcours du tableau
        for (int i = 0; i < arr.length; i++) {
            // Si la valeur de la ligne parcourue de notre tableau est supérieur à notre maximum
            if (arr[i] > max) {
                // On redéfinit notre maximum avec la valeur de la ligne parcourue du tableau
                max = arr[i];
            }
        }

        return max;
    }

    public static int min(int[] arr) {
        int min = 0;

        // Parcours du tableau
        for (int i = 0; i < arr.length; i++) {
            // Si la valeur de la ligne parcourue de notre tableau est inférieur à notre minimum
            if (arr[i] < min) {
                // On redéfinit notre minimum avec la valeur de la ligne parcourue du tableau
                min = arr[i];
            }
        }

        return min;
    }
}
