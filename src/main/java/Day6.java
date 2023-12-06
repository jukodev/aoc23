import java.util.Arrays;
import java.util.stream.Collectors;

public class Day6 {
    private void puzzle1(String[] lines){
        int sum = 1;
        int[] times = Arrays.stream(lines[0].split(": ")[1].trim().split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int[] distances = Arrays.stream(lines[1].split(": ")[1].trim().split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < times.length; i++) {
            int beats = 0;
            for (int j = 0; j < times[i]; j++) {
                if(j * (times[i] - j) > distances[i]) beats++;
            }
            sum *= beats;
        }
        System.out.println(sum);
    }

    private void puzzle2(String[] lines) {
        int sum = 1;
        long time = Long.parseLong(Arrays.stream(lines[0].split(": ")[1].trim().split(" ")).filter(s -> !s.isEmpty()).collect(Collectors.joining()));
        long distance = Long.parseLong(Arrays.stream(lines[1].split(": ")[1].trim().split(" ")).filter(s -> !s.isEmpty()).collect(Collectors.joining()));

        int beats = 0;
        for (long i = 0; i < time; i++) {
            if(i * (time - i) > distance) beats++;
        }
        sum *= beats;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        day6.puzzle2(InputReader.getLines(6));
    }
}
