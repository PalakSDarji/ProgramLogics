package com.palak;

public class PatternsPrinting {

    /**
     * prints like this.
     * *
     * **
     * ***
     * ****
     * *****
     */
    private void print(){
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    /**
     *      *
     *     * *
     *    * * *
     *   * * * *
     *  * * * * *
     *
     *  for more understanding, here I have replaced space " " with "0" from the first loop.
     *  and "* " with "*1" from second loop.
     *
     * 00000*1
     * 0000*1*1
     * 000*1*1*1
     * 00*1*1*1*1
     * 0*1*1*1*1*1
     *
     */
    private void printPyramid(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5-i;j++) {
                //System.out.print(" ");
                System.out.print("0");
            }
            for(int k=0;k<=i;k++){
                //System.out.print("* ");
                System.out.print("*1");
            }
            System.out.println();
        }
    }

    /**
     *
     * 1 0 0 0 0 0 0 1
     * 3 3 0 0 0 0 3 3
     * 5 5 5 0 0 5 5 5
     * 7 7 7 7 7 7 7 7
     * 5 5 5 0 0 5 5 5
     * 3 3 0 0 0 0 3 3
     * 1 0 0 0 0 0 0 1
     *
     */
    private void printPattern1(){
        int counter = 1;
        int endLimit = 8;
        boolean add = true;
        int iLimit = 0;
        int pickedCounter = 1;
        for(int i=1;i<endLimit;i++){
            if(add){
                iLimit = i;
            }
            else{
                iLimit = iLimit-1;
            }
            for (int j=0;j<endLimit;j++){
                if(j<iLimit || j >= endLimit - pickedCounter){
                    System.out.print(counter + " ");
                }
                else {
                    System.out.print("0 ");
                }
            }

            if(counter+2 > endLimit){
                add = false;
                pickedCounter = endLimit/2;
            }
            if(add){
                counter = counter + 2;
                pickedCounter++;
            }
            else{
                counter = counter - 2;
                pickedCounter--;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new PatternsPrinting().print();
        System.out.println();
        new PatternsPrinting().printPyramid();
        System.out.println();
        new PatternsPrinting().printPattern1();
    }
}
