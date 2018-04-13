package Mock;

/**
 * Created by shengchao wu on 9/7/2017.
 */
public class Soul {
    private String song;

    public void singing(String song ) {
        setSong(song + "god");
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
