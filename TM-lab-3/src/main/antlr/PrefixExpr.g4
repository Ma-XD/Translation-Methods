grammar PrefixExpr;

run returns [String value]
    : prefixExpr[""] EOF
        { $value = $prefixExpr.value; }
;

prefixExpr[String tabs] returns [String value]
    : section[$tabs] (p=prefixExpr[$tabs])?
        { $value = $section.value + ($p.text != null ? "\n" + $p.value : ""); }
;

section[String tabs] returns [String value]
    : action[$tabs]
        { $value = $tabs + $action.value; }
    | ifBranch[$tabs]
        { $value = $tabs + $ifBranch.value; }
    | LBRACKET prefixExpr[$tabs] RBRACKET
        { $value = $prefixExpr.value; }
;

action[String tabs] returns [String value]
    : PRINT expr
        { $value = "print(" + $expr.value + ")"; }
    | ASSIGN VAR expr
        { $value = $VAR.text + " = " + $expr.value; }
    | WHILE expr section[$tabs + "\t"]
        { $value = "while " + $expr.value + ":\n" + $section.value; }
;

ifBranch[String tabs] returns [String value]
    : IF expr section[$tabs + "\t"] elseBranch[$tabs]
        { $value = "if " + $expr.value + ":\n" + $section.value + $elseBranch.value; }
;

elseBranch[String tabs] returns [String value]
    : action[$tabs + "\t"]
        { $value = "\n" + $tabs + "else:\n" + $tabs + "\t" + $action.value; }
    | ifBranch[$tabs]
        { $value = "\n" + $tabs + "el" + $ifBranch.value; }
    |
        { $value = ""; }
;

expr returns [String value]
    : BINARY_OP a1=expr a2=expr
        { $value = "(" + $a1.value + " " + $BINARY_OP.text + " " + $a2.value + ")"; }
    | NOT expr 
        { $value = "(" + $NOT.text + " " + $expr.value + ")"; }
    | NEGATE expr
        { $value = "-" + $expr.value; }
    | operand
        { $value = $operand.text; }
;

operand
    : BOOL
    | VAR
    | INT
;

LBRACKET : '{';
RBRACKET : '}';

WHILE : 'while';
IF : 'if';
PRINT : 'print';
ASSIGN : '=';

BINARY_OP 
    : AND | OR 
    | EQUAL | NOT_EQUAL | GREATER | LESS | GREATER_EQUAL | LESS_EQUAL
    | PLUS | MINUS | MULTIPLY | DIVIDE
;

AND : 'and';
OR : 'or';
NOT : 'not';

EQUAL : '==';
NOT_EQUAL : '!=';
GREATER : '>';
LESS : '<';
GREATER_EQUAL : '>=';
LESS_EQUAL : '<=';

PLUS : '+';
MINUS : '-';
MULTIPLY : '*';
DIVIDE : '/';
NEGATE : '~';

BOOL : 'True' | 'False';
VAR : [a-zA-Z][a-zA-Z0-9_]*;
INT : [0-9]+;

WS : [ \t\r\n]+ -> skip;