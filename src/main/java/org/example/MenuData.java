package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuData {
    private Map<String, List<Menu>> menus;    // 메뉴
    private Map<Integer, List<Product>> menuItems;    // 상품메뉴
    private List<Product> cart;    // 장바구니
    private int totalPrice;    // 전체 가격
    private int orderNumber;    // 주문 번호

    public MenuData() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        cart = new ArrayList<>();
        totalPrice = 0;
        orderNumber = 0;

        initalize();
    }

    private void initalize() {
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu(1, "Burger", "앵거스 비프 통살을 다져만든 버거"));
        mainMenus.add(new Menu(2, "Drinks", "매장에서 직접 만드는 음료"));
        mainMenus.add(new Menu(3, "Side", "같이 먹는 사이드 메뉴"));

        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu(4, "Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu(5, "Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Product> burgersMenus = new ArrayList<>();
        burgersMenus.add(new Product(1, "ShackBurger", "기본 버거", 5000));
        burgersMenus.add(new Product(2, "SmokeBurger", "베이컨이 들어간 버거", 5500));
        burgersMenus.add(new Product(3, "CheeseBurger", "치즈버거", 4500));

        List<Product> DrinksMenus = new ArrayList<>();
        DrinksMenus.add(new Product(1, "Coke", "얼음 동동 콜라", 3000));
        DrinksMenus.add(new Product(2, "Ade", "달콤새콤 에이드", 4000));
        DrinksMenus.add(new Product(3, "beer", "시원한 맥주", 4500));
        List<Product> SideMenus = new ArrayList<>();
        SideMenus.add(new Product(1, "Fries", "바삭한 감자튀김", 4500));
        SideMenus.add(new Product(2, "Cheese", "고소한 치즈", 3000));
        SideMenus.add(new Product(3, "Onion", "맛있는 어니언링", 5500));

        menuItems.put(1, burgersMenus);
        menuItems.put(2, DrinksMenus);
        menuItems.put(3, SideMenus);


    }

    //메뉴 조회

    public List<Menu> getMenus(String key) {

        return menus.get(key);
    }

    public List<Product> getMenus(int key) {

        return menuItems.get(key);
    }


    // 상품메뉴 조회
    public List<Product> getMenuItems(String key) {

        return menuItems.get(key);
    }

    /**
     * 여기서부터 카트
     */
    public List<Product> getCart() {
        return cart;
    }


    //    장바구니에 상품 추가
    public void addToCart(Product menuItem) {
        cart.add(menuItem);
        totalPrice += menuItem.getPrice();
    }

    //   장바구니 초기화
    public void resetCart() {
        cart.clear();
        totalPrice = 0;
    }

    // 장바구니 출력
    public void displayCart() {
        for (Product product : cart) {
            System.out.println(product.getName() + "   | " + product.getPrice() + " | " + product.getDescription());
        }
    }

//   장바구니 전체 가격
    public int getTotalPrice() {
        return totalPrice;
    }

    //    웨이팅 번호
    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }
}

