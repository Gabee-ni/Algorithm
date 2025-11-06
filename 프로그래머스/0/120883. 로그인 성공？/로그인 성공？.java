class Solution {
    public String solution(String[] id_pw, String[][] db) {
        int cnt =0;
        for(int k=0; k<id_pw.length;k++){
            System.out.println(id_pw[0]);
            for(int i=0; i<db.length ;i++){
                //아이디가 동일한지 판별
                if(id_pw[0].equals(db[i][0])){
                    //비번까지 동일한지 판별
                    if(id_pw[1].equals(db[i][1])){
                        return "login";   
                    }else return "wrong pw";
                }
            }
        }
        return "fail";
    }
}