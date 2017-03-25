
public class BASIC_2_Enum {

	public static void main(String[] args) {
		boolean[] binary = new boolean[5];
		enumSet(binary, 0, 5);
	}

	public static void enumSet(boolean[] binary, int pos, int end) {
		if(pos == end){
			for(int i = 0;i < binary.length;i++){
				if(binary[i]){
					System.out.print("1");
				}else{
					System.out.print("0");
				}
			}
			System.out.println();
			return;
		}
		
		binary[pos] = false;
		enumSet(binary, pos + 1, end);
		binary[pos] = true;
		enumSet(binary, pos + 1, end);
	}
}
