import java.util.*;

class Student{
    public int idx;
    public double avg; 
    
    Student(int idx, double avg){
        this.idx = idx;
        this.avg = avg;
    }
    
    public int getIdx(){
        return idx;
    }
    public double getAvg(){
        return avg;
    }
    public String toString(){
        return idx+ " "+ avg;
    }
}

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
    
        Student[] student = new Student[score.length];
        for(int i=0; i<score.length; i++){
            int num =0; 
            for(int j=0; j<score[i].length ; j++){
                num += score[i][j];
            }
            double avg = (double) num/score[i].length;// 실수 : 처음에 전체 학생으로 나눔.
            student[i] = new Student(i,avg);
        }
        
        Arrays.sort(student, (x, y)-> {
            return  Double.compare(y.avg,x.avg);
        });
        
        int rank =0; 
        int cnt=1;
        double beforeScore = 0;
        // if(student[1].getAvg() == student[2].getAvg()) System.out.println("hihi");
        for(int i=0; i<student.length ; i++){
            if(beforeScore==student[i].getAvg()) {
                cnt+=1;
                answer[student[i].getIdx()] = rank;
            }else{
                rank += 1*cnt;
                answer[student[i].getIdx()] = rank;
                cnt =1;
            }
            beforeScore = student[i].getAvg();
        }
      
        return answer;
    }
}

