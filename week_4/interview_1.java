public class TowersOfHanoi {
      
    public static Move[] solve(int n) {
           Move[] moves = new Move[(1 << n) - 1];
           solve(n, moves, 0, 'A', 'B', 'C');
           return moves;
    }
  
    private static void solve(int n, Move[] moves, int resultIndex, char src, char aux, char dest) {
           if (n == 0) return;
         
           solve(n - 1, moves, resultIndex, src, dest, aux);
           // System.out.println("Moving disk "+n+" from "+src+" to "+dest);
           moves[resultIndex++] = getMove(src, dest);
           solve(n - 1, moves, resultIndex, aux, src, dest);
    }

    private static Move getMove(char src, char dest) {
           if (src == 'A' && dest == 'B') return Move.AB;
           if (src == 'A' && dest == 'C') return Move.AC;
           if (src == 'B' && dest == 'A') return Move.BA;
           if (src == 'B' && dest == 'C') return Move.BC;
           if (src == 'C' && dest == 'A') return Move.CA;
           if (src == 'C' && dest == 'B') return Move.CB;
           return Move.unknown;
    }

    public static enum Move {
        AB, AC, BA, BC, CA, CB, unknown;
       
        public String toString() {
             switch (this) {
                case AB: return "AB";
                case AC: return "AC";
                case BA: return "BA";
                case BC: return "BC";
                case CA: return "CA";
                case CB: return "CB";
                case unknown: return "?";
                default: break;
            }
            return "?";
        }
    }
}