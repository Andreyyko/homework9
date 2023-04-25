import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cars> myCars = gener.generateCars(7, 12000, 64000, 11500, 60250, 2012, 2023);
        System.out.println(myCars);

        List<Cars> selectedCars;

        selectedCars = myCars.stream()
                .filter(c -> c.getBrand().equals(Brand.TESLA) || c.getBrand().equals(Brand.AUDI))
                .collect(Collectors.toList());

        System.out.println("Тесла або Ауді:" + '\n' + selectedCars);

        selectedCars = myCars.stream()
                .filter(c -> c.getYear() < 2018)
                .collect(Collectors.toList());

        System.out.println("Машини молодші 2018:" + '\n' + selectedCars);

        selectedCars = myCars.stream()
                .filter(c -> c.getMileage() < 40000)
                .collect(Collectors.toList());

        System.out.println("Відібрати тільки автомобілі з пробігом менше 40000:" + '\n' + selectedCars);

        selectedCars = myCars.stream()
                .sorted(Comparator.comparing(Cars::getPrice).reversed())
                .collect(Collectors.toList());

        System.out.println("Відсортувати їх за ціною в порядку спадання:" + '\n' + selectedCars);

        Map<String, Cars> cheapest3Cars = myCars.stream()
                .sorted(Comparator.comparing(Cars::getPrice))
                .limit(3)
                .collect(Collectors.toMap(Cars::getId, Function.identity()));

        System.out.println("Взяти три найдешевші і створити з них мапу, де" + '\n' + cheapest3Cars);

    }
}