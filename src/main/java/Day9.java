import java.util.Arrays;

public class Day9 {

    private void puzzle1(String[] lines){
        long sum = 0;
        for(var line : lines){
            int[] nums = Arrays.stream(line.trim().split(" ")).filter(i -> !i.isEmpty()).mapToInt(Integer::parseInt).toArray();
            sum += getNextElement(nums);
        }
        System.out.println(sum);
    }

    private void puzzle2(String[] lines){
        long sum = 0;
        for(var line : lines){
            int[] nums = Arrays.stream(line.trim().split(" ")).filter(i -> !i.isEmpty()).mapToInt(Integer::parseInt).toArray();
            sum += getLastElement(nums);
        }
        System.out.println(sum);
    }

    private long getLastElement(int[] nums){
        int[] diffs = new int[nums.length -1];
        for (int i = 1; i < nums.length; i++) {
            diffs[i-1] = nums[i] - nums[i-1];
        }
        if(Arrays.stream(diffs).allMatch(d -> d == 0)){
            return nums[0];
        }
        else return nums[0] - getLastElement(diffs);
    }

    private long getNextElement(int[] nums){
        int[] diffs = getDiff(nums);
        if(Arrays.stream(diffs).allMatch(d -> d == 0)){
            return nums[0];
        }
        else return nums[nums.length - 1] + getNextElement(diffs);
    }

    private int[] getDiff(int[] nums){
        int[] diffs = new int[nums.length -1];
        for (int i = 1; i < nums.length; i++) {
            diffs[i-1] = nums[i] - nums[i-1];
        }
        return diffs;
    }
    public static void main(String[] args) {
        Day9 day9 = new Day9();
        day9.puzzle2(InputReader.getLines(9));
    }
}
