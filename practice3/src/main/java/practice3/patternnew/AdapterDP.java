package practice3.patternnew;

interface MediaPlayer {
    void play(String mediaType, String fileName);
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp3(String fileName);
}

class VlcMediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("vlc f:" + fileName);
    }

    @Override
    public void playMp3(String fileName) {
        //stab
    }
}

class Mp3MediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //stab
    }

    @Override
    public void playMp3(String fileName) {
        System.out.println("mp3 f:" + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String mediaType) {
        if ("vlc".equalsIgnoreCase(mediaType)) {
            advancedMediaPlayer = new VlcMediaPlayer();
        } else if ("mp3".equalsIgnoreCase(mediaType)) {
            advancedMediaPlayer = new Mp3MediaPlayer();
        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        if ("vlc".equalsIgnoreCase(mediaType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if ("mp3".equalsIgnoreCase(mediaType)) {
            advancedMediaPlayer.playMp3(fileName);
        }
    }
}

class Play implements MediaPlayer {

    @Override
    public void play(String mediaType, String fileName) {
        if ("mp4".equalsIgnoreCase(mediaType)) {
            System.out.println("mp4 f:" + fileName);
        } else if ("mp3".equalsIgnoreCase(mediaType) || "vlc".equalsIgnoreCase(mediaType)) {
            new MediaAdapter(mediaType).play(mediaType, fileName);

        } else {
            System.out.println("No supported type: " + mediaType + " f:" + fileName);
        }
    }
}

public class AdapterDP {
    public static void main(String[] args) {
        System.out.println("Adapter DP");
        Play play = new Play();
        play.play("mp3", "a.mp3");
        play.play("mp4", "a.mp4");
        play.play("mp5", "a.mp5");
        play.play("vlc", "a.avi");
    }
}
