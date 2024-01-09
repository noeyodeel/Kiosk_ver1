package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Menu> menuList = new ArrayList<>();
    private int watingNumber=0;

    public Cart() {

    }

    //    메뉴추가
    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    //public String getMenu(){
    //return menuList.g
    //}

    public  int watingNumber(){
        watingNumber++;
        return watingNumber;
    }
    public String getName() {
        for (Menu menu : menuList) {
            return menu.getName();
        }
        return null;
    }


    //    비어있는지 확인
    public boolean isEmpty() {
        if (menuList.isEmpty()) {
            return true;
        }
        return false;
    }

    //    카트에 담겨있는 메뉴와 설명 출력
    public void printMenu() {
        for (Menu menu : menuList) {
            System.out.println(menu.getName() + "  |  "+menu.getDescription());
        }
    }

    //    카트에 담겨있는 메뉴 총금액 출력
    // 카트에 담겨있는 메뉴 총금액 출력
    public int total() {
        int totalPrice = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Burger) {
                totalPrice += ((Burger) menu).getPrice();
            } else if (menu instanceof Drink) {
                totalPrice += ((Drink) menu).getPrice();
            } else if (menu instanceof Side) {
                totalPrice += ((Side) menu).getPrice();
            }
        }
        return totalPrice;
    }

    public int getPrice() {
        int price = 0;
        for (Menu menu : menuList) {
            if (menuList instanceof Burger) {
                price = ((Burger) menuList).getPrice();
            } else if (menuList instanceof Drink) {
                price = ((Drink) menuList).getPrice();
            } else if (menuList instanceof Side) {
                price = ((Side) menuList).getPrice();
            }
        }
        return price;
    }

    //    cart 비우기
    public void clear() {
        menuList.clear();
    }
}



