package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static void testThreeAddThreeRemove() {
        AListNoResizing<Integer> trueList = new AListNoResizing<>();
        BuggyAList<Integer> falseList = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            trueList.addLast(i + 4);
            falseList.addLast(i + 4);
        }

        assertEquals(trueList.size(), falseList.size());

        for (int i = 0; i < 3; i++) {
            int x = trueList.removeLast();
            int y = falseList.removeLast();
            assertEquals(x, y);
        }
    }

    public static void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> K = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                K.addLast(randVal);
                assertEquals(L.size(), K.size());
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = K.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0) {
                    int lastVal1 = L.getLast();
                    int lastVal2 = K.getLast();
                    assertEquals(lastVal1, lastVal2);
                }
            } else if(operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    int removeVal1 = L.removeLast();
                    int removeVal2 = K.removeLast();
                    assertEquals(removeVal1, removeVal2);
                }
            }
        }
    }

    public static void main(String[] args) {
        testThreeAddThreeRemove();
        randomizedTest();
    }
}
