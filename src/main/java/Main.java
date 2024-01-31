import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("На скольких человек разделить счет?");
        int persons;
        while (true) {
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                if (persons > 1) {
                    break;
                } else {
                    System.out.println("Ошибка! Количество человек должно быть больше одного.");
                }
            }else {
                System.out.println("Ошибка! Введите целое число для количества человек.");
                scanner.next();
            }
        }
        scanner.nextLine();
        double totalAmount = 0;
        while (true) {

            System.out.println("Введите название товара (или \"Завершить\" для завершения):");
            //String productName = scanner.nextLine().trim();
//            calculator.addProduct();
//            if (productName.equalsIgnoreCase("Завершить")) {
//                calculator.calculateAndPrintBill(persons);
            String productName = scanner.nextLine().trim();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара в формате рубли.копейки:");
            double productPrice;

            while (true) {

                if (scanner.hasNextDouble()) {
                    productPrice = scanner.nextDouble();
                    scanner.nextLine();
                    if (productPrice >= 0.0) {
                        System.out.println("Товар успешно добавлен");
                        break;
                    } else {
                        System.out.println("Цена должна быть больше нуля, введите правильную стоимость");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Некоректный ввод, введите число в формате рубли.копейки");
                    scanner.nextLine();
                    /*continue;
                     я так чувствую*/
                }
            }
            Product product = new Product(productName, productPrice);
            products.add(product);
            totalAmount += productPrice;
        }
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();

        double amountPerPerson = calculator.calculateAmountPerPerson(totalAmount, persons);



        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println(product.name);

            //for (Product product : products) {
            // System.out.println("Название: " + product.name + ", Стоимость: " + product.price);
        }
        System.out.println("Сумма, которую должен заплатить каждый человек: " + formatter.formatAmount(amountPerPerson));
    }
}
//double productPrice = Double.parseDouble(scanner.nextLine());

//calculator.addProduct(productName, price);
