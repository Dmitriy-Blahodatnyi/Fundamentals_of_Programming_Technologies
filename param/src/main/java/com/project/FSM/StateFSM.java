package com.project.FSM;

import com.project.FSM.enums.Event;
import com.project.FSM.enums.State;

import java.util.ArrayList;

public class StateFSM extends FSM {
    private static final ArrayList<AbstractState> LIST = new ArrayList<>();

    static {
        LIST.add(new q0());
        LIST.add(new q1());
        LIST.add(new q2());
        LIST.add(new q3());
        LIST.add(new q4());
        LIST.add(new q5());
        LIST.add(new q6());
        LIST.add(new q7());
    }

    protected State nextState(Event event) {
        if (event == null)
            return null;
        var state = setState(currentState);
        return switch (event) {
            case UNDERSCORE -> state.underscore();
            case DIGIT -> state.digit();
            case SHARP -> state.sharp();
            case AMPERSAND -> state.ampersand();
            case PERCENT -> state.percent();
            default -> state.upper();
        };
    }

    private AbstractState setState(State states) {
        return LIST.get(states.ordinal());
    }

    static abstract class AbstractState {
        State underscore() { return null; }

        State digit() { return null; }

        State sharp() { return null; }

        State ampersand() { return null; }

        State percent() { return null; }

        State upper() { return null; }
    }

    static class q0 extends AbstractState {
        protected State underscore() { return State.q1; }
    }

    static class q1 extends AbstractState {
        protected State digit() { return State.q2; }
    }

    static class q2 extends AbstractState {
        protected State digit() { return State.q2; }

        protected State sharp() { return State.q3; }
    }

    static class q3 extends AbstractState {
        protected State sharp() { return State.q4; }

        protected State ampersand() { return State.q5; }
    }

    static class q4 extends AbstractState {
        protected State upper() { return State.q6; }

        protected State percent() { return State.q7; }
    }

    static class q5 extends AbstractState {
        protected State upper() { return State.q6; }

        protected State percent() { return State.q7; }
    }

    static class q6 extends AbstractState {
        protected State upper() { return State.q6; }

        protected State percent() { return State.q7; }
    }

    private static class q7 extends AbstractState {}
}