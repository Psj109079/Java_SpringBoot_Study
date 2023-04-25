package sa;

class Solution {
    public static long[] solution(int n, int m) {
        long[] answer = new long[2];
        
        for(int i = 2; i <= n; i++) {
        	if(n % i == 0 && m % i == 0) {
        		answer[0] = i;
        		break;
        	}
        }        	
        
        if(answer[0] == 0) {
        	answer[0] = 1;
        }
        answer[1] = n * m / answer[0];
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 1;
		int m = 4214;
		long[] a = solution(n, m);
		
		System.out.println("최대공약수 " + a[0]);
		System.out.println("최소공배수 " + a[1]);
	}
}

