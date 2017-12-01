package NonogramSolver;

import java.io.BufferedReader;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import java.util.*;
import static java.util.stream.Collectors.toList;

/**
 * Main class. Reads data from an input file and obtains the solution
 * 
 * @author Mario Cervera
 * 
 */
public class Nonogram {
	
	/**-------------------------------------------------------------------------
	* Returns an array that contains the data read from the input file
	* @param in
	* @return
	* @throws Exception 
	*/
	private static List<List<Datum>> createInputData(BufferedReader in) throws Exception {
		
		List<List<Datum>> result = new ArrayList<List<Datum>>();
		
		String str = "";
		
		while((str = in.readLine()) != null) {
			
			if(str.length() > 0 && str.charAt(0) == '#') {
				continue; // The '#' symbol separates rows and columns in the input file
			}
			
			List<Datum> data = new ArrayList<Datum>();
			
			StringTokenizer st = new StringTokenizer(str);
            
			while(st.hasMoreTokens()) {
            	
				int datum = Integer.parseInt(st.nextToken());
            	
				if(datum < 0) {
					Exception e = new Exception("Incorrect input file format: all numbers must be greater or equal to 0.");
            		throw e;
				}

        		data.add(new Datum(datum, false));	
            }

            result.add(data);
		}

		if(result.size() % 2 != 0) {
			
			Exception e = new Exception("Incorrect input file format: only square matrices (N x N) are supported.");
    		throw e;
		}
		
		return result;
	}
	
	/**--------------------------------------------------------------------
     * Method to solve Nonogram puzzles for the GUI.
     * 
     */
    static String solvePuzzleUI(BufferedReader in, int method)throws Exception{
        String output = "";
        switch (method) {
                case 0:
                    //Resolve Nonogram
                    output = resolveNonogramUI(in);
                    break;
                case 1:
                    String r = "",
                     c = "",
                     t = "";
                    boolean thershold = false;
                    String[] arr;
                    while ((t = in.readLine()) != null) {
                        if (t.equals("#")) {
                            thershold = true;
                            continue;
                        }
                        arr = t.split(" ");
                        for (int i = 0; i < arr.length; i++) {
                            if ((!thershold)) {
                                r += (char) (Integer.parseInt(arr[i]) + 64);

                            } else {
                                c += (char) (Integer.parseInt(arr[i]) + 64);
                            }

                        }
                        if ((!thershold)) {
                            r += " ";
                        } else {
                            c += " ";
                        }

                    }
                    String[] x = {r, c};
                    output = newPuzzleUI(x);
                    break;
            }
        return output;
    }
	
	/**-------------------------------------------------------------------------
	* Method used to solve the puzzle using backtracking for the GUI.
	* @param in
    	* @throws Exception 
	*/
	static String resolveNonogramUI(BufferedReader in) throws Exception {

        List<List<Datum>> data = new ArrayList<List<Datum>>();
        List<List<Integer>> solution = new ArrayList<List<Integer>>();

        data = createInputData(in);

        //Number of rows (the grid is N x N)
        int N = data.size() / 2;

        //First, apply direct rules to solve the Nonogram as much as possible without resorting to backtracking
        DFS.initialState = DirectRules.applyRules(data);

        //After the direct rules, apply the backtracking algorithm
        State s = new State();
        s.initialize(N);
        s.setData(data);
        solution = DFS.dfs(s, 0, N);
        String output = "";

        //Print result
        if (solution == null) {
            output = "\nA solution could not be found.";
        } else {
            for (List<Integer> integers : solution) {
                for (Integer i : integers) {
                    if (i == 1) {
                        output += "X ";
                    } else {
                        output +="~ ";
                    }

                }
                output += "\n";
            }
        }
        return output;
    }
	
