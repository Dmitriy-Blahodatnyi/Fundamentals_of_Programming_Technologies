package FSM;

import FSM.enums.Event;
import FSM.enums.State;

import java.util.ArrayList;

public class StateFSM extends FSM {
    private static ArrayList<AbstractState> list = new ArrayList<>();

    static {
        list.add(new q0());
        list.add(new q1());
        list.add(new q2());
        list.add(new q3());
        list.add(new q4());
        list.add(new q5());
        list.add(new q6());
        list.add(new q7());
    }

    protected State nextState(Event event) {
        if (event == null) return null;
        var state = setState(currentState);
        switch (event) {
            case UNDERSCORE:
                return state.underscore();
            case DIGIT:
                return state.digit();
            case SHARP:
                return state.sharp();
            case AMPERSAND:
                return state.ampersand();
            case PERCENT:
                return state.percent();
            default:
                return state.upper();
        }
    }

    private AbstractState setState(State states) {
        return list.get(states.ordinal());
    }

    static abstract class AbstractState {
        State underscore() {
            return null;
        }
        State digit() {
            return null;
        }
        State sharp() {
            return null;
        }
        State ampersand() {
            return null;
        }
        State percent() {
            return null;
        }
        State upper() {
            return null;
        }
    }

    static class q0 extends AbstractState {
        protected State underscore() {
            return State.q1;
        }
    }

    static class q1 extends AbstractState {
        protected State digit() {
            return State.q2;
        }
    }

    static class q2 extends AbstractState {
        protected State digit() {
            return State.q2;
        }
        protected State sharp() {
            return State.q3;
        }
    }

    static class q3 extends AbstractState {
        protected State sharp() {
            return State.q4;
        }
        protected State ampersand() {
            return State.q5;
        }
    }

    static class q4 extends AbstractState {
        protected State upper() {
            return State.q6;
        }
        protected State percent() {
            return State.q7;
        }
    }

    static class q5 extends AbstractState {
        protected State upper() {
            return State.q6;
        }
        protected State percent() {
            return State.q7;
        }
    }

    static class q6 extends AbstractState {
        protected State upper() {
            return State.q6;
        }
        protected State percent() {
            return State.q7;
        }
    }

    private static class q7 extends AbstractState {
    }
}