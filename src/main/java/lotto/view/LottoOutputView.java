package lotto.view;

import static lotto.view.ViewMessage.BOUGHT_LOTTO;
import static lotto.view.ViewMessage.PROFIT_RATE;
import static lotto.view.ViewMessage.WINNER_RESULT;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.constants.Reward;

public class LottoOutputView implements View {
    LottoOutputView() {
    }

    public void printPublishedLotto(Integer count, String lottoList) {
        System.out.println(BOUGHT_LOTTO.getMessage(count, lottoList));
    }

    public void printWinningResult(Map<Integer, Integer> rankCount) {
        StringBuilder print = new StringBuilder();
        print.append(WINNER_RESULT.getMessage());
        String result = Arrays.stream(Reward.values())
                .map(reward -> reward.getMessage(rankCount.getOrDefault(reward.getRank(), 0)))
                .collect(Collectors.joining("\n"));
        print.append(result);
        System.out.println(print);
    }

    public void printProfitRate(Double profitRate) {
        System.out.print(PROFIT_RATE.getMessage(profitRate));
    }
}
