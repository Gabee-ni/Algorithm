import java.util.*;
class Song{
    public int idx;
    public int play;
    public String genre;
    
    Song(int idx, int play, String genre){
        this.idx= idx;
        this.play = play;
        this.genre = genre;
    }
    
    public String toString(){
        return idx+" "+play+" "+genre;
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
   
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        
        for(int i=0; i< genres.length; i++){
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i],0)+1);
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
            songList.add(new Song(i,plays[i],genres[i]));
            
        }
        //재생 순으로 노래 리스트 정렬
        Collections.sort(songList, (o1, o2)->{
            return o2.play - o1.play;  
        });
        
        //재생 수가 더 많은 장르로 map 정렬 
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2)->{
            return map.get(o2).compareTo(map.get(o1));
        });
        
        //idx 출력
        List<Integer> answer = new ArrayList<>();
        for(String genre : keySet){
            if(genreCount.get(genre)<2){
                for(Song s : songList){
                    if(s.genre.equals(genre)){
                        answer.add(s.idx);
                    }
                }
            }else{
                int[] temp = new int[2];
                int idx=0;
                for(Song s : songList){
                    if(s.genre.equals(genre)){
                        if(idx<2) temp[idx++] = s.idx;
                        else break;    
                    }
                }
                for(int num : temp)
                    answer.add(num);
            }  
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}