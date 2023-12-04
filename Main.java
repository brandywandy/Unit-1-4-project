import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        algLogic algo = new algLogic();
        algo.initializeAlgs();
        algo.introductions();

        Scanner myObj = new Scanner(System.in);
        System.out.println();
        String question = "Enter which type of case you would like to solve for \n (Options are: Edges Only(Ub \\ Ua \\ Z \\ H), Corners Only(Aa \\ Ab \\ E), Double Cycles(Ga \\ Gb \\ Gc \\ Gd), Adjacent Corners(Ra \\ Rb), and Diagonal Corners(V \\ Y)): ";
        System.out.println(question);
        String caseType = myObj.nextLine();

        String chosenAlgorithm = algo.promptUserAlg(caseType);
        if (chosenAlgorithm != null) {
            algo.displayPllAlg();
            int moveCount = algo.calculateMoveCount(algo.getPllAlgs().get(chosenAlgorithm));
            double averageTimePerMove = 0.01;
            double timeToBeat = algo.calculateTimeToBeat(moveCount, averageTimePerMove);

            System.out.println("Move Count: " + (moveCount - 1));  // Adjusted to subtract 1
            System.out.println("Time to Beat: " + timeToBeat + " seconds");
        }
    }
}
