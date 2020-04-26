package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PokedexNumberTest {
    @Test
    void 동등성보장() {
        final PokedexNumber actual = new PokedexNumber(1);
        assertThat(actual).isEqualTo(new PokedexNumber(1));
    }
}