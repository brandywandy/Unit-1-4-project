import java.util.HashMap;
import java.util.Scanner;

public class algLogic {
    private String wantedAlg = "";
    private HashMap<String, String> PllAlgs;

    public algLogic(HashMap<String, String> customAlgs) {
        this.PllAlgs = customAlgs;
    }

    public algLogic() {
        initializeAlgs();
    }
  
    public HashMap<String, String> getPllAlgs() {
        return PllAlgs;
    }

    public String getWantedAlg() {
        return wantedAlg;
    }
  
    public void initializeAlgs() {
        PllAlgs = new HashMap<>();
        PllAlgs.put("Ub", " R2 U (R U R' U') R' U' (R' U R') " );
        PllAlgs.put("Ua", "(R U' R U) R U (R U' R' U') R2");
        PllAlgs.put("Z", "(M2' U M2' U) (M' U2) (M2' U2 M') [U2]");
        PllAlgs.put("H", "(M2' U M2') U2 (M2' U M2') ");
        PllAlgs.put("Aa", " x (R' U R') D2 (R U' R') D2 R2 x' " );
        PllAlgs.put("Ab", "x R2' D2 (R U R') D2 (R U' R) x' " );
        PllAlgs.put("E", " x' (R U' R' D) (R U R' D') (R U R' D) (R U' R' D') x " );
        PllAlgs.put("Ra", " (R U' R' U') (R U R D) (R' U' R D') (R' U2 R') [U'] " );
        PllAlgs.put("Rb", " (R' U2 R U2') R' F (R U R' U') R' F' R2 [U'] " );
        PllAlgs.put("Ja", " (R' U L' U2) (R U' R' U2 R) L [U'] " );
        PllAlgs.put("Jb", "(R U R' F') (R U R' U') R' F R2 U' R' [U']" );
        PllAlgs.put("T", " (R U R' U') (R' F R2 U') R' U' (R U R' F') " );
        PllAlgs.put("F", " (R' U' F')(R U R' U')(R' F R2 U')(R' U' R U)(R' U R) " );
        PllAlgs.put("V", " (R' U R' U') y (R' F' R2 U') (R' U R' F) R F " );
        PllAlgs.put("Y", " F (R U' R' U') (R U R' F') (R U R' U') (R' F R F')  " );
        PllAlgs.put("Na", " (RUR'U)(RUR'F')(RUR'U')(R'FR2U') R' U2 (RU'R') " );
        PllAlgs.put("Nb", " (R' U R U') (R' F' U' F) (R U R' F) R' F' (R U' R) " );
        PllAlgs.put("Ga", " R2 U (R' U R' U') (R U' R2) D U' (R' U R D') [U] " );
        PllAlgs.put("Gc", " R2 U' (R U' R U) (R' U R2 D') (U R U' R') D [U'] " );
        PllAlgs.put("Gb", " (F' U' F) (R2 u R' U) (R U' R u') R2' " );
        PllAlgs.put("Gd", " D' (R U R' U') D (R2 U' R U') (R' U R' U) R2 [U] " );
    }
      
    public void displayPllAlg() {
      System.out.println("The algorithm for Pll case " + wantedAlg + " is " + PllAlgs.get(wantedAlg));
    }

  public String promptUserAlg(String caseType) {
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter the Pll case algorithm you want from " + caseType + ":`");
      wantedAlg = myObj.nextLine();
      wantedAlg = wantedAlg.substring(0, 1).toUpperCase() + wantedAlg.substring(1);

      // Check for cases and print messages if conditions are not met
      if ("Edges Only".equalsIgnoreCase(caseType) && !("ub".equalsIgnoreCase(wantedAlg) || "ua".equalsIgnoreCase(wantedAlg) || "z".equalsIgnoreCase(wantedAlg) || "h".equalsIgnoreCase(wantedAlg))) {
          System.out.println("That is the wrong case for Permutations of Edges Only!");
          return null;
      }

      if ("Corners Only".equalsIgnoreCase(caseType) && !("aa".equalsIgnoreCase(wantedAlg) || "ab".equalsIgnoreCase(wantedAlg) || "e".equalsIgnoreCase(wantedAlg))) {
          System.out.println("That is the wrong case for Permutations of Corners Only!");
          return null;
      }

      if ("Double cycles".equalsIgnoreCase(caseType) && !("ga".equalsIgnoreCase(wantedAlg) || "gb".equalsIgnoreCase(wantedAlg) || "gc".equalsIgnoreCase(wantedAlg) || "gd".equalsIgnoreCase(wantedAlg))) {
          System.out.println("That is the wrong case for Double cycles!");
          return null;
      }

      if ("Adjacent Corners".equalsIgnoreCase(caseType) && !("ra".equalsIgnoreCase(wantedAlg) || "rb".equalsIgnoreCase(wantedAlg))) {
          System.out.println("That is the wrong case for Swap One Set of Adjacent Corners!");
          return null;
      }

      if ("Diagonal Corners".equalsIgnoreCase(caseType) && !("v".equalsIgnoreCase(wantedAlg) || "y".equalsIgnoreCase(wantedAlg))) {
          System.out.println("That is the wrong case for Swap One Set of Diagonal Corners!");
          return null;
      }

      return wantedAlg;
  }


  public void introductions(){
    Scanner myObj = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = myObj.nextLine();
    System.out.println();
    System.out.println("Hello " + name + "! Welcome to the Pll Algorithm Solver!");
  }
  public int calculateMoveCount(String algorithm) {
      // Initialize moveCount to 0
      int moveCount = 0;

      // Iterate through each character in the algorithm
      int index = 0;
      while (index < algorithm.length()) {
          // Check if the current character is a space
          if (algorithm.charAt(index) == ' ') {
              // Increment moveCount for each space
              moveCount++;
          }
          // Move to the next character
          index++;
      }

      return moveCount;
  }
  public double calculateTimeToBeat(int moveCount, double averageTimePerMove) {
      // Carry moveCount to the exponent of two and then multiply it by the average time per move
      double timeToBeat = Math.pow(moveCount, 2) * averageTimePerMove;
    timeToBeat = Math.round(timeToBeat * 100.0) / 100.0;
      return timeToBeat;
  }


}
