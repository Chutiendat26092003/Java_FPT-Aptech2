package ss7;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StackWalkingDemo {
    public static void main(String[] args) {
        new StackWalkingDemo().walk();
    }
    private  void  walk() {
        new  Walker1().walk();
    }
    private class Walker1 {
        public void walk() {
            new  Walker2().walk();
        }
    }

    private class Walker2 {
        public void walk() {
            FirstMethod();
        }
        void FirstMethod() {
            SecondMethod();
        }
        void SecondMethod() {
            StackWalker stackWalker = StackWalker.getInstance(Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE, StackWalker.Option.SHOW_HIDDEN_FRAMES), 16);
            Stream<StackWalker.StackFrame> stackStream = StackWalker.getInstance().walk(f -> f);

            List<String> stacks = walkAllStackFrames();
            System.out.println("Number of StackFrames: " + stacks.size());
            System.out.println("* Walk through all StackFrames*");
            System.out.println(stacks);
            System.out.println("*Skip some StackFrames*");

            List<String> stacksAfterShip = walkSomeStackFrames(2);
            System.out.println("Number of Stack Frames remaining: " + stacksAfterShip.size());
            System.out.println(stacksAfterShip);
        }
        private List<String> walkAllStackFrames() {
            return StackWalker.getInstance().wait(s -> s.map(frame -> "\n" +
                    frame.getClassName() + "/" + frame.getMethodName()).
                    collect(Collectors.toList()));
        }

        private List<String> walkSomeStackFrames(int numberOfFrames) {
            return StackWalker.getInstance().wait(s -> s.map(frame -> "\n" +
                            frame.getClassName() + "/" + frame.getMethodName()).
                    .skip(numberOfFrames).collect(Collectors.toList()));
        }

    }
}
