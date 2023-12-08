import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day8 {

    private void puzzle1(String[] lines){
        Map<String, Destination> map = new HashMap<>();
        for(int i = 2; i < lines.length; i++){
            String[] split = lines[i].split(" = ");
            map.put(split[0], new Destination(split[1]));
        }
        String current = "AAA";
        int count = 0;
        while (!current.equals("ZZZ")){
            current = map.get(current).getNext(lines[0].charAt(count % (lines[0].length() - 1)));
            count++;
        }
        System.out.println(count);
    }

    private void puzzle2(String[] lines){
        Map<String, Destination> map = new HashMap<>();
        ArrayList<String> starts = new ArrayList<>();
        for(int i = 2; i < lines.length; i++){
            String[] split = lines[i].split(" = ");
            map.put(split[0], new Destination(split[1]));
            if(split[0].charAt(2) == 'A'){
                starts.add(split[0]);
            }
        }
        String[] currents = starts.toArray(String[]::new);
        int[] firstZCount = new int[currents.length];
        Arrays.fill(firstZCount, 0);
        int count = 0;

        int foundAmount = 0;
        while (foundAmount < currents.length){
            for (int i = 0; i < currents.length; i++) {
                if(currents[i].endsWith("Z")){
                    firstZCount[i] = count;
                    foundAmount++;
                }
                currents[i] = map.get(currents[i]).getNext(lines[0].charAt((int) (count % (lines[0].length() - 1))));
            }
            count++;

        }

        long result = firstZCount[0];
        for(int i = 1; i < firstZCount.length; i++){
            result = lcm(result, firstZCount[i]);
        }

        System.out.println(result);
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static void main(String[] args) {
        Day8 day8 = new Day8();
        day8.puzzle2(InputReader.getLines(8));
    }

    private static class Destination{
        private String left;
        private String right;
        public String getNext(char c){
            if (c == 'R')
                return right;
            else if(c == 'L')
                return left;
            else throw new RuntimeException("fail");
        }
        public Destination(String input){
            String[] split = input.substring(1, 9).split(", ");
            left = split[0];
            right = split[1];
        }
    }
}
