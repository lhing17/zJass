// Define a grammar called Jass
grammar Jass;

options {
	language = Java;
}

@header {
	package net.moonlightflower.wc3libs.antlr;
}

BOOL_LITERAL:
	'true' | 'false' ;
int_literal:
		ID_INT_LITERAL
	|
		DEC_INT_LITERAL
	|
		OCT_INT_LITERAL
	|
		HEX_INT_LITERAL
	;
DEC_INT_LITERAL:
	[1-9] [0-9]* | [0-9] ;
OCT_INT_LITERAL:
	'0' [0-7]* ;
HEX_INT_LITERAL:
	(('0' [xX]) | '$') [0-9a-fA-F]+ ;
ID_INT_LITERAL:
	'\'' ([\u0000-\u0026\u0028-\u00FF]+) '\'' ;
REAL_LITERAL:
	([0-9]+ '.' [0-9]*) | ('.' [0-9]+) ;
STRING_LITERAL:
	'"' ( EscapeSequence | ~('\\'|'"'|'\r'|'\n') | NEW_LINES )* '"';
NULL_LITERAL:
    'null';

COMMENT_SINGLE:
    '//' (~('\n'|'\r'))*;

COMMENT_BLOCK:
    '/*' (~('*') | ('*' + ~('/')))* '*/';

