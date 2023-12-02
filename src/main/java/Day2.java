import java.util.HashMap;
import java.util.Map;

public class Day2 {
    private void puzzle1(String[] lines){
        Map<String, Integer> maxNumbers = new HashMap<>();
        maxNumbers.put("red", 12);
        maxNumbers.put("green", 13);
        maxNumbers.put("blue", 14);

        int sum = 0;
        for(int i = 0; i < 100; i++){
            String[] sets = lines[i].split(": ")[1].split("; ");
            boolean possible = true;

            for(var set : sets){
                if(!possible)break;
                String[] pulls = set.split(", ");
                for (var pull : pulls){
                    int num = Integer.parseInt(pull.split(" ")[0]);
                    String color = pull.split(" ")[1];
                    if(num > maxNumbers.get(color.trim())) {
                        possible = false;
                        break;
                    }
                }
            }
            if(possible) sum += i+1;
        }
        System.out.println(sum);
    }

    private void puzzle2(){

    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.puzzle1(InputReader.getLines(2));
    }
}
