import java.util.*;

class Animal{
    int minNumber;
    int minArea;
    int maxArea;
    int cost;

    Animal(int mn, int minArea, int maxArea, int c) {
        minNumber = mn;
        this.minArea = minArea;
        this.maxArea = maxArea;
        cost = c;
    }
}

public class ZooDesign{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cH = s.nextInt();
        int cC = s.nextInt();
        int cA = s.nextInt();

        int mH = s.nextInt();
        int mC = s.nextInt();
        int mA = s.nextInt();

        int nH = s.nextInt();
        int aH = s.nextInt();

        int nC = s.nextInt();
        int aC = s.nextInt();

        int nA = s.nextInt();
        int aA = s.nextInt();

        int area = s.nextInt();

        ArrayList<Animal> z = new ArrayList<>();
        //n = min number
        //a = min area
        //m = max area
        //c = cost
        z.add(new Animal(nH, aH, mH, cH));
        z.add(new Animal(nC, aC, mC, cC));
        z.add(new Animal(nA, aA, mA, cA));
        Collections.sort(z, new Comparator<Animal> () {
            @Override
            public int compare(Animal a, Animal b) {
                return b.cost - a.cost;
            }
        });

        int a = z.get(0).minNumber * z.get(0).minArea;
        int b = z.get(1).minNumber * z.get(1).minArea;
        int c = z.get(2).minNumber * z.get(2).minArea;
        
        area = area - a - b - c;

        if(area > z.get(2).maxArea - c) {
            area = area + c - z.get(2).maxArea;
            c = z.get(2).maxArea;
        }
        else {
            c = c + area;
            area = 0;
        }

        if(area > z.get(1).maxArea - b) {
            area = area + b - z.get(1).maxArea;
            b = z.get(1).maxArea;
        }
        else {
            b = b + area;
            area = 0;
        }

        if(area > z.get(0).maxArea - a) {
            area = area + a - z.get(0).maxArea;
            a = z.get(1).maxArea;
        }
        else {
            a = a + area;
            area = 0;
        }
        int ans = a*z.get(0).cost + b*z.get(1).cost + c*z.get(2).cost;
        System.out.println(ans);
    }
}