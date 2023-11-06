package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublishedLottos {
    private final List<Lotto> publishedLottos;

    PublishedLottos(Integer money) {
        publishedLottos = new ArrayList<>();
        publishLottos(money);
    }

    public static PublishedLottos getInstance(Integer money) {
        return new PublishedLottos(money);
    }

    public Integer getCount() {
        return publishedLottos.size();
    }

    @Override
    public String toString() {
        return publishedLottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    List<Lotto> getPublishedLottos() {
        return publishedLottos;
    }

    private void publishLottos(Integer money) {
        while (money > 0) {
            money -= 1000;
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            publishedLottos.add(new Lotto(numbers));
        }
    }
}
