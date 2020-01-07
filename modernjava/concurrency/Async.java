public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
        double price = calculatePrice(product);
        futurePrice.complete(price);
        }).start();
        return futurePrice;
        }

        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");   1
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
        + " msecs");
// Do some more tasks, like querying other shops
        doSomethingElse();
// while the price of the product is being calculated
        try {
        double price = futurePrice.get();                                     2
        System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
        try {
        double price = calculatePrice(product);
        futurePrice.complete(price);                   1
        } catch (Exception ex) {
        futurePrice.completeExceptionally(ex);         2
        }
        }).start();
        return futurePrice;
        }

public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
        }