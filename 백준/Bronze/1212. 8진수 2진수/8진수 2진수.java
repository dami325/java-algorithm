import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    
    // 8진수에서 가능한 0~7
    static String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        String octal = br.readLine();
        
        // 0 처리
        if(octal.equals("0")) {
            sb.append(0);
        }else {
            // 숫자화 -> 앞에 붙은 0 제거
            sb.append(Integer.parseInt(binary[octal.charAt(0)-'0']));
            for(int i = 1; i < octal.length(); i++) {
                sb.append(binary[octal.charAt(i)-'0']);
            }            
        }
        
        
        System.out.println(sb);
        br.close();
    }
 
}