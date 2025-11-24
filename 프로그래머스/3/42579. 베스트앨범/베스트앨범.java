import java.util.*;
//고유번호, 재생횟수, 장르를 담는 song 객체 
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
        //해당 장르가 몇개 있는지 카운팅 하려고 선언한 map
        Map<String, Integer> genreCount = new HashMap<>();
        //장르 별 총 재생횟수를 카운팅하고 횟수 별로 내림차순 정렬하기 위한 map 
        Map<String, Integer> map = new HashMap<>();
        //노래 객체를 담을 리스츠 
        List<Song> songList = new ArrayList<>();
        
        for(int i=0; i< genres.length; i++){
            //장르별 노래 개수 카운팅 
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i],0)+1);
            //장르별 총 재생 횟수 카운팅
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
            //노래 객체 리스트 
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
        
        //답을 담을 리스트 
        List<Integer> answer = new ArrayList<>();
        //장르별로 노래를 2개씩 실을 수 있음.
        //장르별로 순회하면서 노래가 해당 장르인지 판별하고, 
        //만약 장르에 곡이 1개만 있을 경우는 바로 리스트에 담는다.
        //1개가 아니라 2개 이상인 경우는 베스트 2곡만 담을 수 있도록 temp arr를 생성한 후 추후 list에 담아준다. 
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
        //답변을 arr 형식으로 반환해야 하므로 stream을 이용해 list -> array 변환 
        return answer.stream().mapToInt(i->i).toArray();
    }
}