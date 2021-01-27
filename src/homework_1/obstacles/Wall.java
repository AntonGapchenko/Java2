package homework_1.obstacles;


import homework_1.participants.Participants;

public class Wall implements Obstacles {

    private int wall_height;

    public Wall(int wall_height) {
        this.wall_height = wall_height;
    }

    @Override
    public boolean passObstacleBy(Participants participants) {
        if (participants.jump()>=wall_height){
            System.out.println("Участник преодолел стену");
            return true;
        }
        else {
            System.out.println("Участник не преодолел стену");
            return false;
        }

    }
}
