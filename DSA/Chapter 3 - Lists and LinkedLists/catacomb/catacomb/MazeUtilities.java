//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package catacomb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import catacomb.MazeCell;

public class MazeUtilities {
    private static final int HASH_SEED = 5381;
    private static final int HASH_MULTIPLIER = 33;
    private static final int HASH_MASK = Integer.MAX_VALUE;
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 4;
    private static final int TWISTY_MAZE_SIZE = 12;

    public static boolean isPathToFreedom(MazeCell start, String moves) {
        MazeCell curr = start;
        Set<String> items = new HashSet();
        if (!start.whatsHere.equals("")) {
            items.add(start.whatsHere);
        }

        for(char ch : moves.toCharArray()) {
            if (ch == 'N') {
                curr = curr.north;
            } else if (ch == 'S') {
                curr = curr.south;
            } else if (ch == 'E') {
                curr = curr.east;
            } else {
                if (ch != 'W') {
                    return false;
                }

                curr = curr.west;
            }

            if (curr == null) {
                return false;
            }

            if (!curr.whatsHere.equals("")) {
                items.add(curr.whatsHere);
            }
        }

        return items.size() == 3;
    }

    private static int hashCode(int value) {
        return value & Integer.MAX_VALUE;
    }

    private static int hashCode(String str) {
        int hash = 5381;

        for(char ch : str.toCharArray()) {
            hash = 33 * hash + ch;
        }

        return hashCode(hash);
    }

    private static int hashCode(String str, int... values) {
        int result = hashCode(str);

        for(int value : values) {
            result = result * 33 + value;
        }

        return hashCode(result);
    }

    public static MazeCell mazeFor(String name) {
        Random generator = new Random((long)hashCode(name, 4, 4));
        MazeCell[][] maze = makeMaze(4, 4, generator);
        List<MazeCell> linearMaze = new ArrayList();

        for(int row = 0; row < maze.length; ++row) {
            for(int col = 0; col < maze[0].length; ++col) {
                linearMaze.add(maze[row][col]);
            }
        }

        int[][] distances = allPairsShortestPaths(linearMaze);
        int[] locations = remoteLocationsIn(distances);
        ((MazeCell)linearMaze.get(locations[1])).whatsHere = "Spellbook";
        ((MazeCell)linearMaze.get(locations[2])).whatsHere = "Potion";
        ((MazeCell)linearMaze.get(locations[3])).whatsHere = "Wand";
        return (MazeCell)linearMaze.get(locations[0]);
    }

    public static MazeCell twistyMazeFor(String name) {
        Random generator = new Random((long)hashCode(name, 12));
        List<MazeCell> maze = makeTwistyMaze(12, generator);
        int[][] distances = allPairsShortestPaths(maze);
        int[] locations = remoteLocationsIn(distances);
        ((MazeCell)maze.get(locations[1])).whatsHere = "Spellbook";
        ((MazeCell)maze.get(locations[2])).whatsHere = "Potion";
        ((MazeCell)maze.get(locations[3])).whatsHere = "Wand";
        return (MazeCell)maze.get(locations[0]);
    }

    private static boolean areAdjacent(MazeCell first, MazeCell second) {
        return first.east == second || first.west == second || first.north == second || first.south == second;
    }

