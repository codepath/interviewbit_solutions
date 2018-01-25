// Capture regions on board.
//https://www.interviewbit.com/problems/capture-regions-on-board/
public class Solution {
	public void solve(ArrayList<ArrayList<Character>> a) {

	    if (a == null || a.size() == 0) {
	        return;
	    }

	    int M = a.size();
	    int N = a.get(0).size();

	    for (int j = 0; j < N; j++) {
	        if (a.get(0).get(j) == 'O') {
	            bfs(a, 0, j);
	        }
	    }

	    for (int i = 0; i < M; i++) {
	        if (a.get(i).get(N-1) == 'O') {
	            bfs(a, i, N-1);
	        }
	    }

	    for (int j = 0; j < N; j++) {
	        if (a.get(M-1).get(j) == 'O') {
	            bfs(a, M-1, j);
	        }
	    }

	    for (int i = 0; i < M; i++) {
	        if (a.get(i).get(0) == 'O') {
	            bfs(a, i, 0);
	        }
	    }

	    for (int i = 0; i < M; i++) {
	        for (int j = 0; j < N; j++) {
	            if (a.get(i).get(j) == 'O') {
	                a.get(i).set(j, 'X');
	            } else if (a.get(i).get(j) == '#') {
	                a.get(i).set(j, 'O');
	            }
	        }
	    }
	}

	private void bfs(ArrayList<ArrayList<Character>> a, int row, int col) {
	    int M = a.size();
	    int N = a.get(0).size();

	    int ind = row*N + col;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(ind);
	    a.get(row).set(col, '#');

	    while (!queue.isEmpty()) {
	        ind = queue.remove();
	        int r = ind / N;
	        int c = ind % N;

	        if (r > 0 && a.get(r-1).get(c) == 'O') {
	            a.get(r-1).set(c, '#');
	            queue.add((r-1)*N + c);
	        }

	        if (c < N-1 && a.get(r).get(c+1) == 'O') {
	            a.get(r).set(c+1, '#');
	            queue.add(r*N + (c+1));
	        }

	        if (r < M-1 && a.get(r+1).get(c) == 'O') {
	            a.get(r+1).set(c, '#');
	            queue.add((r+1)*N + c);
	        }

	        if (c > 0 && a.get(r).get(c-1) == 'O') {
	            a.get(r).set(c-1, '#');
	            queue.add(r*N + (c-1));
	        }
	    }
	}
}
