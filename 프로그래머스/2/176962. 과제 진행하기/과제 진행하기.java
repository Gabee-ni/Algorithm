import java.util.*; 
class Solution {
    static class Task {
        String name;
        int remainTime; 
        
        Task(String name, int remainTime){
            this.name = name;
            this.remainTime = remainTime; 
        }
    }
    
    private int toMinute (String time){
        String[] parts = time.split(":"); 
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]); 
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>(); 
        Deque<Task> stack = new ArrayDeque<>(); 
        
        Arrays.sort(plans, (a,b)->a[1].compareTo(b[1]));
        
        for(int i=0; i<plans.length-1; i++){
            String curName = plans[i][0];
            int curStart = toMinute(plans[i][1]);
            int curPlayTime = Integer.parseInt(plans[i][2]); 
            
            int nextStart = toMinute(plans[i+1][1]);
            
            int availableTime = nextStart - curStart; 
            
            //다음 과제 시작 전까지 현 과제를 끝내지 못하는 경우
            if(curPlayTime > availableTime){
                int remainTime = curPlayTime - availableTime;
                stack.push(new Task(curName, remainTime)); 
                continue;
            }
            
            //현 과제를 완료한 경우
            answer.add(curName);
            
            //다음 과제 시작 전까지 남은 시간
            int spareTime = availableTime - curPlayTime; 
            //남은 시간 동안 중단된 과제 재개
            while (spareTime > 0 && !stack.isEmpty()){
                Task pausedTask = stack.pop(); 
                //그 시간 안에 이전 과제를 완료할 수 있는 경우
                if(pausedTask.remainTime <= spareTime){
                    spareTime -= pausedTask.remainTime; 
                    answer.add(pausedTask.name);
                } else {
                //아닌 경우 (일부만 수행 -> 다시 중단)
                    pausedTask.remainTime -= spareTime; 
                    stack.push(pausedTask); 
                    spareTime = 0;
                }
            }
        }
        //마지막 예약 과제는 이후 새로운 과제가 시작되는 경우가 없으니 완료처리 
        answer.add(plans[plans.length -1][0]); 
        
        
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
}