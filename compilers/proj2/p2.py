import sys
import re

# create global variables
isAccepted = True

# create global lists of first sets
firstProgram               = ["INT","void"]
firstDeclarationList       = ["INT","void"]
first_declarationList      = ["INT","void","E"]
firstDeclaration           = ["INT","void"]
firstVarDeclaration        = ["INT","void"]
firstVarDeclaration_       = [";","["]
firstTypeSpecifier         = ["INT","void"]
firstFunDeclaration        = ["INT","void"]
firstParams                = ["INT","void"]
firstParamList             = ["INT","void"]
first_paramList            = [",","E"]
firstParam                 = ["INT","void"]
firstParam_                = ["["]
firstCompoundStmt          = ["{"]
firstLocalDeclarations     = ["E","INT","void"]
first_localDeclarations    = ["INT","void","E"]
firstStatementList         = ["E","ID","(","NUM",";","{","if","while","return"]
first_statementList        = ["ID","(","NUM",";","{","if","while","return","E"]
firstStatement             = ["ID","(","NUM",";","{","if","while","return"]
firstExpressionStmt        = ["ID","(","NUM",";"]
firstSelectionStmt         = ["if"]
firstSelectionStmt_        = ["else"]
firstiterationStmt         = ["while"]
firstReturnStmt            = ["return"]
firstReturnStmt_           = [";","ID","(","NUM"]
firstExpression            = ["ID","(","NUM"]
firstVar                   = ["ID"]
firstVar_                  = ["["]
firstSimpleExpression      = ["(","ID","NUM"]
firstSimpleExpression_     = ["<=","<",">",">=","==","!="]
firstRelop                 = ["<=","<",">",">=","==","!="]
firstAdditiveExpression    = ["(","ID","NUM"]
first_additiveExpression   = ["+","-","E"]
firstAddop                 = ["+","-"]
firstTerm                  = ["(","ID","NUM"]
first_term                 = ["*","/","E"]
firstMulop                 = ["*","/"]
firstFactor                = ["(","ID","NUM"]
firstCall                  = ["ID"]
firstArgs                  = ["ID","(","NUM","E"]
firstArgList               = ["ID","(","NUM"]
first_argList              = [",","E"]

# read in language
developerOutputFile = "tokenizedFile_n00850421.txt"
fIn = open(developerOutputFile, "r")

# define language for testing
language = [
#   return 2 + 2 / (5 + 5);
    # "}", ";", ")", ",", "(", "ID", "{", ")", "void", "(", "ID", "INT" #  -- test line
    # "}", ";", "ID", "INT", ";", "NUM", "=", ";", "ID", ";", "ID", "INT", "{", ")", "void", "(", "ID", "INT" #  -- supposed to reject, try when get "=" working
    # "}", ";", "]", "NUM", "=", "ID", "[", "ID", "{", ")", "void", "(", "ID", "void" #  -- I feel like this isnt acceptable  a[a = 4];
    # "}", ";", ")", "(", "ID", "{", ")", "void", "(", "ID", "void", ";", "]", "NUM", "[", "ID", "INT" # 32 -- exits early
    # "}", ";", "]", "NUM", "[", "ID", "void", "{", ")", "void", "(", "ID", "void"  #21  -- looks like same problem b/c [ is in same place as =
]
# notes of language
    # cant do this?
        # if (x == 4) { x = 5 }
    # can do this?
        # if (x);

# set language array
tokenIn = []
for i in fIn:
    tokenIn.append(i.rstrip()) # must strip \n chars so using .rstrip()
for i in range(len(tokenIn)):
    language.append(tokenIn[(len(tokenIn)-i)-1])


# get next token
def nextToken():
    global token
    oldToken = token
    if (len(language) == 0):
        token = "END"
    else:
        token = language.pop()
    print ("[" + oldToken + "] old - new [" + token + "]")
"""        i should not be returning anything
		print("Accepted!")
        return "END"
    else:
        return str(language.pop())
"""

# look at the next token
def nextTokenPeek():
	nxtTkn = language.pop()
	language.append(nxtTkn)
	return nxtTkn

