package homework_1.obstacles;


import homework_1.participants.Participants;

public class Track implements Obstacles {
    private int track_distance;

    public Track(int track_distance) {
        this.track_distance = track_distance;
    }

    @Override
    public boolean passObstacleBy(Participants participants) {
        if (participants.run() >= track_distance) {
            System.out.println("Участник преодолел дорожку");
            return true;
        } else {
            System.out.println("Участник не преодолел дорожку");
            return false;
        }

    }
}
