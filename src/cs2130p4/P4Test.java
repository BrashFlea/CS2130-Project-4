// Project #4 test program
package cs2130p4;

public class P4Test {

	public static void main(String[] args) {
	    // Boolean matrix definitions

	    int A[][] = new int[][]
	                {{1, 1, 0, 0, 1},
	                 {1, 0, 1, 0, 0},
	                 {0, 0, 0, 0, 0},
	                 {1, 0, 0, 0, 0},
	                 {0, 0, 1, 0, 1}};

	    int B[][] = new int[][]
	                {{0, 1, 0, 0, 1},
	                 {0, 1, 1, 0, 0},
	                 {1, 0, 1, 0, 0},
	                 {1, 0, 0, 0, 0},
	                 {0, 1, 0, 0, 1}};

	    int C[][] = new int[][]
	                {{0, 1, 0, 0, 0},
	                 {0, 0, 1, 0, 0},
	                 {0, 0, 0, 1, 0},
	                 {1, 0, 0, 0, 1},
	                 {0, 1, 0, 0, 0}};

	    int D[][] = new int[][]
	                {{1, 1, 0, 0, 0, 0},
	                 {1, 1, 1, 0, 0, 0},
	                 {0, 1, 1, 1, 0, 0},
	                 {0, 0, 1, 1, 0, 0},
	                 {0, 0, 0, 0, 0, 1},
	                 {0, 0, 0, 0, 1, 1}};

	    int E[][] = new int[][]
	                {{0, 1, 1, 0, 0, 1},
	                 {0, 1, 1, 0, 0, 1},
	                 {0, 0, 1, 0, 0, 1},
	                 {0, 0, 0, 0, 1, 1},
	                 {0, 0, 0, 1, 1, 1},
	                 {0, 0, 0, 0, 0, 0}};

	    int F[][] = new int[][]
	    {{0, 0, 0, 0, 1, 0, 1, 0, 0},
	     {1, 0, 0, 1, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 1, 0, 0, 0, 0, 1, 1},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 1, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0}};

	    int G[][] = new int[][]
	    {{0, 0, 0, 1, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {1, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 1, 0, 0, 1, 0, 0, 0},
	     {0, 1, 0, 0, 0, 0, 1, 0, 1},
	     {0, 0, 0, 0, 0, 0, 0, 1, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0},
	     {0, 0, 0, 0, 0, 0, 0, 0, 0}};

	     BMat BMA = new BMat(A);
	     BMat BMB = new BMat(B);
	     BMat BMC = new BMat(C);
	     BMat BMD = new BMat(D);
	     BMat BME = new BMat(E);
	     BMat BMF = new BMat(F);
	     BMat BMG = new BMat(G);
	     
	     System.out.println("Part A:");
	     System.out.println("W = (C' AND (A OR B)) AND B'");
	     BMat BMBC = BMB.complement();
	     BMat BMCC = BMC.complement();
	     BMat BMAB = BMA.join(BMB); // A OR B
	     BMat CCAB = BMCC.meet(BMAB); // C' AND (A OR B)
	     BMat CCBB = CCAB.meet(BMBC); // (C' AND (A OR B)) AND B'
	     BMat Solution = CCBB;
	     Solution.show();
	     addLine();
	     
         System.out.println("Part B:");
         System.out.println("W = (B^T * B) AND (C OR C^T)");
         BMat BT = BMB.transpose(); // B^T
         BMat CT = BMC.transpose(); // C^T
         BMat BTB = BT.product(BMB); // B^T * B
         BMat CCT = BMC.product(CT); // C OR C^T
         BMat BTBCCT = BTB.meet(CCT); // (B^T * B) AND (C OR C^T)
         Solution = BTBCCT;
         Solution.show();
         addLine();
         
         System.out.println("Part C:");
         System.out.println("W = C^18");
         BMat C18 = BMC.power(18);
         Solution = C18;
         Solution.show();
         addLine();
         
         System.out.println("part c:");
         System.out.println("oC^18");
         BMat partC = BMC;
         for(int i = 1; i < 18; i++) {
             partC = partC.product(BMC);
         }
         partC.show();

         
	     

	}
	
    public static void addLine() {
        System.out.println("----------------");
    }

}
