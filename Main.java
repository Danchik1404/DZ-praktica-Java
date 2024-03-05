//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии)
//фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
//хранить в Map. Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить
//параметры фильтрации можно также в Map. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop(16, 1000, "macOS", "Белый"));
        laptops.add(new Laptop(12, 512, "Windows 11", "Черный"));
        laptops.add(new Laptop(8, 256, "Linux", "Серебристый"));
        laptops.add(new Laptop(4, 128, "Windows 10", "Синий"));
        laptops.add(new Laptop(16, 1000, "Windows 11", "Черный"));
        laptops.add(new Laptop(12, 512, "Linux", "Белый"));
        filterLaptops(laptops);
    }
    

    public static void filterLaptops (Set<Laptop> laptops){
        Map<String, String> criteria = new HashMap<>();
        criteria.put("1", "ОЗУ");
        criteria.put("2", "Обьем ЖД");
        criteria.put("3", "Операционная система");
        criteria.put("4", "Цвет");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Обьем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String userInput = scanner.nextLine();      

        if(criteria.containsKey(userInput)){
            String selectedCriteria = criteria.get(userInput);
            System.out.println("Введите минимальное значение для " + selectedCriteria + ":");
            String minValue = scanner.nextLine();
            scanner.close();

            Set<Laptop> filteredLaptops = new HashSet<>();
            switch (selectedCriteria) {
                case "ОЗУ":
                    int minRam = Integer.parseInt(minValue);
                    for(Laptop laptop : laptops){
                        if(laptop.getRam() >= minRam){
                            filteredLaptops.add(laptop);
                        } 
                    }
                    break;
                case "Обьем ЖД":
                    int minHddSize = Integer.parseInt(minValue);
                    for(Laptop laptop : laptops){
                        if(laptop.gethddSize() >= minHddSize){
                            filteredLaptops.add(laptop);
                        } 
                    }
                    break;
                case "Операционная система":
                    for(Laptop laptop : laptops){
                        if(laptop.getOs().equalsIgnoreCase(minValue)){
                            filteredLaptops.add(laptop);
                        } 
                    }
                    break;
                case "Цвет":
                for(Laptop laptop : laptops){
                    if(laptop.getColor().equalsIgnoreCase(minValue)){
                        filteredLaptops.add(laptop);
                        } 
                    }
                    break;
                default:
                    System.out.println("Некоректный ввод критерия!");
                    return;
            }
            if (filteredLaptops.isEmpty()){
                System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации, не найдены");
            } else {
                System.out.println("Неккоректный ввод критерия!");
            }
        }
        
    }
}