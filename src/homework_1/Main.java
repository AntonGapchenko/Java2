package homework_1;


import homework_1.obstacles.Obstacles;
import homework_1.obstacles.Track;
import homework_1.obstacles.Wall;
import homework_1.participants.Cat;
import homework_1.participants.Man;
import homework_1.participants.Participants;
import homework_1.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Participants[] participants = {
                new Man("Иван", 800, 3),
                new Cat("Барсик", 1000, 4),
                new Robot("t-1000", 7000, 10)};
        Obstacles[] obstacles = {
                new Track(700),
                new Wall(3),
                new Track(1000),
                new Wall(5),
                new Track(4000),
                new Wall(5),};

        for (int i = 0; i < participants.length; i++) {
            boolean result = true;
            for (int j = 0; j < obstacles.length; j++) {
                result = obstacles[j].passObstacleBy(participants[i]);
                if (!result) {
                    System.out.println("Участник не прошел все полосу препятствий!");
                    break;
                }

            }

            if (result) {
                System.out.println("Участник прошел все полосу препятствий!");
            }


        }

    }
}
