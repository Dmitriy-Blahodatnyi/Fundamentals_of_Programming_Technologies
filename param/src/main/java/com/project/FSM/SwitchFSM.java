package com.project.FSM;

import com.project.FSM.enums.Event;
import com.project.FSM.enums.State;

public class SwitchFSM extends FSM {
    protected State nextState(Event event) {
        return switch (currentState) {
            case q0 -> event == Event.UNDERSCORE ? State.q1 : null;
            case q1 -> event == Event.DIGIT ? State.q2 : null;
            case q2 -> event == Event.DIGIT ?
                    State.q2 :
                    event == Event.SHARP ? State.q3 : null;
            case q3 -> event == Event.SHARP ?
                    State.q4 :
                    event == Event.AMPERSAND ? State.q5 : null;
            case q4, q5, q6 -> event == Event.UPPER ?
                    State.q6 :
                    event == Event.PERCENT ? State.q7 : null;
            default -> null;
        };
    }
}