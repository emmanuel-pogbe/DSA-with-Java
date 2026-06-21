/*On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n - 1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.*/
package stack;

import java.util.List;
import java.util.Arrays;

public class ExclusiveTimeOfFunctions {

    public static String[] parseLog(String log) {
        return log.split(":");
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] callStack = new int[logs.size()];
        int callStackPointer = -1;
        int[] result = new int[n];
        String previousAction = null;
        int timePreviousAction = -1;
        int idPreviousAction = -1;
        for (String log: logs) {
            String[] parsedLogs = parseLog(log);
            int curId = Integer.parseInt(parsedLogs[0]);
            String currentAction = parsedLogs[1];
            int timeOfAction = Integer.parseInt(parsedLogs[2]);

            // push id to callstack if action is start
            if (currentAction.equals("start")) {
                callStackPointer++;
                callStack[callStackPointer] = curId;
                if (previousAction != null && previousAction.equals("start")) {
                    int timeOfExecOfPrevious = timeOfAction - timePreviousAction;
                    result[idPreviousAction] += timeOfExecOfPrevious;
                }
                else if (previousAction != null && previousAction.equals("end")) {
                    if (callStackPointer-1 != -1) {
                        int idToIncrement = callStack[callStackPointer-1];
                        result[idToIncrement] += timeOfAction - timePreviousAction-1;
                    }
                }
                previousAction = currentAction;
                timePreviousAction = timeOfAction;
                idPreviousAction = curId;
            }
            else { // if it is an end - then pop from stack (decrement callStackPointer) first
                callStackPointer--;
                int timeOfExecOfPrevious = 0;
                if (previousAction != null && previousAction.equals("end")) {
                    timeOfExecOfPrevious = timeOfAction - timePreviousAction;
                }
                else {
                    timeOfExecOfPrevious = timeOfAction - timePreviousAction +1;
                }
                previousAction = currentAction;
                timePreviousAction = timeOfAction;
                result[curId] += timeOfExecOfPrevious;
                idPreviousAction = curId;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> stuff = List.of("0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114");
        System.out.println(Arrays.toString(exclusiveTime(8,stuff)));

        // [20,14,35,7,6,9,10,14]
    }
}
