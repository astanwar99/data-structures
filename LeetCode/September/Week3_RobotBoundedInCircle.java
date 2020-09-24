import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String instructions = s.nextLine();

        int x = 0, y = 0, d = 0;
        boolean flag = false;
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < instructions.length(); j++) {
                if(instructions.charAt(j) == 'G') {
                    if(d % 2 == 0) {
                        x += d - 1;
                    }
                    else {
                        y += d - 2;
                    }
                    System.out.print("(" + x + ", " + y + ") -> ");
                }
                else if(instructions.charAt(j) == 'L') {
                    d = (d + 3) % 4;
                }
                else {
                    d = (d + 1) % 4;
                }
                
            }
            if(x == 0 && y == 0) {
                flag = true;
                break;
            }
        }

        System.out.println(flag);
    }
}