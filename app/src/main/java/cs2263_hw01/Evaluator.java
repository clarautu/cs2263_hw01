package cs2263_hw01;

/**
 * @author Autumn Clark
 * CS 2263
 * Takes a String input of a simple arithemtic expression and evaluates it.
 */

public class Evaluator {
    private String passedInput;
    private double solution;

    /**
     * Simple Getter for field passedInput
     * @return String format of the user-entered input
     */
    public String getPassedInput() {
        return passedInput;
    }

    /**
     * Simple Setter for field passedInput
     * @param passedInput Mathematical expression in String format to be evaluated
     */
    public void setPassedInput(String passedInput) {
        this.passedInput = passedInput;
    }

    /**
     * Simple Getter for field solution
     * @return The solution to the user-entered mathematical expression (double)
     */
    public double getSolution() {
        return solution;
    }

    //There is no Setter for solution, as setting the solution to an expression wouldn't make much sense

    /**
     * Default constructor
     */
    public Evaluator() {
    }

    /**
     * Evaluates the arithmetic expression stored within the passedInput field
     * @return The solution to the expression (double)
     */
    public double Evaluate(){
        double solution = 0;
        String[][] splitInput = SplitInput(passedInput);
        // Ints to track first and second dimensions' current index
        int i = 1;
        int j = 0;
        double temp = Double.parseDouble(splitInput[0][0]);
        while(true){
            temp = StepCalculation(temp, Double.parseDouble(splitInput[0][i]), splitInput[1][j]);
            i++;
            j++;
            if (splitInput[0][i] == null){
                break;
            }
        }
        solution = temp;
        return solution;
    }

    /**
     * Splits the passed String into a 2D array of Strings; 1D = numbers; 2D = operands
     * @param input A mathematical expression in String form
     * @return A 2D array of Strings; 1D = numbers; 2D = operands
     */
    private String[][] SplitInput(String input){
        String[][] splitInput = new String[15][15];
        int start = 0;
        int end = 0;
        int firstDim = 0;
        int secondDim = 0;
        while(true){
            char x = input.charAt(end);
            if(x == 42 || x == 47 || x == 43 || x == 45) {
                String temp = "";
                for (int i = start; i < end; i++){
                    temp += input.charAt(i);
                }
                splitInput[0][firstDim] = temp; // Numbers in first dimension
                String operand = "";
                operand += input.charAt(end); // Operands in second dimension
                splitInput[1][secondDim] = operand;
                start = end + 1;
                firstDim++;
                secondDim++;
            }
            // Check if at end of string
            if (end == input.length()-1){
                String temp = "";
                for (int i = start; i <= end; i++){
                    temp += input.charAt(i);
                }
                splitInput[0][firstDim] = temp;
                break;
            }
            end++;
        }
        return splitInput;
    }

    /**
     * Performs a step calculation on two passed numbers and a passed operand
     * @param value The current value of the expression
     * @param nextValue The next value to use for an operation
     * @param operand The operand to be performed
     * @return The new current value of the expression
     */
    private double StepCalculation(double value, double nextValue, String operand){
        char y = operand.charAt(0);
        if (y == 42){
            // Operand is *
            value *= nextValue;
        } else if (y == 47){
            // Operand is /
            value /= nextValue;
        } else if (y == 43){
            // Operand is +
            value += nextValue;
        } else {
            // Operand is -
            value -= nextValue;
        }
        return value;
    }
}

