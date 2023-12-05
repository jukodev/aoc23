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
                    StringBuilder[] numbers = new StringBuilder[2];
                    numbers[0] = new StringBuilder();
                    numbers[1] = new StringBuilder();
                    boolean currentStreak = false;
                    for (int k = -1; k <= 1; k++) {
                        currentStreak = false;
                        for (int l = -1; l <= 1; l++) {

                            if(Character.isDigit(lines[i+k].charAt(j+l))){
                                if(currentStreak){
                                    continue;
                                }
                                currentStreak = true;
                                numberCount++;
                                if(numberCount > 2)break;
                                int offSet = 1;
                                while (lines[i+k].length() > j+l+offSet && Character.isDigit(lines[i+k].charAt(j+l+offSet))){
                                    numbers[numberCount-1].append(lines[i+k].charAt(j+l+offSet));
                                    offSet++;
                                }
                                offSet = -0;
                                while (j+l+offSet >= 0 && Character.isDigit(lines[i+k].charAt(j+l+offSet))){
                                    numbers[numberCount-1].insert(0, lines[i+k].charAt(j+l+offSet));
                                    offSet--;
                                }

                            }else{
                                currentStreak = false;
                            }
                        }
                    }
                    if(numberCount != 2)continue;
                    sum += Integer.parseInt(numbers[0].toString()) * Integer.parseInt(numbers[1].toString());
                }

            }
        }

        System.out.println(sum);
    }


    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.puzzle2(InputReader.getLines(3));
    }
}
