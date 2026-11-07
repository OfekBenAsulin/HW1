import java.util.Arrays;

public class Assignment01Q04 {
    private static boolean isValidParm(int len, char direction){
        if(len==0){
            return false;
        }
        return (direction == 'R') || (direction == 'L');
    }
    private static char normalizeDir(char dir){
        return switch (dir) {
            case 'R' -> 'L';
            case 'L' -> 'R';
            default -> 'i';
        };
    }
    private static void shift(int[] newArr,int[] array, char direction,int len,int move){
        switch(direction){
            case 'R':
                for(int i =0; i<len; i++) {
                    newArr[(i + move) % len] = array[i];
                }
                break;
            case 'L':
                for(int i = 0; i<len; i++) {
                    newArr[(i - move + len) % len] = array[i];// normalizes i-move so % result is always positive
                }
                break;
        }
    }
    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int len = array.length;
        if(!isValidParm(len,direction))
            return array;
        if(move<0){
            direction = normalizeDir(direction);
            move *=(-1);
        }
        move = move % len;
        int[] newArray = new int[len];
        shift(newArray,array,direction,len,move);
        System.arraycopy(newArray,0,array,0,len);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}