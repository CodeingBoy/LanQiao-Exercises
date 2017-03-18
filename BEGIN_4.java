import java.util.Scanner;

public class BEGIN_4 {
	private static int[] mods = new int[1000000+1];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for(int i = 0;i < mods.length;i++){
			mods[i] = -1;
		}
		
		for(int i = 1;i < mods.length;i++){
			fibonacci_mod(i);
		}
		
		mods[1] = 1;
		mods[2] = 1;
		
		System.out.println(fibonacci_mod(n));
	}

	private static int fibonacci_mod(int n) {
		if(mods[n] >= 0)return mods[n];
		
		if (n == 1 || n == 2)
			return 1;
		
		int fibo_a = fibonacci_mod(n - 1);
		int fibo_b = fibonacci_mod(n - 2);
		if(mods[n-1] == -1){
			mods[n-1] = fibo_a;
		}
		
		if(mods[n-2] == -1){
			mods[n-2] = fibo_b;
		}
		
		return (fibo_a + fibo_b) % 10007;
	}

	private static int fibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
