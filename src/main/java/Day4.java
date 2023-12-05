import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4 {

    private void puzzle1(String[] lines){
        int total = 0;
        for(var line : lines){
            String[] input = line.split(": ")[1].split(" \\| ");
            Set<Integer> winningNumbers = Arrays.stream(input[0].split(" ")).filter(s -> !s.equals(" ") && !s.isEmpty()).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            long hits = Arrays.stream(input[1].trim().split(" ")).filter(s -> !s.equals(" ") && !s.isEmpty()).mapToInt(Integer::parseInt).filter(winningNumbers::contains).count();
            if (hits == 0) continue;
            int points = (int) Math.pow(2, hits - 1);
            total += points;
        }
        System.out.println(total);
    }

    private void puzzle2(String[] lines){
        int[] cardCounts = new int[lines.length];
        Arrays.fill(cardCounts, 1);
        for(int i = 0; i < lines.length; i++){
            String[] input = lines[i].split(": ")[1].split(" \\| ");
            Set<Integer> winningNumbers = Arrays.stream(input[0].split(" ")).filter(s -> !s.equals(" ") && !s.isEmpty()).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            long hits = Arrays.stream(input[1].trim().split(" ")).filter(s -> !s.equals(" ") && !s.isEmpty()).mapToInt(Integer::parseInt).filter(winningNumbers::contains).count();
            for (int j = 0; j < cardCounts[i]; j++) {
                for (int offset = 1; offset < hits + 1; offset++) {
                    cardCounts[i + offset]++;
                }
            }
        }
        System.out.println(Arrays.stream(cardCounts).sum());
    }
    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.puzzle2(InputReader.getLines(4));
    }
}
