public class Main {


    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    public enum CellState {
        FREE, OCCUPIED
    }



    public interface Movable {
        void move(int x, int y);
    }

    public interface Turnable {
        void turnTo(Direction direction);
    }



    public class GroundVisorExeption extends RuntimeException {
        GroundVisorExeption() {
            super();
        }
        GroundVisorExeption(String message) {
            super(message);
        }
    }

    public class GroundCell {
        private CellState state;
        private int x;
        private int y;

        GroundCell() {
            state = CellState.FREE;
        }
    }

    public class Ground {
        private GroundCell[][] landscape;
        private int length;
        private int width;

        Ground(int length, int width) {
            this.length = length;
            this.width = width;

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    landscape[i][j] = new GroundCell();
                }
            }
        }
    }

    public class GroundVisor {
        private Ground ground;

        // not done yet
        public boolean hasObstacles(int x, int y) {
            try {
                if (x > ground.length || y > ground.width) {
                    throw new GroundVisorExeption();
                }
            } catch(GroundVisorExeption gve) {
                System.err.println(gve.toString() + ": index out of range.");
            }
            return true;
        }
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
