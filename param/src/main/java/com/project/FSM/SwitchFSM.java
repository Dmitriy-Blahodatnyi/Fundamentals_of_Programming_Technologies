package com.project.FSM;

import com.project.FSM.enums.Event;
import com.project.FSM.enums.State;

public class SwitchFSM extends FSM {
    protected State nextState(Event event) {
        switch (currentState) {
            case q0:
                return event == Event.UNDERSCORE ? State.q1 : null;
            case q1:
                return event == Event.DIGIT ? State.q2 : null;
            case q2:
                return event == Event.DIGIT ?
                        State.q2 :
                        event == Event.SHARP ? State.q3 : null;
            case q3:
                return event == Event.SHARP ?
                        State.q4 :
                        event == Event.AMPERSAND ? State.q5 : null;
            case q4:
            case q5:
            case q6:
                return event == Event.UPPER ?
                        State.q6 :
                        event == Event.PERCENT ? State.q7 : null;
            default:
                return null;
        }
    }
}