grammar Matrix;

ID: [a-zA-Z_][a-zA-Z_0-9]*;

NUMBER: '-'?([0-9]+ | [0-9]+'.'[0-9]+);
VECTOR: '['NUMBER(','WHITESPACE* NUMBER)*']' ;
MATRIX: '['VECTOR(','WHITESPACE* VECTOR)*']' ;

EQUAL: '=';
WHITESPACE: [ \n\t\r]+ -> skip;
LB: '(';
RB: ')';
NL: '\n';
PLUS: '+';
MULTIPLE: '*';
INVERSE: '^-1';

root:
     input EOF# RootRule
;

input:
    assignment EOF # ToSetVariable
    | sum NL? EOF # ExecuteExpression
;

assignment:
	ID EQUAL sum # MakeAssignment
;

sum:
    sum PLUS multiple # MakePlus
    | multiple # ToMultiple
;

multiple:
    multiple MULTIPLE inverse # MakeMultiple
    | inverse # ToInverse
;

inverse:
    inverse INVERSE # MakeInverse
    | atom # ToAtom
;

atom:
    NUMBER # MakeNumber
    | MATRIX # MakeMatrix
    | ID # Variable
    | LB sum RB # MakeBraces
;