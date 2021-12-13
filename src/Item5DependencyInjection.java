import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Item 5
 * Prefer dependency injection to hardwiring resources
 */
class Lexicon {
}

class SpellChecker {
    private final Lexicon dictionary;

    // @Inject
    public SpellChecker(final Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(final String word) {
        return false;
    }
    public List<String> suggestions(final String typo) {
        return Collections.emptyList();
    }
}

class Mosaic {
}

class Tile {
}

public class Item5DependencyInjection {
    public Mosaic create(Supplier<? extends Tile> tileFactory) {
        return null;
    }
}
