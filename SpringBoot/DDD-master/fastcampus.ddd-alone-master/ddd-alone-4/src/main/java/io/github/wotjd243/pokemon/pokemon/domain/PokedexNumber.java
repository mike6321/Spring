package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class PokedexNumber {
    //번호 확장 시 포멧몬 클래스를 수정하는 것이 아니라 도감 클래스에서 수정을 하는 것이다. 즉, 역할과 책임을 나눈 것이다.
    private static final int MAX_NUMBER = 151;
    private static final int MIN_NUMBER = 1;

    private final int number;

    public PokedexNumber(final int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }


    //주소가 달라도 값이 같으면 true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokedexNumber that = (PokedexNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
