package homework_1.participants;

public class Cat implements Participants {
    private String name;
    private int max_distance;
    private int max_height_jump;

    public Cat(String name, int max_distance, int max_height_jump) {
        this.name = name;
        this.max_distance = max_distance;
        this.max_height_jump = max_height_jump;
    }

    @Override
    public int jump() {
        System.out.println(name + " прыгает");
        return max_height_jump;
    }

    @Override
    public int run() {
        System.out.println(name + " бежит");
        return max_distance;
    }

}
