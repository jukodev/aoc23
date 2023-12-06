import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;


public class Day5 {

    private void puzzle1(String file){
        String[] parts = file.split("map:\r\n");
        long[] seeds = Arrays.stream(parts[0].split(": ")[1].split("\r\n\r\n")[0].split(" ")).mapToLong(Long::parseLong).toArray();

        List<Mapping>[] mappings = new List[parts.length-1];
        for (int i = 0; i < parts.length -1; i++) {
            mappings[i] = Arrays.stream(parts[i+1].split("\r\n\r\n")[0].split("\r\n")).map(Mapping::new).toList();
        }
        long lowestPos = Long.MAX_VALUE;
        for(long seed : seeds){
            lowestPos = getLowestPos(mappings, lowestPos, seed);
        }
        System.out.println(lowestPos);
    }

    private long getLowestPos(List<Mapping>[] mappings, long lowestPos, long current) {
        for (var mapping : mappings) {
            for (var entry : mapping) {
                if (entry.contains(current)) {
                    current = entry.getTranslated(current);
                    break;
                }
            }
        }
        if (current < lowestPos) {
            lowestPos = current;
        }
        return lowestPos;
    }

    // Absolutely horrible brute force algorithm, but it works
    private void puzzle2(String file){
        String[] parts = file.split("map:\r\n");
        long[] seeds = Arrays.stream(parts[0].split(": ")[1].split("\r\n\r\n")[0].split(" ")).mapToLong(Long::parseLong).toArray();

        List<Mapping>[] mappings = new List[parts.length-1];
        for (int i = 0; i < parts.length -1; i++) {
            mappings[i] = Arrays.stream(parts[i+1].split("\r\n\r\n")[0].split("\r\n")).map(Mapping::new).toList();
        }
        long lowestPos = Long.MAX_VALUE;
        for (int i = 0; i < seeds.length; i+=2) {
            for (int j = 0; j < seeds[i+1]; j++) {
                long current = seeds[i]+j;
                lowestPos = getLowestPos(mappings, lowestPos, current);
            }
        }
        System.out.println(lowestPos);
    }
    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.puzzle1(InputReader.getFile(5));
    }

    class Mapping{
        public long source;
        public long destination;
        public long range;
        public boolean contains(long num){
            return source <= num && source + range > num;
        }

        public long getTranslated(long num) {
            return destination + (num - source);
        }

        public Mapping(String line){
            String[] parts = line.trim().split(" ");
            destination = Long.parseLong(parts[0]);
            source = Long.parseLong(parts[1]);
            range = Long.parseLong(parts[2]);
        }
    }
}
