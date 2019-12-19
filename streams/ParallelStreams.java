public class ParallelStreams {

    public static void main (String... args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
                "12");
    }

    class WordCounterSpliterator implements Spliterator<Character> {
        private final String string;
        private int currentChar = 0;
        public WordCounterSpliterator(String string) {
            this.string = string;
        }
        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(string.charAt(currentChar++));                      1
            return currentChar < string.length();                             2
        }
        @Override
        public Spliterator<Character> trySplit() {
            int currentSize = string.length() - currentChar;
            if (currentSize < 10) {
                return null;                                                  3
            }
            for (int splitPos = currentSize / 2 + currentChar;
                 splitPos < string.length(); splitPos++) {                4
                if (Character.isWhitespace(string.charAt(splitPos))) {        5
                    Spliterator<Character> spliterator =                      6
                    new WordCounterSpliterator(string.substring(currentChar,
                            splitPos));
                    currentChar = splitPos;                                   7
                    return spliterator;                                       8
                }
            }
            return null;
        }
        @Override
        public long estimateSize() {
            return string.length() - currentChar;
        }
        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NON-NULL + IMMUTABLE;
        }
    }
}
