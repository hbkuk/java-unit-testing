package backjoon;

import java.util.Scanner;

public class bj2816 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine());
        String[] channels = new String[N];
        
        for(int i = 0; i < N; i++) {
            channels[i] = scan.nextLine();
        }
        scan.close();
        
        StringBuilder sb = new StringBuilder();
        
        String firstChannel = "KBS1";
        String secondChannel = "KBS2";
        
        int cursor = 0;
        
        int firstIdx = 0;
        for(int i = 0; i < channels.length; i++) {
            if(channels[i].equals(firstChannel)) {
                firstIdx = i;
            }
        }
        
        for(int i = firstIdx - cursor; i > 0; i--) {
            String tempStr = channels[i];
            channels[i] = channels[i - 1];
            channels[i - 1] = tempStr;
            
        }
        
        sb.append("1".repeat(firstIdx - cursor));
        sb.append("4".repeat(firstIdx - cursor));
        
        int secondIdx = 0;
        for(int i = 0; i < channels.length; i++) {
            if(channels[i].equals(secondChannel)) {
                secondIdx = i;
            }
        }
        
        sb.append("1".repeat(secondIdx - cursor));
        sb.append("4".repeat(secondIdx - cursor - 1));
        
        System.out.println(sb);
    }
    
}
