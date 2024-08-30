// Noob Approach 
class Solution {
    public double myPow(double x, int n) {
        return (double)(Math.pow(x, n));
    }
}

// Brute Force
// TC: O(N)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // Handling negative power
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double ans = 1;

        for(int i=0; i<n; i++){
            ans *= x;
        }

        return ans;
    }
}

// Optimal Approach
// TC: O(log n)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;

        long nn = n;

        if(nn < 0){
            x = 1/x;
            nn = -nn;
        }

        while(nn > 0){
            if(nn % 2 == 1){
                ans *= x;
                nn = nn - 1;
            }else{
                x *= x;
                nn = nn/2;
            }
        }

        return ans;
    }
}

// Bit Manipulation approach
// TC: O(log n)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        
        return result;
    }
}