package lianxi;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MP3Player {
	public String path;// 音乐路径 可以是磁盘路径c\b.mp3 需要写成c\\b.mp3
    public boolean loop;// 是否循环
    public AdvancedPlayer ap;
    public InputStream is;// 文件流

    public MP3Player(String path, boolean loop) {
        this.path = path;
        this.loop = loop;
        try {
            is = new FileInputStream(path);//创建文件流，读取音乐
        } catch (FileNotFoundException e) {
            System.out.println("没有找到该文件！");
            e.printStackTrace();
        }
        try {
            ap = new AdvancedPlayer(is);//将这个文件流放在播放器里
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	int i=50;
    	while(i>0){
    		 new MP3Player("F:\\voice.mp3", true).play();
    		 --i;
    		 //System.out.print(i);
    	}
       
    }

    public void play() {
    	  
            try {
            	
                ap.play();//播放
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
       
    }
}
