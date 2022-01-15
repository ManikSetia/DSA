package Array.Level1.BinarySearch;

public class SquareRootUptoGivenPrecision {
    private static float mySqrt(int number, int precision){

        //Approach1: Using built-in function
        // return (int)Math.sqrt(x);

        //Approach2: Binary search
        long low=0, high=number;

        long nearestSquare=-1;
        while(low<=high){
            long mid=low+(high-low)/2;

            long square=mid*mid;
            if(square<number) {
                low=mid+1;
                nearestSquare=mid;
            }
            else if(square>number) high=mid-1;
            else return (int)mid;
        }

        double ans=nearestSquare;//ans will store the result with precision
        double increment=0.1;
        while(precision!=0){
            ans += increment;
            double square=ans*ans;
            while(square<number) {
                ans += increment;
                square=ans*ans;
            }

            ans -= increment;
            increment /= 10;
            precision--;
        }
        return (float) ans;
    }
    public static void main(String[] args) {
        int number=50;
        int precision=3;
        System.out.println("Square root of "+number+" with precision: "+mySqrt(number, precision));
    }
}
