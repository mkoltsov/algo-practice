class CF {

    public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
        () -> shop.getName() + " price is " +
                shop.getPrice(product)))
            .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }
//optinal executor
    private final Executor executor =
            Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                                     (Runnable r) -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

    CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
            shop.getPrice(product), executor);
);
//waiting for the future to complete
    Future<Double> futurePriceInUSD =
            CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(
                            CompletableFuture.supplyAsync(
                                    () ->  exchangeService.getRate(Money.EUR, Money.USD)),
                            (price, rate) -> price * rate
                    ))
            .orTimeout(3, TimeUnit.SECONDS);
//or providing a default value
    Future<Double> futurePriceInUSD =
            CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(
                            CompletableFuture.supplyAsync(
                                    () ->  exchangeService.getRate(Money.EUR, Money.USD))
                                    .completeOnTimeout(DEFAULT_RATE, 1, TimeUnit.SECONDS),      1
            (price, rate) -> price * rate
        ))
                .orTimeout(3, TimeUnit.SECONDS);

//printing out intemediate values
    long start = System.nanoTime();
    CompletableFuture[] futures = findPricesStream("myPhone27S")
            .map(f -> f.thenAccept(
                    s -> System.out.println(s + " (done in " +
                            ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
            .toArray(size -> new CompletableFuture[size]);
CompletableFuture.allOf(futures).join();
System.out.println("All shops have now responded in "
        + ((System.nanoTime() - start) / 1_000_000) + " msecs");
}