# check terminal to see if it matches the token
def terminalCheck(tokenString, terminalString):
    global isAccepted
    if (tokenString == terminalString):
        nextToken()
        return True            # ACCEPT
    else:
        isAccepted = False  # REJECT
        return False

# reject and end syntax analyser
def reject():
    print("REJECT")
    sys.exit()

# Start of parser -------------------------------------------------------------------------------------------------------------------------------- start of parser
# 1
def program():
    declarationList()

#2
def declarationList():
    # print(token)
    declaration()        # b
    _declarationList()    # A`

def _declarationList():
    # print(token)
    if (token in firstDeclaration):
        declaration()        # a
        _declarationList()    # A`
    elif (token == "END"):
        1+1 #E                           ###
        # print("HERE ---------")
    else:
        1+1 #E                           ###

#3
def declaration():
    global isAccepted
    if ((token in firstVarDeclaration) & ((language[len(language)-3] == ";") | (language[len(language)-2] == ";") | (language[len(language)-2] == "["))):
        varDeclaration()
    elif (token in firstFunDeclaration):
        funDeclaration()
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#4
def varDeclaration():    # left factor
    typeSpecifier()
    terminalCheck(token, "ID")
    varDeclaration_()

def varDeclaration_():    # left factor
    global isAccepted
    if(token == ";"):
        nextToken()
        #continue
    elif (token == "["):
        nextToken()
        terminalCheck(token, "NUM")
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

###5
def typeSpecifier():
    global isAccepted
    if (token == "INT"):
        nextToken()
        #continue
    elif (token == "void"):
        nextToken()
        # print(token) #####################################################################
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

###6
def funDeclaration():
    # print(token)
    typeSpecifier()
    # print(token)
    terminalCheck(token, "ID")
    # print(token)
    terminalCheck(token, "(")
    # print(token)
    params()
    # print(token)
    terminalCheck(token, ")")
    # print(token)
    compoundStmt()
    # print(token)

#7
def params():
    global isAccepted
    if ((token in firstParamList) & (language[len(language)-1] != ")")):
        paramList()
    elif (token == "void"):
        nextToken()
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#8
def paramList():
    param()        # b
    _paramList()    # A`

def _paramList():
    if (token == ","):
        nextToken()
        param()        #|
        _paramList()    # A`
    else:
        1+1 #E                           ###

#9
def param():    # left factor
    typeSpecifier()
    terminalCheck(token, "ID")
    param_()
        
def param_():    # left factored
    if (token == "["):
        nextToken()
        terminalCheck(token, "]")
    else:
        1+1 # E    b/c look at book

###10
def compoundStmt():
    terminalCheck(token, "{")
    localDeclarations()
    statementList()
    terminalCheck(token, "}")

#11
def localDeclarations():
    1+1 #E                                                ###    ###    ???        # b
    _localDeclarations()# A`

def _localDeclarations():
    if (token in firstVarDeclaration):
        varDeclaration()    # a
        _localDeclarations()# A
    else:
        1+1 #E                                ###

#12
def statementList():
    1+1 #E                                                ###    ###    ???        # b
    _statementList()    # A`

def _statementList():
    if (token in firstStatement):
        statement()            # a
        _statementList()    # A`
    else:
        1+1 #E                                ###

#13
def statement():
    global isAccepted
    if (token in firstExpressionStmt):
        expressionStmt()
    elif (token in firstCompoundStmt):
        compoundStmt()
    elif (token in firstSelectionStmt):
        selectionStmt()
    elif (token in firstiterationStmt):
        iterationStmt()
    elif (token in firstReturnStmt):
        returnStmt()
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#14
def expressionStmt():
    global isAccepted
    if (token in firstExpression):
        expression()
        terminalCheck(token, ";")
    elif (token == ";"):
        nextToken()
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#15
def selectionStmt():    # left factor
    terminalCheck(token, "if")
    terminalCheck(token, "(")
    expression()
    terminalCheck(token, ")")
    statement()
    selectionStmt_()

def selectionStmt_():    # left factored
    if (token == "else"):
        nextToken()
        statement()
    else:
        1+1 # E     b/c check book

