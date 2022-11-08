## Race Car task
Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.

#### Example 1:
 ```
Input: target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0 --> 1 --> 3.
 ```


#### Example 2:
 ```
Input: target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.
 ```

#### Constraints:
1 <= target <= 10^4


## Solution

we use accelerate until (position + speed) > target, then we consider a variety of options for each new position and speed that appears: we use both accelerate and reverse to find the optimal solution. If (position + speed < target) and the speed is negative, then it is necessary to make a reverse move.

In order not to consider the same options several times, it is necessary to keep the position and speed as control points. A hash set was selected for storage, because the algorithmic complexity of inserting and searching in the collection is O(1).

To store the positions and speeds from which the next step will be taken, an ArrayList<int[]> is used, because the algorithmic complexity when inserting at the end and getting/deleting an element by index is O(1).

## Performance
Run on JDK 11

| **target value** | **number of elements in the tree** | **result** | **excecution time** | **memory usage** |
|:----------------:|:----------------------------------:|:----------:|:-------------------:|:----------------:|
|         89         |                231                 |     18     |       0.002s        |         2.8MB         |
|       1343        |                1756                |     33     |       0.005s        |      2.8MB       |
|       8930       |                5843                |     44     |       0.008s        |      3.3MB       |



## How to start
Install JDK 11

Run in directory for compilation and start
```
javac RaceCarSolution.java
java Main {target_value}
```


## Test data
| **target** | **result** |
|:------:|:------:|
|   3    |   2    |
|  111   |   15   |
|  4356  |   28   |
|  9301  |   43   |