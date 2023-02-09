package homework5;

import java.util.*;


public class WaveAlgorithm {
    public static void main(String[] args) {
        System.out.println("""
Программа строит кротчайший путь к выходу.
Для прерывания программы введите "exit".
Дана карта:
"""
        );
        int[][] map = getMap();
        pprint(map);
        System.out.println();
        Point startXY = userInput("СТАРТ", map);
        start(map, startXY);
        pprint(map);
        Point finishXY = userInput("ФИНИШ", map);
        finish(map, finishXY);
        pprint(map);
        getWavePropagation(map, startXY);
        pathRestoration(map, startXY, finishXY);
        System.out.println();
        pprint(map);
    }

    static Point userInput(String str, int[][] m) {
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.printf("Введите координаты %s (номер строки и номер столбца)" +
                    " через пробел, например, 0 7: ", str);
            System.out.println();
            String[] input = scan.nextLine().split(" ");
            try {
                if (input[0].equals("exit")) {
                    System.exit(0);
                }
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                Point point = new Point(x, y);
                if (m[point.x][point.y] == 0) {
                    return point;
                } else if (m[point.x][point.y] == -1) {
                    System.out.println("Это стена, выберите другую позицию!");
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.err.println("Неправильный формат ввода координат!");
            }
        }
    }
    static int[][] getMap() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, -1, 0, -1, 0},
                {0, 0, -1, 0, 0, 0, -1, 0},
                {0, 0, -1, 0, 0, 0, -1, 0},
                {0, -1, -1, -1, -1, -1, -1, 0},
                {0, 0, -1, 0, 0, 0, -1, 0},
                {0, 0, -1, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    static void pprint(int[][] m) {
        int rows = m.length;
        int columns = m[0].length;
        System.out.print("   ");
        for (int i = 0; i < columns; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < columns; j++) {
//                System.out.printf("%4d", m[i][j]);
                if (m[i][j]==-1) {
                    System.out.printf("%s", "███");
                } else if (m[i][j] == 1) {
                    System.out.printf("%s", " ☺️ ");
                } else if (m[i][j] == -2) {
                    System.out.printf("%s", " ➜ ");
                } else if (m[i][j] == -3) {
                    System.out.printf("%s", " ✔️ ");
                } else {
                    System.out.printf("%s", "░░░");
                }
            }
            System.out.println();
        }
    }

    static boolean checkBounds(Point any, int[][] m) {
        return (
                0 <= any.x && any.x < m.length &&
                0 <= any.y && any.y < m[0].length &&
                m[any.x][any.y] != -1
        );
    }

    static void start(int[][] map, Point startPoint) {
        map[startPoint.x][startPoint.y] = 1;
    }

    static void finish(int[][] map, Point finishPoint) {
        map[finishPoint.x][finishPoint.y] = -2;
    }

    static class Point {
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }



    static void getWavePropagation(int[][] map, Point start) {
        LinkedList<Point> queuePoints = new LinkedList<>();
        Point current = start;
        int cnt;
        LinkedList<Point> steps;
        queuePoints.add(current);
        while (true) {
            try {
                current = queuePoints.removeFirst();
            } catch (NoSuchElementException e) {
                break;
            }
            steps = getNeighboringPoints(map, current);
            cnt = map[current.x][current.y];
            for (Point step : steps) {
                if (map[step.x][step.y] == 0 || map[step.x][step.y] == -2) {
                    map[step.x][step.y] = cnt + 1;
                    queuePoints.add(step);
                }
            }
        }
    }

    static LinkedList<Point> getNeighboringPoints(int[][] m, Point current) {
        Point up = new Point(current.x - 1, current.y);
        Point left = new Point(current.x, current.y + 1);
        Point down = new Point(current.x + 1, current.y);
        Point right = new Point(current.x, current.y - 1);
        LinkedList<Point> steps = new LinkedList<>();
        for (Point step: Arrays.asList(up, left, down, right)) {
            if (checkBounds(step, m)) {
                steps.add(step);
            }
        }
        return steps;
    }

    static void pathRestoration(int[][] m, Point start, Point finish) {
        LinkedList<Point> pointsOfPath = new LinkedList<>();
        Point current = finish;
        pointsOfPath.add(finish);
        LinkedList<Point> steps;
        do {
            steps = getNeighboringPoints(m, current);
            for (Point step : steps) {
                if (m[step.x][step.y] < m[current.x][current.y]) {
                    pointsOfPath.add(step);
                    current = step;
                    break;
                }
            }
        } while (current.x != start.x || current.y != start.y);
        for (Point point: pointsOfPath) {
            m[point.x][point.y] = -3;
        }
    }
}
