public class Main {

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    public interface Movable {
        void move(int x, int y);
    }

    public interface Turnable {
        void turnTo(Direction direction);
    }

    public class Rover implements Movable, Turnable {
        private Direction direction;
        private int x;
        private int y;

        @Override
        public void move(int x, int y) {

        }

        @Override
        public void turnTo(Direction direction) {

        }
    }

    public static void main(String[] args) {

    }
}
