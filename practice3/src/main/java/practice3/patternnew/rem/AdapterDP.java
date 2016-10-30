package practice3.patternnew.rem;

interface Player {
    void play(String fileName);
}

interface MediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

class VlcPlayer implements MediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("play on vlc: fileName = " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //stub
    }
}

class Mp4Player implements MediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //stub
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play on mp4: fileName = " + fileName);
    }
}

class MediaAdapter implements Player {
    @Override
    public void play(String fileName) {
        if (fileName.toLowerCase().endsWith(".vlc")) {
            new VlcPlayer().playVlc(fileName);
        } else if (fileName.toLowerCase().endsWith(".mp4")) {
            new Mp4Player().playMp4(fileName);
        } else {
            System.out.println("play fileName: " + fileName);
        }

    }
}

public class AdapterDP {
    public static void main(String[] args) {
        System.out.println("Adapter DP");
        Player player = new MediaAdapter();
        player.play("okey.mp4");
        player.play("okey.mp3");
        player.play("okey.vlc");
    }
}
