package africa.semicolon.gemstube.exception;

public class GemstubeException extends Throwable{
    public GemstubeException(String message){
        super(message);
    }
    public GemstubeException(Throwable throwable){
        super(throwable);
    }
}
