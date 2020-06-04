package recursion;

public class MazeDemo {
    public static int[][] createMap(int x, int y) {
        int[][] maze = new int[y + 2][x + 2];
        for (int i = 0; i < x + 2; i++) {
            maze[0][i] = 1;
            maze[y + 1][i] = 1;
        }
        for (int i = 0; i < y + 2; i++) {
            maze[i][0] = 1;
            maze[i][x + 1] = 1;
        }

        return maze;
    }

    public static String arrayToString(int[][] array) {
        int x = array[0].length;
        int y = array.length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        return null;
    }

    public static boolean findWay(int[][] map, int x, int y, int endX, int endY) {

        if (map[endY][endX] == 2) {
            arrayToString(map);
            return true;
        }else {
            if(map[y][x]==0){
                map[y][x]=2;
                if (findWay(map,x,y-1,endX,endY)) {
                    return true;
                }else if(findWay(map,x+1,y,endX,endY)){
                    return true;
                }else if(findWay(map,x,y+1,endX,endY)){
                    return true;
                }else if(findWay(map,x-1,y,endX,endY)) {
                    return true;
                }else {
//                    3 means dead road
                    map[y][x]=3;
                    return false;
                }
            }else {
                return false;
            }

        }

//      return true;
    }

    public static void main(String[] args) {
        int[][] map= createMap(5, 7);
        findWay(map,1,1,4,4);
    }
}
