Scenario: Entering and saving a variable
Given a new evaluator
When I evaluate string <input>
Then I should get result <result>

Examples:
|input                                                                                  |result                                                                                  |
|A=[[54, 65.4], [64.78, -98.45]]                                                        |MATRIX={ [ 54.00 65.40 ]  [ 64.78 -98.45 ] }                                            |
|B=[[-45.12]]                                                                           |MATRIX={ [ -45.12 ] }                                                                   |
|C=([[5.0, -32, 34.4]]*5)                                                               |MATRIX={ [ 25.00 -160.00 172.00 ] }                                                     |
|D=(([[5.56,    12.98,  76]] + [[76.34, 9.12,   -387.34]])*[[1], [2], [3]])             |MATRIX={ [ -807.92 ] }                                                                  |
|E=(([[34.56, 78.98], [877.56, 98.123]]^-1)*[[9.2], [-8.4]])                            |MATRIX={ [ -0.02 ]  [ 0.13 ] }                                                          |

Scenario: Querying saved values
Given a new evaluator
When I evaluate string <input1>
When I evaluate string <input2>
When I evaluate string <input3>
When I evaluate string <input4>
Then I should get result <result>

Examples:
|input1                                                             |input2                |input3                                  |input4                       |result                                                                                |
|A = [[2, -2, 1]]                                                   |B = [[1, 5, 2]]       |C = ((A + B) * [[1], [2], [3]])         |C = [[45]]                   |MATRIX={ [ 45.00 ] }                                                                  |
|A = [[1, 2], [2, 1]]                                               |B = [[1, 2], [2, 1]]  |C = A + B                               |C + A                        |MATRIX={ [ 3.00 6.00 ]  [ 6.00 3.00 ] }                                               |
|A = [[1.43, 3.87, 2.98], [3.34, 2.12, 1], [3, 1, 2]]               |B = 0.5               |C = (A*B)^-1                            |C * 46                       |MATRIX={ [ -16.02 23.53 12.10 ]  [ 18.19 30.06 -42.14 ]  [ 14.93 -50.33 48.92 ] }     |
|A = [[3, 4], [2, 1]]                                               |B = 1                 |C = A * B                               |C^-1                         |MATRIX={ [ -0.20 0.80 ]  [ 0.40 -0.60 ] }                                             |