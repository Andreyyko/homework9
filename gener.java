import java.util.ArrayList;
import java.util.Random;

public class gener {

    public static ArrayList<Cars> generateCars(int carsAmount, double mileageStart, double mileageEnd,
                                              double priceStart, double priceEnd, int yearStart, int yearEnd) {

        int count = 0;
        Random r = new Random();
        double randomPrice = 0.0;
        double randomMileage = 0.0;
        int randomYear = 0;
        int randomBrand = 0;
        ArrayList<Cars> generatedCars = new ArrayList<>();
        while (count++ < carsAmount) {

            randomPrice = Math.round(priceStart + r.nextDouble(priceEnd - priceStart) * 100.0 / 100.0);
            randomMileage = Math.round(mileageStart + r.nextDouble(mileageEnd - mileageStart) * 100.0 / 100.0);
            randomYear = (int) Math.floor(Math.random() * (yearEnd - yearStart + 1) + yearStart);
            randomBrand = r.nextInt(Brand.values().length);
            Cars randomCar = new Cars(Brand.values()[randomBrand], randomYear, randomMileage, randomPrice);
            generatedCars.add(randomCar);

        }
        return generatedCars;
    }
}