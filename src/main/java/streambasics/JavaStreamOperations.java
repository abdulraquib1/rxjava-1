package streambasics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamOperations {

    public static void main(String[] args) throws IOException{



        // 1. Integer Stream

        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();
        // 2. Integer Stream with skip
        IntStream.range(1, 10).skip(5).forEach(p-> System.out.print(p + " "));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(IntStream.range(1,5).sum());

        // 4. Stream.of, sorted and findFirst
        System.out.println("*** 4. Stream.of, sorted and findFirst ***");
        Stream.of("Abdul","Raquib","Shayan","Raafay","Sabeeha")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);

        System.out.println();

        // 5. Stream from Array, sort, filter and print
        System.out.println("*** 5. Stream from Array, sort, filter and print ***");
        Stream.of("Abdul","Raquib","Shayan","Raafay","Sabeeha")
                .filter(p->p.startsWith("R"))
                .sorted()
                .forEach(p-> System.out.print(p + " "));
        System.out.println();

        // 6. average of squares of an int array
        System.out.println("*** 6. average of squares of an int array ***");
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x->x * 2)
                .average()
                .ifPresent(System.out::print);
        System.out.println();

        // 7. Stream from List, filter and print
        System.out.println("*** 7. Stream from List, filter and print ***");
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");

        people.stream()
                .map(x->x.toLowerCase())
                .filter(p->p.startsWith("a"))
                //.forEach(System.out::print);
                .forEach(p-> System.out.print(p + " "));
        System.out.println();

        // 8. Stream rows from text file, sort, filter, and print
        System.out.println("*** 8. Stream rows from text file, sort, filter, and print ***");
        Stream<String> bands1 = Files.lines(Paths.get("C:\\Users\\spaceman\\IdeaProjects\\rxjava-1\\src\\main\\java\\testdata\\bands.txt"));

        bands1.sorted().filter(x->x.length()>13).forEach(System.out::println);
        bands1.close();

        System.out.println();

        // 9. Stream rows from text file and save to List
        System.out.println("*** 9. Stream rows from text file and save to List ***");
        List<String> bands2Collection =
                Files.lines(Paths.get("C:\\Users\\spaceman\\IdeaProjects\\rxjava-1\\src\\main\\java\\testdata\\bands.txt"))
                .filter(x->x.contains("jit"))
                .collect(Collectors.toList());

        bands2Collection.forEach(System.out:: println);

        System.out.println();

        // 10. Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("C:\\Users\\spaceman\\IdeaProjects\\rxjava-1\\src\\main\\java\\testdata\\data.txt"));
        System.out.println("*** 10. Stream rows from CSV file and count ***");
       /* rows1.map(x -> x.split(","))
                .forEach(System.out:: println);*/


        int rowCount = (int)rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        System.out.println();
        // 11. Stream rows from CSV file, parse data from rows
        System.out.println("*** 11. Stream rows from CSV file, parse data from rows ***");
        Stream<String> rows2 = Files.lines(Paths.get("C:\\Users\\spaceman\\IdeaProjects\\rxjava-1\\src\\main\\java\\testdata\\data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();
        System.out.println();
        // 12. Stream rows from CSV file, store fields in HashMap
        System.out.println("*** 12. Stream rows from CSV file, store fields in HashMap ***");
        Stream<String> rows3 = Files.lines(Paths.get("C:\\Users\\spaceman\\IdeaProjects\\rxjava-1\\src\\main\\java\\testdata\\data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }
        System.out.println();
        // 13. Reduction - sum
        System.out.println("*** 13. Reduction - sum ***");

        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        // 14. Reduction - summary statistics

        System.out.println("***  14. Reduction - summary statistics ***");

        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

    }
}
