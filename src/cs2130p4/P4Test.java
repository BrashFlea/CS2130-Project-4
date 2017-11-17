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
         
         System.out.println("Part D:");
         System.out.println("W = (D OR E)^T AND (D^T OR E^T)");
         BMat DE = BMD.join(BME); // D OR E
         BMat DET = DE.transpose(); // (D OR E)^T
         BMat DT = BMD.transpose(); // D^T
         BMat ET = BME.transpose(); // E^T
         BMat DTET = DT.join(ET); // D^T OR E^T
         BMat DEDE = DET.meet(DTET); // (D OR E)^T AND (D^T OR E^T)
         Solution = DEDE;
         Solution.show();
         addLine();
         
         System.out.println("Part E:");
         System.out.println("W = D^1 OR D^2 OR D^3 OR D^4");
         BMat D1 = BMD.power(1);
         BMat D2 = BMD.power(2);
         BMat D3 = BMD.power(3);
         BMat D4 = BMD.power(4);
         BMat D1D2 = D1.join(D2); // D^1 OR D^2
         BMat D3D4 = D3.join(D4); // D^3 OR D^4
         BMat D1D2D3D4 = D1D2.join(D3D4); // D^1 OR D^2 OR D^3 OR D^4
         Solution = D1D2D3D4;
         Solution.show();
         addLine();
         
         System.out.println("Part F:");
         System.out.println("X = maximum out-degree of all nodes in D");
         
         int currNode, maxNode = 0;
         for (int i = 0; i < BMD.SIZE; i++) {
             currNode = BMD.outdegree(i);
             if (currNode > maxNode) {
                 maxNode = currNode;
             }
         }
         System.out.println("Maximum out-degree of all nodes in D is: " + maxNode);
         addLine();
         
         System.out.println("Part G:");
         System.out.println("W = symmetric closure of D. Is D symmetric?");
         BMat SD = BMD.sclosure();
         if (BMD.isEqual(SD)) {
             System.out.println("Yes, D is symmetric");
         }
         else {
             System.out.println("No, D is not symmetric");
         }
         addLine();
         
         System.out.println("Part H:");
         System.out.println("W = transitive closure of E. Is E transitive?");
         BMat TD = BMD.tclosure();
         if (BMD.isEqual(TD)) {
             System.out.println("Yes, D is transitive");
         }
         else {
             System.out.println("No, D is not transitive");
         }
         addLine();

                  
         

         
	     
	}
	
    public static void addLine() {
        System.out.println("----------------");
    }

}
