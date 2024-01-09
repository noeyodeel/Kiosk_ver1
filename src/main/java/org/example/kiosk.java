package org.example;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class kiosk {


    private static MenuData menuData;

    public static void run() {
        menuData = new MenuData();


        Cart cart = new Cart();

        while (true) {
            System.out.println("\n[SHAKESHACK BURGER]");
            System.out.println("1.Burger\n2.Drink\n3.side\n4.Order\n5.Cancel");
            List<Menu> mainMenu = menuData.getMenus();
            System.out.println("");

            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.println("1.ShackBurger | 5000 | 기본 버거\n2.SmokeBurger | 5500 | 베이컨이 들어간 버거\n3.CheeseBurger | 4500 | 치즈 버거");
                int select = sc.nextInt();
                if (select == 1) {//첫번째 버거 선택
                    Burger ShackBurger = new Burger("ShackBurger", "기본 버거", 5000);
                    //선택한 버거 정보 출력
                    menuPrint(ShackBurger);
                    //장바구니에 추가하시겠습니까?
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(ShackBurger);
                        System.out.println(ShackBurger.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                } else if (select == 2) {
                    Burger SmokeBureger = new Burger("SmokeBurger", "베이컨이 들어간 버거", 5500);
                    menuPrint(SmokeBureger);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(SmokeBureger);
                        System.out.println(SmokeBureger.getName() + "가 장바구니에 추가 되었습니다.");
                    }

                } else if (select == 3) {
                    Burger CheeseBurger = new Burger("CheeseBurger", "치즈 버거", 4500);
                    menuPrint(CheeseBurger);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(CheeseBurger);
                        System.out.println(CheeseBurger.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                }

            } else if (menu == 2) {
                System.out.println("1.Coke | 3000 | 얼음 동동 콜라\n2.Ade | 4000 | 달콤새콤 에이드\n3.beer | 4500 | 시원한 맥주");
                int select = sc.nextInt();
                if (select == 1) {
                    Drink Coke = new Drink("Coke", "얼음 동동 콜라", 3000);
                    menuPrint(Coke);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Coke);
                        System.out.println(Coke.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                } else if (select == 2) {
                    Drink Ade = new Drink("Ade", "달콤새콤 에이드", 4000);
                    menuPrint(Ade);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Ade);
                        System.out.println(Ade.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                } else if (select == 3) {
                    Drink Beer = new Drink("beer", "시원한   맥주", 4500);
                    menuPrint(Beer);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Beer);
                        System.out.println(Beer.getName() + "가 장바구니에 추가되었습니다.");
                    }

                }
            } else if (menu == 3) {
                System.out.println("1.   Fries | 4500 | 바삭한 감자튀김\n2.Cheese | 3000 | 고소한 치즈\n3.Onion | 5500 | 맛있는 어니언링");
                int select = sc.nextInt();
                if (select == 1) {
                    Side Fries = new Side("Fries", "바삭한 감자튀김", 4500);
                    menuPrint(Fries);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Fries);
                        System.out.println(Fries.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                } else if (select == 2) {
                    Side Cheese = new Side("Cheese", "고소한 치즈", 3000);
                    menuPrint(Cheese);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Cheese);
                        System.out.println(Cheese.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                } else if (select == 3) {
                    Side Onion = new Side("Onion", "맛있는 어니언링", 5500);
                    menuPrint(Onion);
                    CartPrint();
                    int check = sc.nextInt();
                    if (check == 1) {
                        cart.addMenu(Onion);
                        System.out.println(Onion.getName() + "가 장바구니에 추가 되었습니다.");
                    }
                }
            } else if (menu == 4) {
                if (cart.isEmpty()) {
                    System.out.println("장바구니에 물건이 없습니다.");
                } else {
                    System.out.println("장바구니 목록 ");
                    //todo:카트에 담겨있는 메뉴 가격 출력

                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    // 카트에 있는 메뉴 이름, 설명 출력
                    System.out.println("[Orders]");
                    cart.printMenu();
                    System.out.println("\n[Total]");
                    System.out.println(cart.total());
                    System.out.println("1. 주문 2. 메뉴판");
                    int order = sc.nextInt();
                    if (order == 1) {
                        cart.clear();
                        System.out.println("주문이 완료되었습니다!\n");

                        System.out.println("대기번호는 [" + cart.watingNumber() + "]번 입니다");
                        System.out.println("[3초 후 메뉴판으로 돌아갑니다]\n");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //Thread.sleep(3000);
                    }
                }
            } else if ((menu == 5)) { //취소 선택 , 카트 초기화
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인   2.취소 \n");
                int cancel = sc.nextInt();
                if (cancel == 1) {
                    cart.clear();
                    System.out.println("진행하던 주문이 취소되었습니다.\n");
                }

            }
        }

    }

    //    메뉴 정보 출력
    public static void menuPrint(Menu menu) {
        if (menu instanceof Burger) {
            System.out.println(menu.getName() + " | " + ((Burger) menu).getPrice() + " | " + menu.getDescription());
        } else if (menu instanceof Drink) {
            System.out.println(menu.getName() + " | " + ((Drink) menu).getPrice() + " | " + menu.getDescription());
        } else if (menu instanceof Side) {
            System.out.println(menu.getName() + " | " + ((Side) menu).getPrice() + " | " + menu.getDescription());
        }

    }


    public static void CartPrint() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2.취소 \n");

    }

}
