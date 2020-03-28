package chapter11;

import chapter10.Insurance;
import chapter5.Transaction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TestCompletableFuture {

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        RateService rateService = new RateService();
        Future<Double> futurePriceInUSD = CompletableFuture.supplyAsync(() -> insurance.getPrice())
                .thenCombine(CompletableFuture.supplyAsync(() -> rateService.getRate()),(price,rate) -> price * rate);
    }

}
