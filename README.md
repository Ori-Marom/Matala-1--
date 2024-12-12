# Matala-1--





### Main Code Summary
In your Main code, you use a Scanner to read inputs from the user, perform calculations, and display results based on the inputs. Here are the primary functions in use:
- `Ex1.isNumber`: Checks if the given string is a number in the specified format (including different bases).
- `Ex1.number2Int`: Converts a number in a specified base format to an integer.
- `Ex1.int2Number`: Converts an integer to a string in a specified base format.
- `Ex1.maxIndex`: Returns the index of the maximum number in a given array of strings.

### Program Flow
1. **Reading Inputs from the User**:
   - The user is prompted to enter two numbers in string format and an output base.
   - If the user types "quit", the program exits the loop and ends.

2. **Validating and Converting Inputs**:
   - The program checks if the inputs are valid numbers in the correct format using `Ex1.isNumber`.
   - If the input is valid, it is converted to an integer using `Ex1.number2Int`.

3. **Performing Calculations**:
   - The program performs addition and multiplication on the given numbers.
   - The results are converted to strings in the specified base format using `Ex1.int2Number`.

4. **Displaying Results**:
   - The results are displayed to the user in the chosen format.

5. **Finding the Maximum Number**:
   - The `Ex1.maxIndex` function calculates the index of the maximum number in an array of the original numbers and the calculated results.
   - The maximum number is displayed to the user.

### Example Output
Suppose the user enters the following inputs:
- First number: `1001b2`
- Second number: `11b3`
- Output base: `10`

The output might look like this:
```
1001b2 + 11b3 = 13
1001b2 * 11b3 = 36
Max number over [1001b2, 11b3, 13, 36] is: 36
```

### Summary
The program is designed to allow the user to input numbers in various formats and bases, perform calculations on them, and display the results in a clear and accurate manner. The code uses validation and conversion functions to ensure the inputs are correct and performs the necessary calculations accordingly.

