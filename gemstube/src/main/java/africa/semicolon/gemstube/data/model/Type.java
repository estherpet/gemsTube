package africa.semicolon.gemstube.data.model;

public enum Type {
    VIDEO("video"),
    IMAGE("image");
    private final String value;

    @Override
    public String toString() {
        return value ;
    }
    Type(String value) {
        this.value = value;
    }
}
