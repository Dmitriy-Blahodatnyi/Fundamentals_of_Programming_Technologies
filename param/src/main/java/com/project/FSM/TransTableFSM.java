package com.project.FSM;

import com.project.FSM.enums.Event;
import com.project.FSM.enums.State;

import java.util.ArrayList;

public class TransTableFSM extends FSM {
    private final ArrayList<Transition> TRANSITIONS = new ArrayList<>();

    public TransTableFSM() {
        TRANSITIONS.add(new Transition(State.q0, Event.UNDERSCORE, State.q1));
        TRANSITIONS.add(new Transition(State.q1, Event.DIGIT, State.q2));
        TRANSITIONS.add(new Transition(State.q2, Event.DIGIT, State.q2));
        TRANSITIONS.add(new Transition(State.q2, Event.SHARP, State.q3));
        TRANSITIONS.add(new Transition(State.q3, Event.SHARP, State.q4));
        TRANSITIONS.add(new Transition(State.q3, Event.AMPERSAND, State.q5));
        TRANSITIONS.add(new Transition(State.q4, Event.UPPER, State.q6));
        TRANSITIONS.add(new Transition(State.q4, Event.PERCENT, State.q7));
        TRANSITIONS.add(new Transition(State.q5, Event.UPPER, State.q6));
        TRANSITIONS.add(new Transition(State.q5, Event.PERCENT, State.q7));
        TRANSITIONS.add(new Transition(State.q6, Event.UPPER, State.q6));
        TRANSITIONS.add(new Transition(State.q6, Event.PERCENT, State.q7));
    }

    protected State nextState(Event event) {
        return TRANSITIONS.stream()
                .filter(cur -> cur.currentState == currentState &&
                        cur.trigger == event)
                .findFirst()
                .map(cur -> cur.nextState)
                .orElse(null);
    }

    static class Transition {
        State currentState;
        Event trigger;
        State nextState;

        Transition(State currentState, Event trigger, State nextState) {
            this.currentState = currentState;
            this.trigger = trigger;
            this.nextState = nextState;
        }
    }
}