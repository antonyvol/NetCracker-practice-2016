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


    public static class GroundVisorException extends RuntimeException {
        GroundVisorException() {
            super();
        }
        GroundVisorException(String message) {
            super(message);
        }
    }

    public static class GroundCell {
        private CellState state;
        private int x;
        private int y;

        public CellState getState() {
            return state;
        }

        public void setState(CellState state) {
            this.state = state;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        GroundCell(int x, int y) {
            this.x = x;
            this.y = y;
            state = CellState.FREE;
        }
    }

    public static class Ground {
        private GroundCell[][] landscape;
        private int length;
        private int width;

        public CellState getCellState(int x, int y) {
            return landscape[x][y].getState();
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        Ground(int length, int width) {
            this.length = length;
            this.width = width;
            landscape = new GroundCell[length][width];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    landscape[i][j] = new GroundCell(i, j);
                }
            }
        }
    }

    public static class GroundVisor {
        private Ground ground;

        public boolean hasObstacles(int x, int y) {
            if (x > ground.getLength() || y > ground.getWidth()) {
                throw new GroundVisorException("Index out of range!");
            }
            if (x < 0 || y < 0) {
                throw new GroundVisorException("Index out of range!");
            }
            return ground.getCellState(x, y) == CellState.OCCUPIED;
        }

        GroundVisor() { ground = new Ground(1, 1); }
        GroundVisor(Ground ground) { this.ground = ground; }
    }

    public static class Rover implements Movable, Turnable {
        private Direction direction;
        private int x;
        private int y;

        @Override
        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void turnTo(Direction direction) {
            this.direction = direction;
        }

        Rover() {
            x = 0;
            y = 0;
            direction = Direction.NORTH;
        }
        Rover(int x, int y) {
            this.x = x;
            this.y = y;
            direction = Direction.NORTH;
        }
        Rover(Direction direction) {
            this.x = 0;
            this.y = 0;
            this.direction = direction;
        }
        Rover(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Rover rover = new Rover();
        GroundVisor visor = new GroundVisor(new Ground(50, 50));

        if (!visor.hasObstacles(14, 6)) {
            rover.move(14, 6);
            rover.turnTo(Direction.EAST);
        }
    }
}
