package com.project.FSM;

import com.project.FSM.enums.Event;
import com.project.FSM.enums.State;

public abstract class FSM {
    State currentState;

    FSM() { currentState = State.q0; }

    private Event recognizeEvent(char symbol) {
        return symbol == '_' ?
                Event.UNDERSCORE :
                symbol >= '0' && symbol <= '9' ?
                        Event.DIGIT :
                        symbol == '#' ?
                                Event.SHARP :
                                symbol == '&' ?
                                        Event.AMPERSAND :
                                        symbol >= 'A' && symbol <= 'Z' ?
                                                Event.UPPER :
                                                symbol == '%' ?
                                                        Event.PERCENT :
                                                        null;
    }

    public boolean scan(String str) {
        if (str == null)
            return false;
        currentState = State.q0;
        for (var ch : str.toCharArray()) {
            if (currentState == null)
                return false;
            currentState = nextState(recognizeEvent(ch));
        }
        return currentState == State.q7;
    }

    protected abstract State nextState(Event event);
}