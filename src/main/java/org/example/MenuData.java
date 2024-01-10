package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuData {
    private Map<String, List<Menu>> menus;	// 메뉴
    private Map<String, List<Product>> menuItems;	// 상품메뉴

    public MenuData(){
        menus = new HashMap<>();
        menuItems = new HashMap<>();

        initalize();
    }

    private void initalize(){
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Burger", "앵거스 비프 통살을 다져만든 버거"));
        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenus.add(new Menu("Side", "같이 먹는 사이드 메뉴"));

        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Product> burgersMenus = new ArrayList<>();
        burgersMenus.add(new Product("ShackBurger","기본 버거",5000));
        burgersMenus.add(new Product("SmokeBurger","베이컨이 들어간 버거",5500));
        burgersMenus.add(new Product("CheeseBurger","치즈버거",4500));

        List<Product> DrinksMenus = new ArrayList<>();
        DrinksMenus.add(new Product("Coke","얼음 동동 콜라",3000));
        DrinksMenus.add(new Product("Ade","달콤새콤 에이드",4000));
        DrinksMenus.add(new Product("beer","시원한 맥주",4500));
        List<Product> SideMenus = new ArrayList<>();
        SideMenus.add(new Product("Fries","바삭한 감자튀김",4500));
        SideMenus.add(new Product("Cheese","고소한 치즈",3000));
        SideMenus.add(new Product("Onion","맛있는 어니언링",5500));
    }
    /**
     * 메뉴 조회
     * @param key 조회할 메뉴 키값
     * @return 조회된 메뉴 목록
     */
    public List<Menu> getMenus(String key) {

        return menus.get(key);
    }

    /**
     * 상품메뉴 조회
     * @param key 조회할 상품메뉴 키값
     * @return 조회된 상품메뉴 목록
     */
    public List<Product> getMenuItems(String key) {

        return menuItems.get(key);
    }
}
