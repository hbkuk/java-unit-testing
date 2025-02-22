package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class bj20006 {
    
    public static void main(String[] args) throws IOException {
        
        // TODO 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원
        
        List<Room> rooms = new LinkedList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            
            int level = Integer.parseInt(st.nextToken()); // 레벨
            String name = st.nextToken(); // 닉네임
            
            // 매칭 가능한 찾기
            boolean isJoined = false;
            for (Room r : rooms) {
                if (r.players.size() != m && level >= (r.baseLevel - 10) && (r.baseLevel + 10) >= level) {
                    r.players.add(new Player(level, name));
                    isJoined = true;
                    break;
                }
            }
            
            // 찾지 못한 경우 -> 새로운 방 만들기
            if (!isJoined) {
                List<Player> pList = new ArrayList<>();
                pList.add(new Player(level, name));
                
                Room r = new Room(level, pList);
                rooms.add(r);
            }
        }
        
        // completed 내부적으로.. 정렬 필요~
        for (Room r : rooms) {
            r.players.sort((o1, o2) -> o1.name.compareTo(o2.name));
        }
        
        StringBuilder sb = new StringBuilder();
        
        rooms.forEach(room -> {
            if (room.players.size() == m) { // 정원이 다 찬경우
                sb.append("Started!");
            } else {
                sb.append("Waiting!");
            }
            
            sb.append("\n");
            
            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        });
        
        System.out.println(sb);
    }
    
    static class Room {
        
        public int baseLevel;
        public List<Player> players;
        
        public Room(int baseLevel, List<Player> players) {
            this.baseLevel = baseLevel;
            this.players = players;
        }
        
        
    }
    
    static class Player {
        
        public int level;
        public String name;
        
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
    
}
