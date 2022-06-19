import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
    public static void main(String[] args) {
        checkMagazine(Arrays.asList("attack", "at", "dawn"),Arrays.asList("Attack", "at", "dawn"));
        checkMagazine(Arrays.asList("give", "me", "one", "grand", "today", "night"),Arrays.asList("give", "one", "grand", "today"));
        checkMagazine(Arrays.asList("apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg"),Arrays.asList("elo lxkvg bg mwz clm w\n"));
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> source = extracted(magazine);
        Map<String, Integer> dest = extracted(note);
        System.out.println(dest.size()==dest.entrySet().stream().filter(e->source.get(e.getKey())!=null && source.get(e.getKey())>=e.getValue()).count() ? "Yes":"No");
    }

    private static Map<String, Integer> extracted(List<String> magazine) {
        return magazine.stream().collect(Collectors.toMap(String::intern, i->1, Integer::sum));
    }

}
