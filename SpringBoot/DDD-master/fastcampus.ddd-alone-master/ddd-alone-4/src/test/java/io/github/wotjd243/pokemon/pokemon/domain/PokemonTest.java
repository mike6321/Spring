package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    @DisplayName("`Pokemon`은 PokedexNumber, 닉네임을 가진다.")
    @Test
    void createPokemon() {
        new Pokemon(1, "이상해씨");
    }

    @DisplayName("`PokedexNumber`는 1부터 151까지이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 152})   //number 자리에 -1, 0, 152를 순서대로 넣어준다.
    void createPokedexNumber(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Pokemon(number, "치코리타"));
    }
}