    private static int[][] allPairsShortestPaths(List<MazeCell> maze) {
        int[][] result = new int[maze.size()][maze.size()];

        for(int i = 0; i < result.length; ++i) {
            for(int j = 0; j < result[i].length; ++j) {
                result[i][j] = maze.size() + 1;
            }
        }

        for(int i = 0; i < maze.size(); ++i) {
            result[i][i] = 0;
        }

        for(int i = 0; i < maze.size(); ++i) {
            for(int j = 0; j < maze.size(); ++j) {
                if (areAdjacent((MazeCell)maze.get(i), (MazeCell)maze.get(j))) {
                    result[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < maze.size(); ++i) {
            int[][] next = new int[maze.size()][maze.size()];

            for(int j = 0; j < maze.size(); ++j) {
                for(int k = 0; k < maze.size(); ++k) {
                    next[j][k] = Math.min(result[j][k], result[j][i] + result[i][k]);
                }
            }

            result = next;
        }

        return result;
    }

    private static List<Integer> scoreOf(int[] nodes, int[][] distances) {
        List<Integer> result = new ArrayList();

        for(int i = 0; i < nodes.length; ++i) {
            for(int j = i + 1; j < nodes.length; ++j) {
                result.add(distances[nodes[i]][nodes[j]]);
            }
        }

        Collections.sort(result);
        return result;
    }

    private static boolean lexicographicallyFollows(List<Integer> lhs, List<Integer> rhs) {
        for(int i = 0; i < lhs.size(); ++i) {
            if (lhs.get(i) != rhs.get(i)) {
                return (Integer)lhs.get(i) > (Integer)rhs.get(i);
            }
        }

        return false;
    }

    private static int[] remoteLocationsIn(int[][] distances) {
        int[] result = new int[]{0, 1, 2, 3};

        for(int i = 0; i < distances.length; ++i) {
            for(int j = i + 1; j < distances.length; ++j) {
                for(int k = j + 1; k < distances.length; ++k) {
                    for(int l = k + 1; l < distances.length; ++l) {
                        int[] curr = new int[]{i, j, k, l};
                        if (lexicographicallyFollows(scoreOf(curr, distances), scoreOf(result, distances))) {
                            result = curr;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static void clearGraph(List<MazeCell> nodes) {
        for(MazeCell node : nodes) {
            node.whatsHere = "";
            node.north = node.south = node.east = node.west = null;
        }

    }

    private static Port randomFreePortOf(MazeCell cell, Random generator) {
        List<Port> ports = new ArrayList();
        if (cell.east == null) {
            ports.add(MazeUtilities.Port.EAST);
        }

        if (cell.west == null) {
            ports.add(MazeUtilities.Port.WEST);
        }

        if (cell.north == null) {
            ports.add(MazeUtilities.Port.NORTH);
        }

        if (cell.south == null) {
            ports.add(MazeUtilities.Port.SOUTH);
        }

        if (ports.isEmpty()) {
            return null;
        } else {
            int port = generator.nextInt(ports.size());
            return (Port)ports.get(port);
        }
    }

    private static void link(MazeCell from, MazeCell to, Port link) {
        switch (link) {
            case EAST -> from.east = to;
            case WEST -> from.west = to;
            case NORTH -> from.north = to;
            case SOUTH -> from.south = to;
            default -> throw new RuntimeException("Unknown port.");
        }

    }

    private static boolean erdosRenyiLink(List<MazeCell> nodes, Random generator) {
        double threshold = Math.log((double)nodes.size()) / (double)nodes.size();

        for(int i = 0; i < nodes.size(); ++i) {
            for(int j = i + 1; j < nodes.size(); ++j) {
                if (generator.nextDouble() <= threshold) {
                    Port iLink = randomFreePortOf((MazeCell)nodes.get(i), generator);
                    Port jLink = randomFreePortOf((MazeCell)nodes.get(j), generator);
                    if (iLink == null || jLink == null) {
                        return false;
                    }

                    link((MazeCell)nodes.get(i), (MazeCell)nodes.get(j), iLink);
                    link((MazeCell)nodes.get(j), (MazeCell)nodes.get(i), jLink);
                }
            }
        }

        return true;
    }

    private static boolean isConnected(List<MazeCell> maze) {
        Set<MazeCell> visited = new HashSet();
        Queue<MazeCell> frontier = new LinkedList();
        frontier.add((MazeCell)maze.get(0));

        while(!frontier.isEmpty()) {
            MazeCell curr = (MazeCell)frontier.remove();
            if (!visited.contains(curr)) {
                visited.add(curr);
                if (curr.east != null) {
                    frontier.add(curr.east);
                }

                if (curr.west != null) {
                    frontier.add(curr.west);
                }

                if (curr.north != null) {
                    frontier.add(curr.north);
                }

                if (curr.south != null) {
                    frontier.add(curr.south);
                }
            }
        }

        return visited.size() == maze.size();
    }

    private static List<MazeCell> makeTwistyMaze(int numNodes, Random generator) {
        List<MazeCell> result = new ArrayList();

        for(int i = 0; i < numNodes; ++i) {
            result.add(new MazeCell());
        }

        do {
            clearGraph(result);
        } while(!erdosRenyiLink(result, generator) || !isConnected(result));

        return result;
    }

    private static List<EdgeBuilder> allPossibleEdgesFor(MazeCell[][] maze) {
        List<EdgeBuilder> result = new ArrayList();

        for(int row = 0; row < maze.length; ++row) {
            for(int col = 0; col < maze[row].length; ++col) {
                if (row + 1 < maze.length) {
                    result.add(new EdgeBuilder(maze[row][col], maze[row + 1][col], MazeUtilities.Port.SOUTH, MazeUtilities.Port.NORTH));
                }

                if (col + 1 < maze[row].length) {
                    result.add(new EdgeBuilder(maze[row][col], maze[row][col + 1], MazeUtilities.Port.EAST, MazeUtilities.Port.WEST));
                }
            }
        }

        return result;
    }

    private static MazeCell repFor(Map<MazeCell, MazeCell> reps, MazeCell cell) {
        while(reps.get(cell) != cell) {
            cell = (MazeCell)reps.get(cell);
        }

        return cell;
    }

    private static void shuffleEdges(List<EdgeBuilder> edges, Random generator) {
        for(int i = 0; i < edges.size(); ++i) {
            int j = generator.nextInt(edges.size() - i) + i;
            EdgeBuilder temp = (EdgeBuilder)edges.get(i);
            edges.set(i, (EdgeBuilder)edges.get(j));
            edges.set(j, temp);
        }

    }

    private static MazeCell[][] makeMaze(int numRows, int numCols, Random generator) {
        MazeCell[][] maze = new MazeCell[numRows][numCols];

        for(int row = 0; row < numRows; ++row) {
            for(int col = 0; col < numCols; ++col) {
                maze[row][col] = new MazeCell();
            }
        }

        List<EdgeBuilder> edges = allPossibleEdgesFor(maze);
        shuffleEdges(edges, generator);
        Map<MazeCell, MazeCell> representatives = new HashMap();

        for(int row = 0; row < numRows; ++row) {
            for(int col = 0; col < numCols; ++col) {
                MazeCell elem = maze[row][col];
                representatives.put(elem, elem);
            }
        }

        int edgesLeft = numRows * numCols - 1;

        for(int i = 0; edgesLeft > 0 && i < edges.size(); ++i) {
            EdgeBuilder edge = (EdgeBuilder)edges.get(i);
            MazeCell rep1 = repFor(representatives, edge.from);
            MazeCell rep2 = repFor(representatives, edge.to);
            if (rep1 != rep2) {
                representatives.put(rep1, rep2);
                link(edge.from, edge.to, edge.fromPort);
                link(edge.to, edge.from, edge.toPort);
                --edgesLeft;
            }
        }

        if (edgesLeft != 0) {
            throw new RuntimeException("Edges remain?");
        } else {
            return maze;
        }
    }

    private MazeUtilities() {
    }

    private static enum Port {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        private Port() {
        }
    }

    private static final class EdgeBuilder {
        MazeCell from;
        MazeCell to;
        Port fromPort;
        Port toPort;

        public EdgeBuilder(MazeCell from, MazeCell to, Port fromPort, Port toPort) {
            this.from = from;
            this.to = to;
            this.fromPort = fromPort;
            this.toPort = toPort;
        }
    }
}

