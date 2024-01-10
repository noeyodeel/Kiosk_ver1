package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static MenuData menuData;

    public static void main(String[] args) {

        menuData = new MenuData();
        showMainMenu();
    }
    public static void showMainMenu(){

        //메인 메뉴 출력
        System.out.println("\n[SHAKESHACK BURGER]에 오신것을 환영합니다!");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("\n[MENU]");
        List<Menu> mainMenu = menuData.getMenus("Main");
        printMainMenu(mainMenu);
        System.out.println("[ORDER]");
        List<Menu> OrderMenu = menuData.getMenus("Order");
        printMainMenu(OrderMenu);

        showMenu();
    }
    public static void showMenu(){

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input == 0){
            menuData.ShowAllOrder();  //총 판매 상품 출력
            back();
        }else if(input == 1){
            List<Product> burger = menuData.getMenus(1);
            System.out.println("[Burger Menu]");
            printItem(burger);
            selctedProduct(burger);
        } else if (input == 2) {
            List<Product> Drink = menuData.getMenus(2);
            System.out.println("[Drink Menu]");
            printItem(Drink);
            selctedProduct(Drink);
        }else if (input == 3) {
            List<Product> Side = menuData.getMenus(3);
            System.out.println("[Side Menu]");
            printItem(Side);
            selctedProduct(Side);
        }else if (input == 4) {
            ShowOrderMenu();
        }else if (input == 5) {
            CancelText();
        }else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            showMainMenu();
        }
    }
    private static  void back(){
        System.out.println("1. 돌아가기");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            showMainMenu();
        }
    }

    //    상품선택
    private static void selctedProduct(List<Product> products){
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        if(menu == 1){
            Product selcteditem = products.get(0);
            ShowSelectedproduct(selcteditem);
        }else if(menu == 2){
            Product selcteditem = products.get(1);
            ShowSelectedproduct(selcteditem);
        }else if(menu == 3){
            Product selcteditem = products.get(2);
            ShowSelectedproduct(selcteditem);
        }else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            showMainMenu();
        }
    }

    //    상품 선택 후 메뉴 출력
    private static void ShowSelectedproduct(Product menuItem) {
        System.out.println(menuItem.getName() + "   | " + menuItem.getPrice() + " | " + menuItem.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        CartInput(menuItem);	// 확인여부 입력 처리
    }

    //    장바구니 확인 여부
    private static void CartInput(Product menuItem) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {		//확인 선택
            menuData.addToCart(menuItem);			// 선택한 상품 장바구니에 추가
            System.out.println("장바구니에 추가되었습니다.");
            showMainMenu();
        } else if (input == 2) { //취소 선택
            showMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            CartInput(menuItem);
        }
    }

    // 장바구니 담겨있는 목록, 주문한 상품 총 가격 출력
    private static void ShowOrderMenu() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        menuData.displayCart();			//  장바구니 목록 출력

        System.out.println("[ Total ]");
        System.out.println(menuData.getTotalPrice() + "\n");

        OrderInput();
    }

    // 주문 확인
    private static void OrderInput() {
        System.out.println("1. 주문      2. 메뉴판");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            WatingNumber();	// 주문완료 처리
        } else if (input == 2) {
            showMainMenu();		
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            OrderInput();
        }
    }

    // 주문 완료 대기 번호 출력
    private static void WatingNumber() {

        int orderNumber = menuData.generateOrderNumber();
        List<Product> cart = menuData.getCart();
        menuData.allOrder(cart);

        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");

        Delay();		// 장바구니 초기화 후 메인메뉴 출력
    }

    // 장바구니 초기화 3초 후 메인 메뉴 출력
    private static void Delay() {
        menuData.resetCart();		// 장바구니 초기화
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showMainMenu();		    }


    // 주문 취소 확인 출력
    private static void CancelText() {
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        CancelInput();	// 주문취소 확인 입력값 처리
    }
    // 주문 취소 확인 입력 값 받고 장바구니 초기화 후, 메인메뉴
    private static void CancelInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            menuData.resetCart();	// 장바구니 초기화
            System.out.println("주문이 취소되었습니다.");
            showMainMenu();			// 메인메뉴 출력하며 돌아가기
        } else if (input == 2) {
            showMainMenu();			// 메인메뉴 출력하며 돌아가기
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            CancelInput();	// 주문취소 확인 입력값 처리 재수행
        }
    }

    //    메인 메뉴 출력
    private  static void printMainMenu(List<Menu> menus) {
        for (int i = 0; i < menus.size(); i++) {

            System.out.println(menus.get(i).getId() + ". " + menus.get(i).getName() + "   | " + menus.get(i).getDescription());
        }
    }
    //    상품 출력
    private  static void printItem(List<Product> menus) {

            //System.out.println(menus.
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i).getId() + ". " + menus.get(i).getName() + "   | " +menus.get(i).getPrice() + "   | "+menus.get(i).getDescription());
        }
    }

}