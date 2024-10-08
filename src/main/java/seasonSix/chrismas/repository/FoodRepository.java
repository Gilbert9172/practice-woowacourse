package seasonSix.chrismas.repository;

import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.appetizer.CaesarSalad;
import seasonSix.chrismas.model.food.appetizer.MushroomSoup;
import seasonSix.chrismas.model.food.appetizer.Tapas;
import seasonSix.chrismas.model.food.beverage.Champagne;
import seasonSix.chrismas.model.food.beverage.RedWine;
import seasonSix.chrismas.model.food.beverage.ZeroCoke;
import seasonSix.chrismas.model.food.dessert.ChocolateCake;
import seasonSix.chrismas.model.food.dessert.IceCream;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;
import seasonSix.chrismas.model.food.main.ChristmasPasta;
import seasonSix.chrismas.model.food.main.SeafoodPasta;
import seasonSix.chrismas.model.food.main.TBornStake;
import seasonSix.chrismas.model.food.main.BbqRip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodRepository {

    private static List<Food> foods = List.of(
            new MushroomSoup(), new Tapas(), new CaesarSalad(),
            new TBornStake(), new BbqRip(), new SeafoodPasta(), new ChristmasPasta(),
            new ChocolateCake(), new IceCream(),
            new ZeroCoke(), new RedWine(), new Champagne()
    );

    public List<Food> initializeFoods() {
        return foods;
    }

    public Optional<Food> findPrizeFood() {
        return foods.stream()
                .filter(Food::isPrize)
                .findFirst();
    }
}
