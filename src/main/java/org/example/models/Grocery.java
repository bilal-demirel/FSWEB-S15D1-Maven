package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Lütfen ne yapmak istediğinizi seçin: 0 (Kapat), 1 (Ekle), 2 (Çıkar)");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 0:
                    System.out.println("Uygulama Kapatılıyor!");
                    return;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini yazınız!");
            }
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            } else {
                System.out.println(item + " zaten listede Ekli.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " listeden çıkarıldı.");
            } else {
                System.out.println(item + " listede değil.");
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        System.out.println("Sıralı Liste: " + groceryList);
    }
}
