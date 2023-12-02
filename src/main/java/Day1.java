public class Day1 {

    private void puzzle1(String[] input){
        int sum = 0;
        for (String str : input) {
            char first = 'n', last = 'n';
            for(int i = 0; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    if(first == 'n') {
                        first = str.charAt(i);
                    }
                    last = str.charAt(i);
                }
            }
            sum += Integer.parseInt(first + "" + last);
        }
        System.out.println(sum);
    }

    private void puzzle2(String[] input){
        int sum = 0;
        String[] nums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (String str : input) {
            char first = 'n', last = 'n';
            for(int i = 0; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    if(first == 'n'){
                        first = str.charAt(i);
                    }
                    last = str.charAt(i);
                }else{
                    for (int j = 0; j < 9; j++) {
                        String sub = str.substring(i);
                        if (sub.length() >= nums[j].length() && sub.startsWith(nums[j])){
                            if(first == 'n'){
                                first = (char) ('0' + (char)(j+1));
                            }
                            last = (char) ('0' + (char)(j+1));
                            break;

                        }
                    }
                }
            }
            sum += Integer.parseInt(first + "" + last);
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.puzzle2(InputReader.getLines(1));
    }
}
