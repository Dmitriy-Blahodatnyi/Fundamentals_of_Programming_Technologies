package FSM;

import FSM.enums.Event;
import FSM.enums.State;

import java.util.ArrayList;

public class TransTableFSM extends FSM {

    private ArrayList<Transition> transitions = new ArrayList<>();

    public TransTableFSM() {
        transitions.add(new Transition(State.q0, Event.UNDERSCORE, State.q1));
        transitions.add(new Transition(State.q1, Event.DIGIT, State.q2));
        transitions.add(new Transition(State.q2, Event.DIGIT, State.q2));
        transitions.add(new Transition(State.q2, Event.SHARP, State.q3));
        transitions.add(new Transition(State.q3, Event.SHARP, State.q4));
        transitions.add(new Transition(State.q3, Event.AMPERSAND, State.q5));
        transitions.add(new Transition(State.q4, Event.UPPER, State.q6));
        transitions.add(new Transition(State.q4, Event.PERCENT, State.q7));
        transitions.add(new Transition(State.q5, Event.UPPER, State.q6));
        transitions.add(new Transition(State.q5, Event.PERCENT, State.q7));
        transitions.add(new Transition(State.q6, Event.UPPER, State.q6));
        transitions.add(new Transition(State.q6, Event.PERCENT, State.q7));
    }

    protected State nextState(Event event) {
        return transitions
                .stream()
                .filter(cur -> cur.currentState == currentState && cur.trigger == event)
                .findFirst()
                .map(cur -> cur.nextState)
                .orElse(null);
    }

    class Transition {
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