package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLottos;
import lotto.util.constants.Reward;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class ConfirmWinningService implements Service {
    private final LottoOutputView lottoOutputView;
    private Long reward;

    ConfirmWinningService(View lottoOutputView) {
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
        reward = 0L;
    }

    public void confirmWinning(PublishedLottos publishedLottos, LottoBonusPair winnerNumberPair) {
        List<Integer> rankList = winnerNumberPair.getResults(publishedLottos);
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (Integer rank:rankList) {
            if (hasWon(rank)) {
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
                addReward(rank);
            }
        }
        lottoOutputView.printWinningResult(rankCount);
    }

    public Long getTotalReward() {
        return this.reward;
    }

    private boolean hasWon(Integer rank) {
        return rank <= 5;
    }

    private void addReward(Integer rank) {
        reward += Reward.fromRank(rank);
    }
}
