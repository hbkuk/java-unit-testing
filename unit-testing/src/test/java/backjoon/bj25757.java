package backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bj25757 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] line = scan.nextLine().split(" ");
        
        int applicantCount = Integer.parseInt(line[0]);
        int requiredPeopleCount = getRequiredPeopleCount(line[1]) - 1;
        
        Set<String> nameSet = new HashSet<>();
        for(int i = 0; i < applicantCount; i++) {
            nameSet.add(scan.nextLine());
        }
        
        int peopleCount = nameSet.size();
        int gameCount = 0;
        
        while(peopleCount >= requiredPeopleCount) {
            peopleCount -= requiredPeopleCount;
            gameCount ++;
        }
        
        System.out.println(gameCount);
    }
    
    public static int getRequiredPeopleCount(String value) {
        if(value.equals("Y")) {
            return 2;
        } else if(value.equals("F")) {
            return 3;
        } else {
            return 4;
        }
    }
}
