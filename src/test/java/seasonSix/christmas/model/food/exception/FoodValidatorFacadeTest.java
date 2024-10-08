package seasonSix.christmas.model.food.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seasonSix.chrismas.model.food.Food;
import seasonSix.chrismas.model.food.appetizer.CaesarSalad;
import seasonSix.chrismas.model.food.appetizer.MushroomSoup;
import seasonSix.chrismas.model.food.appetizer.Tapas;
import seasonSix.chrismas.model.food.beverage.Champagne;
import seasonSix.chrismas.model.food.beverage.RedWine;
import seasonSix.chrismas.model.food.beverage.ZeroCoke;
import seasonSix.chrismas.model.food.dessert.ChocolateCake;
import seasonSix.chrismas.model.food.dessert.IceCream;
import seasonSix.chrismas.model.food.exception.DuplicatedFoodException;
import seasonSix.chrismas.model.food.exception.NotAvailableFoodException;
import seasonSix.chrismas.model.food.exception.NotAvailableFormatException;
import seasonSix.chrismas.model.food.exception.NotAvailableOrderException;
import seasonSix.chrismas.model.food.main.BbqRip;
import seasonSix.chrismas.model.food.main.ChristmasPasta;
import seasonSix.chrismas.model.food.main.SeafoodPasta;
import seasonSix.chrismas.model.food.main.TBornStake;
import seasonSix.chrismas.model.food.validator.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FoodValidatorFacadeTest {

    private final List<Food> availableFoods = List.of(
            new MushroomSoup(), new Tapas(), new CaesarSalad(),
            new TBornStake(), new BbqRip(), new SeafoodPasta(), new ChristmasPasta(),
            new ChocolateCake(), new IceCream(),
            new ZeroCoke(), new RedWine(), new Champagne()
    );

    @Test
    @DisplayName("통합 테스트")
    void foodValidatorFacadeTest() {
        //given
        String source = "시저샐러드-1,시저샐러드-1";
        //when
        assertThatThrownBy(() -> {
            FoodValidatorFacade.check(source, availableFoods);
        }).isInstanceOf(DuplicatedFoodException.class);
        //then
    }

    @Test
    @DisplayName("형식 확인 - [영어]-[1~20]")
    void regexValidatorTestV1() {
        //given
        RegexValidator regexValidator = new RegexValidator();
        List<String> source = List.of("시저샐러드-1", "양송이스푸-1", "bbq-1");
        //then
        assertThatThrownBy(() -> {
            regexValidator.check(source, availableFoods);
        }).isInstanceOf(NotAvailableFormatException.class);
    }

    @Test
    @DisplayName("형식 확인 - [한글]-[1~20]")
    void regexValidatorTestV2() {
        //given
        RegexValidator regexValidator = new RegexValidator();
        List<String> source = List.of("시저샐러드-1", "양송이스푸-1");
        //then
        regexValidator.check(source, availableFoods);
    }

    @Test
    @DisplayName("중복 음식 확인 - 한 메뉴 2번 주문")
    void duplicatedOrderValidatorTestV1() {
        //given
        DuplicatedOrderValidator duplicatedOrderValidator = new DuplicatedOrderValidator();
        List<String> source = List.of("시저샐러드-1", "시저샐러드-1");
        //then
        assertThatThrownBy(() -> {
            duplicatedOrderValidator.check(source, availableFoods);
        }).isInstanceOf(DuplicatedFoodException.class);
    }

    @Test
    @DisplayName("중복 음식 확인 - 한 메뉴 1번만 주문")
    void duplicatedOrderValidatorTestV2() {
        //given
        DuplicatedOrderValidator duplicatedOrderValidator = new DuplicatedOrderValidator();
        List<String> source = List.of("시저샐러드-1", "초코케이크-1");
        //then
        duplicatedOrderValidator.check(source, availableFoods);
    }

    @Test
    @DisplayName("주문량 확인 - 20개 초과")
    void overOrderValidatorTestV1() {
        //given
        OverOrderValidator overOrderValidator = new OverOrderValidator();
        List<String> source = List.of("시저샐러드-19", "초코케이크-19");
        //then
        assertThatThrownBy(() -> {
            overOrderValidator.check(source, availableFoods);
        }).isInstanceOf(NotAvailableOrderException.class);
    }

    @Test
    @DisplayName("주문량 확인 - 20개 이하")
    void overOrderValidatorTestV2() {
        //given
        OverOrderValidator overOrderValidator = new OverOrderValidator();
        List<String> source = List.of("시저샐러드-1", "초코케이크-19");
        //then
        overOrderValidator.check(source, availableFoods);
    }

    @Test
    @DisplayName("메뉴에 있는 음식만 주문 확인")
    void availableValidatorTestV1() {
        //given
        AvailableValidator availableValidator = new AvailableValidator();
        List<String> source = List.of("시저샐러드-1", "초코케이크-19");
        //then
        availableValidator.check(source, availableFoods);
    }

    @Test
    @DisplayName("메뉴에 없는 음식 주문")
    void availableValidatorTestV2() {
        //given
        AvailableValidator availableValidator = new AvailableValidator();
        List<String> source = List.of("시저샐러드-1", "양념치킨-19");
        //then
        assertThatThrownBy(() -> {
            availableValidator.check(source, availableFoods);
        }).isInstanceOf(NotAvailableFoodException.class);
    }
}
