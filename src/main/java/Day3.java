public class Day3 {
    private void puzzle1(String[] lines){
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            boolean currentIsAdjacent = false;
            StringBuilder currentNumber = new StringBuilder();
            for (int j = 0; j < lines[i].length(); j++) {
                char currentChar = lines[i].charAt(j);
                if(Character.isDigit(currentChar)){
                    currentNumber.append(currentChar);
                    if(!currentIsAdjacent){
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if(i + k < 0 || i + k >= lines.length || j + l < 0 || j + l >= lines[i].length()) continue;
                                char checkedChar = lines[i+k].charAt(j+l);
                                if(!Character.isDigit(checkedChar) && checkedChar != '.'){
                                    currentIsAdjacent = true;
                                    break;
                                }
                            }
                            if(currentIsAdjacent)
                                break;
                        }
                    }

                } else if (!currentNumber.isEmpty()) {
                    if(currentIsAdjacent) {
                        sum += Integer.parseInt(currentNumber.toString());
                        System.out.println(currentNumber + " " + sum);
                    }
                    currentNumber = new StringBuilder();
                    currentIsAdjacent = false;
                }
            }
            if (!currentNumber.isEmpty()) {
                if (currentIsAdjacent) {
                    sum += Integer.parseInt(currentNumber.toString());
                    System.out.println(currentNumber);
                }
            }
        }
        System.out.println(sum);
    }

    private void puzzle2(String[] lines){
        int sum = 0;
        for (int i = 1; i < lines.length - 1; i++) {
            for (int j = 1; j < lines[i].length()-1; j++) {
                char currentChar = lines[i].charAt(j);
                if(currentChar == '*'){
                    int numberCount = 0;
                    boolean currentStreak = false;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if(Character.isDigit(lines[i+k].charAt(j+l))){
                                currentStreak = true;

                            }else{
                                currentStreak = false;
                            }
                        }
                    }
                }

            }
        }
    }


    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.puzzle1(InputReader.getLines(3));
    }
}