#16
def iterationStmt():
    terminalCheck(token, "while")
    terminalCheck(token, "(")
    expression()
    terminalCheck(token, ")")
    statement()

#17
def returnStmt():   # Left factor
    terminalCheck(token, "return")
    returnStmt_()

def returnStmt_():   # Left factored
    global isAccepted
    if (token == ";"):
        nextToken()
        #continue
    elif (token in firstExpression):
        expression()
        terminalCheck(token, ";")
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#18                            <-------------------- Right Recursed?
def expression():
    global isAccepted
    if ((token in firstVar) & ((language[len(language)-1] == "=") | (language[len(language)-2] == "=") | (language[len(language)-1] == "[") | (language[len(language)-2] == "["))):
        var()
        terminalCheck(token, "=")
        expression()
    elif(token in firstSimpleExpression):
        simpleExpression()
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#19
def var():  # left factor
    terminalCheck(token, "ID")
    var_()

def var_():  # left factored
    if (token == "["):
        nextToken()
        expression()
        terminalCheck(token, "]")
    else:
        1+1 # E    b/c check book
#20
def simpleExpression():    # left factor
    additiveExpression()
    simpleExpression_()

def simpleExpression_():    # left factored
    if (token in firstRelop):
        relop()
        additiveExpression()
    else:
         1+1 # E    b/c check book

###21
def relop():
    global isAccepted
    if (token == "<="):
        nextToken()
        #continue
    elif (token == "<"):
        nextToken()
        #continue
    elif (token == ">"):
        nextToken()
        #continue
    elif (token == ">="):
        nextToken()
        #continue
    elif (token == "=="):
        nextToken()
        #continue
    elif (token == "!="):
        nextToken()
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False


#22
def additiveExpression():
    term()                    # b
    _additiveExpression()    # A`

def _additiveExpression():
    if (token in firstAddop):
        addop()                    #|__ # a
        term()                    #|
        _additiveExpression()    # A`
    else:
        1+1 #E                                    ###

#23
def addop():
    global isAccepted
    if (token == "+"):
        nextToken()
        #continue
    elif (token == "-"):
        nextToken()
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#24
def term():
    factor()    # b
    _term()        # A`

def _term():
    if (token in firstMulop):
        mulop()        #|__ a
        factor()    #|
        _term()        # A`
    else:
        1+1 #E                            ###

###25
def mulop():
    global isAccepted
    if (token == "*"):
        nextToken()
        #continue
    elif (token == "/"):
        nextToken()
        #continue
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

#26
def factor():
    global isAccepted
    if (token == "("):
        nextToken()
        expression()
        terminalCheck(token, ")")
    elif ((token in firstVar) & (language[len(language)-1] != "(")):
        var()
    elif (token in firstCall):
        call()
    elif (token == "NUM"):
        nextToken()
    elif (token == "END"):
        1+1
    else:
        isAccepted = False

###27
def call():
    terminalCheck(token, "ID")
    terminalCheck(token, "(")
    args()
    terminalCheck(token, ")")

#28
def args():
    if (token in firstArgList):
        argList()
    else:
        1+1 #E                                                ###    ###    ???

#29
def argList():
    expression()    # b
    _argList()        # A`

def _argList():
    if (token == ","):
        nextToken()
        expression()    #|
        _argList()        # A`
    else:
        1+1 #E                                ###

# start of program ------------------------------------------------------------------------------------------------------------------- start of program
# open file in



#print language
revLanguage =[]
for i in range(len(language)):
    revLanguage.append(language[len(language) - i - 1])
    revLanguage.append(" ")
print ("Language:")
print ("".join(revLanguage))
print ("\n")

# run parser
if (len(language) > 0):
    token = language.pop()
else:
    reject()
print (token)
program()

# tell user whether the syntax is accepted or not
print(len(language))
if (token != "END"):
    isAccepted = False
if (len(language) > 0):
    isAccepted = False
print(isAccepted)
if(isAccepted):
    print("ACCEPT")    # send to symantix analyser
    print ("\n")
    print (language)
    print (token)
else:
    print("REJECT")    # stops here

# close file
###fl.close()