fragment EscapeSequence: '\\' [abfnrtvz"'\\];
CURLY_L:
	'{' ;
CURLY_R:
	'}' ;
COMMA:
	',' ;
NEW_LINES:
	('\r\n' | '\n' | '\r')+ ;
PARENS_L:
    '(';
PARENS_R:
    ')';
BRACKET_L:
    '[';
BRACKET_R:
    ']';
LOCAL:
    'local';
ARRAY_DECL:
    'array';
CONST_DECL:
    'constant';
BOOL_OP_CONJUNCT:
    'and';
BOOL_OP_DISJUNCT:
    'or' ;
BOOL_OP_NEG:
    'not' ;
GLOBALS_START:
    'globals';
GLOBALS_END:
    'endglobals';
DEBUG:
    'debug';
FUNCTION:
    'function';
ENDFUNCTION:
    'endfunction';
TAKES:
    'takes';
RETURNS:
    'returns';
RETURN:
    'return';
NOTHING:
    'nothing';
ASSIGN_OP:
    '=';
TYPE_DECL:
    'type';
TYPE_EXTENDS:
    'extends';
NATIVE:
    'native';
CALL:
    'call';
SET:
    'set';
IF:
    'if';
THEN:
    'then';
ELSE:
    'else';
ELSEIF:
    'elseif';
ENDIF:
    'endif';
LOOP:
    'loop';
ENDLOOP:
    'endloop';
EXITWHEN:
    'exitwhen';
WS:
	(' ' | '\t')+ -> skip ;
ID:
	ID_START (ID_TAIL)* ;
fragment ID_START:
	[A-Za-z] ;
fragment ID_TAIL:
	[A-Z] | [a-z] | [0-9] | '_' ;
ADD:
    '+';
SUB:
    '-';
MULT:
    '*';
DIV:
    '/';
MOD:
    '%';
LESS:
    '<';
LESS_EQUAL:
    '<=';
EQUAL:
    '==';
UNEQUAL:
    '!=';
GREATER:
    '>';
GREATER_EQUAL:
    '>=';
root:
	NEW_LINES? (top_decl (NEW_LINES top_decl)*)? NEW_LINES?;
top_decl:
    type_decl
    |
    native_decl
    |
    globals_block
    |
    func_impl
    ;
globals_block:
	GLOBALS_START
	NEW_LINES
	(global_decl NEW_LINES)*
	NEW_LINES?
	GLOBALS_END
	;
var_name:
	ID;
func_name:
	ID;
type_name:
	ID;
var_ref:
    ID;
func_ref:
    ID;
type_ref:
    ID;
global_decl:
		type_ref
		ARRAY_DECL
		var_name
	|
		CONST_DECL?
		type_ref
		var_name
		(ASSIGN_OP val=expr)?
	;
expr:
        handle_expr
    |
        null_expr
    |
        code_expr
    |
        bool_expr
    |
        int_expr
    |
        real_expr
    |
        string_expr
    ;
handle_expr:
        handle_literal
    |
        handle_parens
    |
        any_expr_atom
    ;
handle_literal:
    null_literal;
handle_parens:
    PARENS_L handle_expr PARENS_R;
code_expr:
        code_literal
    |
        code_parens
    |
        any_expr_atom
    ;
code_parens:
    PARENS_L code_expr PARENS_R;
code_literal:
        FUNCTION func_ref
    |
        null_literal
    ;
null_expr:
        null_literal
    |
        null_parens
    |
        any_expr_atom
    ;
null_parens:
    PARENS_L null_expr PARENS_R;
null_literal:
    NULL_LITERAL;
bool_expr:
    bool_maybe_disjunct;
bool_maybe_disjunct:
        left=bool_maybe_disjunct BOOL_OP_DISJUNCT right=bool_maybe_conjunct
    |
        exit=bool_maybe_conjunct
    ;
bool_maybe_conjunct:
        left=bool_maybe_conjunct BOOL_OP_CONJUNCT right=bool_maybe_full_relation
    |
        exit=bool_maybe_full_relation
    ;
bool_maybe_full_relation:
        bool_full_relation
    |
        bool_maybe_num_order_relation
    ;
bool_full_relation:
        bool_null_relation
    |
        bool_handle_relation
    |
        bool_code_relation
    |
        bool_bool_relation
    |
        bool_num_relation
    |
        bool_string_relation
    ;
bool_null_relation:
    left=null_expr bool_relation_op right=null_expr;
bool_handle_relation:
    left=handle_expr bool_relation_op right=handle_expr;
bool_code_relation:
    left=code_expr bool_relation_op right=code_expr;
bool_bool_relation:
    left=bool_maybe_num_order_relation bool_relation_op right=bool_maybe_num_order_relation;
bool_num_relation:
    left=num_expr bool_relation_op right=num_expr;
bool_string_relation:
    left=string_expr bool_relation_op right=string_expr;
bool_maybe_num_order_relation:
        bool_num_order_relation
    |
        bool_maybe_unary
    ;
bool_num_order_relation:
    left=num_expr bool_num_order_relation_op right=num_expr;
bool_maybe_unary:
        BOOL_OP_NEG bool_maybe_unary
    |
        bool_atom
    ;
bool_atom:
        any_expr_atom
    |
        bool_literal
    |
        bool_parens
    ;
bool_literal:
    BOOL_LITERAL;
bool_parens:
    PARENS_L bool_expr PARENS_R;
bool_relation_op:
    EQUAL | UNEQUAL;
bool_num_order_relation_op:
    LESS | LESS_EQUAL | GREATER | GREATER_EQUAL;
num_expr:
        int_expr
    |
        real_expr
    ;
int_expr:
    int_maybe_sum;
int_maybe_sum:
        left=int_maybe_sum num_sum_op right=int_maybe_prod
    |
        int_maybe_prod
    ;
int_maybe_prod:
        left=int_maybe_prod num_prod_op right=int_maybe_unary
    |
        int_maybe_unary
    ;
int_maybe_unary:
        num_unary_op int_maybe_unary
    |
        int_atom
    ;
int_atom:
        int_literal
    |
        int_parens
    |
        any_expr_atom
    ;
//int_literal:
	//|
    |
        any_expr_atom
    ;
string_literal:
        STRING_LITERAL
    |
        null_literal
    ;
string_parens:
    PARENS_L string_expr PARENS_R;
string_concat_op:
    ADD;
any_expr_atom:
        func_call
    |
        var_ref
    |
        array_read
    ;
func_call:
	func_ref PARENS_L arg_list PARENS_R;
arg_list:
	(expr (COMMA expr)*)? ;
array_read:
	var_ref BRACKET_L int_expr BRACKET_R;
local_var_decl:
	LOCAL
	(
			(
				type_ref
				ARRAY_DECL
				var_name
			)
		|
			(
				type_ref
				var_name
				(ASSIGN_OP expr)?
			)
	)
	;
local_var_decl_list:
	local_var_decl (NEW_LINES local_var_decl)* ;
statement:
		call
	|
		set_var
	|
		selection
	|
		loop
	|
		exitwhen
	|
		rule_return
	|
	    debug
	;
statement_list:
	statement (NEW_LINES statement)* ;
call:
	CALL
	func_call
	;
set_var:
	SET
		var_ref
		(BRACKET_L index=int_expr BRACKET_R)?
		ASSIGN_OP
		val=expr
	;
condition:
	bool_expr
	;
selection_elseif_branch:
    ELSEIF condition THEN
    NEW_LINES
    statement_list?
    NEW_LINES?
    ;
selection_else_branch:
    ELSE
    NEW_LINES
    statement_list?
    NEW_LINES?
    ;
selection:
	IF condition THEN
		NEW_LINES
		thenStatements=statement_list?
		NEW_LINES?
    elseif_branches+=selection_elseif_branch*
    else_branch=selection_else_branch?
	ENDIF
	;
loop:
	LOOP
		NEW_LINES
		(loop_body NEW_LINES)?
		NEW_LINES?
	ENDLOOP
	;
exitwhen:
	EXITWHEN
	condition
	;
loop_body:
	loop_body_line (NEW_LINES loop_body_line)*;
loop_body_line:
	statement_list
	;
rule_return:
	RETURN
	expr?
	;
debug:
    DEBUG
    (call | set_var | selection | loop)
    ;
func_decl:
	CONST_DECL?
	FUNCTION
	func_name
	TAKES
	params=func_param_list
	RETURNS
	returnType=func_return_type
	;
func_impl:
	func_decl
	NEW_LINES
	(body=func_body NEW_LINES)?
	ENDFUNCTION
	;
func_return_type:
		NOTHING
	|
		type_ref
	;
func_param_list:
		NOTHING
	|
		(params=func_param (COMMA func_param)*)
	;
func_param:
	type_ref
	var_name
	;
func_body:
        local_var_decl_list
    |
        statement_list
    |
		local_var_decl_list NEW_LINES statement_list
	;
type_decl:
	TYPE_DECL
	type_name
	TYPE_EXTENDS
	type_ref
	;
native_decl:
	CONST_DECL?
	NATIVE
	func_name
	TAKES
	params=func_param_list
	RETURNS
	returnType=func_return_type
	;