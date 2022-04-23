import java.util.Scanner;
import java.util.Arrays;
public class Solution9 {
    public static void main(String[] args){
        
        Song[] sn = new Song[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<sn.length;i++){
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String artist = sc.nextLine();
            double duration = sc.nextDouble();
            sn[i] = new Song(id, title, artist, duration);
        }
        sc.nextLine();
        String artist1 = sc.nextLine();
        String artist2 = sc.nextLine();
        sc.close();

        double dur = findSongDurationForArtist(sn,artist1);
        if(dur == 0)
         System.out.println("There are no songs with given artist");
        else
         System.out.println(dur);

        Song[] result = getSongInAscendingOrder(sn,artist2);
        if(result[0]==null)
         System.out.println("There are no songs with given artist");
        else{
            for(int j=0;j<result.length;j++){
                System.out.println(result[j].getsongId());
                System.out.println(result[j].gettitle());
            }
        }

    }

    public static double findSongDurationForArtist(Song[] s,String artist){
        double sum = 0;
        for(int i=0;i<s.length;i++){
            if(artist.equalsIgnoreCase(s[i].getartist())){
                sum = sum + s[i].getduration();
            }
        }
        if(sum == 0)
        return 0;
        else
        return sum;
    }

    public static Song[] getSongInAscendingOrder(Song[] s, String artist){
        
        for(int i=0;i<s.length;i++){
            for(int j=1;j<s.length;j++){
                if(s[j].getduration()<s[j-1].getduration()){
                    Song temp = s[j];
                    s[j] = s[j-1];
                    s[j-1] = temp;
                }
            }
        }
        Song[] ans = new Song[0];
        for(int i=0;i<s.length;i++){
        if(artist.equalsIgnoreCase(s[i].getartist())){
            ans = Arrays.copyOf(ans , ans.length+1);
            ans[ans.length-1]=s[i];
        }
        }
    return ans;
    }
    

    
}

class Song{
    private int songId;
    private String title,artist;
    private double duration;

    Song(int songId,String title,String artist,double duration){
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    int getsongId(){
        return songId;
    }
    String gettitle(){
        return title;
    }
    String getartist(){
        return artist;
    }
    double getduration(){
        return duration;
    }
}