	/**-------------------------------------------------------------------------
	* Method used to solve the puzzle using AC-3 for the GUI.
      	* @param data 
      	*/
    	static String newPuzzleUI(String[] data) {
        String[] rowData = data[0].split("\\s");
        String[] colData = data[1].split("\\s");
        String output = "";

        List<List<BitSet>> cols, rows;
        rows = getCandidates(rowData, colData.length);
        cols = getCandidates(colData, rowData.length);

        int numChanged;
        do {
            numChanged = reduceMutual(cols, rows);
            if (numChanged == -1) {
                output = "\nA solution could not be found.";
            }
        } while (numChanged > 0);

        for (List<BitSet> row : rows) {
            for (int i = 0; i < cols.size(); i++) {
               output += row.get(0).get(i) ? "X " : "~ ";
            }
            output += "\n";
        }
        output += "\n";
        return output;
    }

	/**--------------------------------------------------------------------
     * collect all possible solutions for the given clues
     * @param data
     * @param len
     * @return 
     */
    static List<List<BitSet>> getCandidates(String[] data, int len) {
        List<List<BitSet>> result = new ArrayList<>();

        for (String s : data) {
            List<BitSet> lst = new LinkedList<>();

            int sumChars = s.chars().map(c -> c - 'A' + 1).sum();
            List<String> prep = stream(s.split(""))
                    .map(x -> repeat(x.charAt(0) - 'A' + 1, "1")).collect(toList());

            for (String r : genSequence(prep, len - sumChars + 1)) {
                char[] bits = r.substring(1).toCharArray();
                BitSet bitset = new BitSet(bits.length);
                for (int i = 0; i < bits.length; i++) {
                    bitset.set(i, bits[i] == '1');
                }
                lst.add(bitset);
            }
            result.add(lst);
        }
        return result;
    }

    /**--------------------------------------------------------------------
     * permutation generator, translated from Python via D
     * @param ones
     * @param numZeros
     * @return 
     */
    static List<String> genSequence(List<String> ones, int numZeros) {
        if (ones.isEmpty()) {
            return asList(repeat(numZeros, "0"));
        }

        List<String> result = new ArrayList<>();
        for (int x = 1; x < numZeros - ones.size() + 2; x++) {
            List<String> skipOne = ones.stream().skip(1).collect(toList());
            for (String tail : genSequence(skipOne, numZeros - x)) {
                result.add(repeat(x, "0") + ones.get(0) + tail);
            }
        }
        return result;
    }
	//--------------------------------------------------------------------

    static String repeat(int n, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

     //--------------------------------------------------------------------
    /* If all the candidates for a row have a value in common for a certain cell,
    then it's the only possible outcome, and all the candidates from the
    corresponding column need to have that value for that cell too. The ones
    that don't, are removed. The same for all columns. It goes back and forth,
    until no more candidates can be removed or a list is empty (failure). */
    static int reduceMutual(List<List<BitSet>> cols, List<List<BitSet>> rows) {
        int countRemoved1 = reduce(cols, rows);
        if (countRemoved1 == -1) {
            return -1;
        }

        int countRemoved2 = reduce(rows, cols);
        if (countRemoved2 == -1) {
            return -1;
        }

        return countRemoved1 + countRemoved2;
    }

     //--------------------------------------------------------------------
    static int reduce(List<List<BitSet>> a, List<List<BitSet>> b) {
        int countRemoved = 0;

        for (int i = 0; i < a.size(); i++) {

            BitSet commonOn = new BitSet();
            commonOn.set(0, b.size());
            BitSet commonOff = new BitSet();

            // determine which values all candidates of ai have in common
            for (BitSet candidate : a.get(i)) {
                commonOn.and(candidate);
                commonOff.or(candidate);
            }

            // remove from bj all candidates that don't share the forced values
            for (int j = 0; j < b.size(); j++) {
                final int fi = i, fj = j;

                if (b.get(j).removeIf(cnd -> (commonOn.get(fj) && !cnd.get(fi))
                        || (!commonOff.get(fj) && cnd.get(fi)))) {
                    countRemoved++;
                }

                if (b.get(j).isEmpty()) {
                    return -1;
                }
            }
        }
        return countRemoved;
    }

}
