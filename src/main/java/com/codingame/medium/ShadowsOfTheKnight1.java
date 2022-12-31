package com.codingame.medium;

public class ShadowsOfTheKnight1 {

    protected int [] nextMove(){
        return new int []{0,0};
    }
    public static void main(String args[]) {
        //   Scanner in = new Scanner(System.in);
        var W = 10; // width of the building.
        var H = 10; // height of the building.
        var N = 6; // maximum number of turns before game over.
        var X0 = 2;
        var Y0 = 5;
        var building = new int [W][H];

        // game loop
        while (true) {

            String bombDir = "U";
                    //in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println(W);
            System.err.println(H);
            System.err.println(N);
            System.err.println(X0);
            System.err.println(Y0);
            System.err.println("message received: " + bombDir);
            if("U".equals(bombDir)){
                Y0+=1;
            }else if("UR".equals(bombDir)){
                X0+=1;
                Y0+=1;

            }else if ("R".equals(bombDir)){
                X0-=1;
            }else if("DR".equals(bombDir)){
                X0+=1;
                Y0-=1;
            }else if ("D".equals(bombDir)){
                Y0-=1;
            }else if ("DL".equals(bombDir)){
                X0-=1;
                Y0-=1;
            } else if ("L".equals(bombDir)){
                X0-=1;
            }else if ("UL".equals(bombDir)){
                X0-=1;
                Y0+=1;
            }

            System.err.println("new position: " + X0 + " " + Y0 );

            // the location of the next window Batman should jump to.
            System.out.println(X0 + " " + Y0);
            //System.out.println("6 8");
        }
    }
}
