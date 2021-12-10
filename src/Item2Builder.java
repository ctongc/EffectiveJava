import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * Item 2
 * Consider a builder when faced with many constructor parameters
 */
class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(final int servingSize, final int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(final int val) {
            calories = val;
            return this;
        }

        public Builder fat(final int val) {
            fat = val;
            return this;
        }

        public Builder sodium(final int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(final int val) {
            fat = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}

@Builder
@Value
class NutritionFactsWithLombok {
    @NonNull
    int servingSize;
    @NonNull
    int servings;

    int calories;
    int fat;
    int sodium;
    int carbohydrate;
}

public class Item2Builder {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27)
                .build();
        NutritionFactsWithLombok cocaCola2 = NutritionFactsWithLombok.builder()
                .servingSize(240).servings(8).calories(100).sodium(35).carbohydrate(27)
                .build();
    }
}
