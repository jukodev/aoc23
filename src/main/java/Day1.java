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
        for (String str : input) {
            char first = 'n', last = 'n';
            for(int i = 0; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    if(first == 'n'){
                        first = str.charAt(i);
                    }
                    last = str.charAt(i);
                }
            }
            sum += Integer.parseInt(first + "" + last);
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.puzzle1(InputReader.getLines(1));
    }
}
