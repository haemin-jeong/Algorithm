package programmers.level2;

import java.util.*;

public class 오픈채팅방 {
    static class Message {
        String status;
        String id;

        public Message(String status, String id) {
            this.status = status;
            this.id = id;
        }
    }

    public String[] solution(String[] record) {
        //리스트에 메시지의 종류(Enter 또는 Leave)와 id 값을 저장한다.
        List<Message> messages = new ArrayList<>();

        //맵에 아이디와 그에 맞는 닉네임을 저장한다.
        Map<String, String> map = new HashMap(); //key: 아이디, value: 닉네임

        for(String s : record) {
            StringTokenizer st = new StringTokenizer(s);

            String status = st.nextToken();
            String id = st.nextToken();

            //채팅방에 입장하거나 닉네임을 변경하면 닉네임을 갱신한다.
            if(!status.equals("Leave")) {
                String nickname = st.nextToken();
                map.put(id, nickname);
            }

            //채팅방에 입장하거나 떠나는 경우 메시지의 종류와 아이디를 추가한다.
            if(!status.equals("Change")) {
                messages.add(new Message(status, id));
            }
        }

        //리스트에 저장해놓은 메시지 종류(Enter or Leave)와 아이디, 맵에 저장해놓은 아이디와 닉네임을 매칭시켜서 최종 메시지를 생성한다.
        String[] answer = new String[messages.size()];

        for(int i = 0 ; i < messages.size(); i++) {
            String temp = map.get(messages.get(i).id) + "님이 ";

            if(messages.get(i).status.equals("Enter")) {
                temp += "들어왔습니다.";
            } else {
                temp += "나갔습니다.";
            }

            answer[i] = temp;
        }

        return answer;
    }
}
