public class Jooq {
    public static void main(String...args) {
        Class.forName("org.h2.Driver");
        try (Connection c =
                     getConnection("jdbc:h2:~/sql-goodies-with-mapping", "sa", "")) {   1
            DSL.using(c)                                                          2
                    .select(BOOK.AUTHOR, BOOK.TITLE)                                   3
                    .where(BOOK.PUBLISHED_IN.eq(2016))
                    .orderBy(BOOK.TITLE)
                    .fetch()                                                                4
                    .stream()                                                               5
                    .collect(groupingBy(                                                    6
                            r -> r.getValue(BOOK.AUTHOR),
                            LinkedHashMap::new,
                            mapping(r -> r.getValue(BOOK.TITLE), toList())))
                    .forEach((author, titles) ->                                       7
                            System.out.println(author + " is author of " + titles));
        }
    }
}
