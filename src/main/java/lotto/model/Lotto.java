package lotto.model;

import static lotto.util.exception.ErrorMessage.HAS_DUPLICATE_NUMBER;
import static lotto.util.exception.ErrorMessage.NOT_SIX_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public Integer compare(Lotto other) {
        Integer count = 0;
        for (Integer number:other.numbers) {
            if (this.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }

    private void validate(List<Integer> numbers) {
        if (notSixNumbers(numbers)) {
            throw LottoException.of(NOT_SIX_NUMBERS);
        }

        if (hasDuplicateNumber(numbers)) {
            throw LottoException.of(HAS_DUPLICATE_NUMBER);
        }
    }

    private boolean notSixNumbers(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number:numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}
