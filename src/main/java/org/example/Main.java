package org.example;

public class Main {
    private static MenuData menuData;

    public static void main(String[] args) {

        menuData = new MenuData();
        kiosk Kiosk = new kiosk();
        kiosk.run();
    }
}