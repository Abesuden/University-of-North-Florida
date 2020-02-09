# Create Stack and language
stackList = ["$"]
language = ["$"]
revLanguage = []

# push reversed token grammer onto the stack
def push(tokenGrammer):
    tokenGrammer = tokenGrammer[0]  # passed in as a list, so must expose the token with this line of code
    # reversedTokenGrammer = ""
    for i in range(len(tokenGrammer)):
        # reversedTokenGrammer += tokenGrammer[(len(tokenGrammer) - 1) - i]
        stackList.append(tokenGrammer[(len(tokenGrammer) - 1) - i])

# used to check current language and token parsing
def printStack():
    stackLine = "----------------------------------"
    print("." + stackLine + "           -== language ==-")
    print ("|" + "".join(stackList) + "                                         " + "".join(revLanguage))
    print("'" + stackLine)

def _reversedLanguage(lang):
    for i in range(len(lang)):
        revLanguage.append(lang[i])
    revLanguage.append("$")

# defines the language used in the parser
def defineLanguage(lang):
    _reversedLanguage(lang)
    for i in range(len(lang)):
        # language.append(lang[i])
        language.append(lang[(len(lang) - 1) - i])

# allow developer to see what is on the top of the stack without removing the value
def peek():    
    peeked = stackList.pop()
    stackList.append(peeked)
    return peeked

# allow developer to see what is on the top of the language stack without removing the value
def peekLang():    
    peeked = language.pop()
    language.append(peeked)
    return peeked

# return the index number for the row
def indexRow(gram):
    if (gram == "S"):
        return 0
    elif (gram == "A"):
        return 1
    elif (gram == "B"):
        return 2
    # else:
        # raise Exception("Error when trying to index row")

# return the index number for the column
def indexColumn(gram):
    if (gram == "a"):
        return 0
    elif (gram == "b"):
        return 1
    elif (gram == "y"):
        return 2
    elif (gram == "$"):
        return 4
    else:
        raise Exception("Error when trying to index column")

# create symbolic table
ERROR = "ERROR"
E = "skip"

table = [
#        a         b         y         $        -== Index Value ==-
# S = 
      [["aBA"], [ERROR], ["BBA"], [ERROR]],             # 0
# A = 
      [[E],     ["bA"],  [E],     [E]],                 # 1
# B = 
      [[ERROR], [ERROR], ["y"],   [ERROR]]              # 2

]

#############################################################################
#                                                                           #
#                             Work Space                                    #
#                                                                           #
#############################################################################

# init variables
flag = True
turns = 1

# define the language to be parsed
defineLanguage("aybbbbbbbbbbb")

# push the starting method onto the stack
push("S")
printStack()

# iterate through the entire language
while (flag):

    # depricated
    # # check if stack and language are empty
    # if ((peek()[0] == "$") & (peekLang()[0] == "$")): # if (true & true)
    #     flag = False
    #     break

    # test if a terminal value
    if (peek()[0].islower()):  # if (true)

        # compare to language or remove epsilon
        if (peek()[0] == peekLang()[0]):  # if (true)
            language.pop()
            stackList.pop()
            
            # update the stack visuals
            for i in range(len(revLanguage)-1):
                if i < range(len(revLanguage)):
                    if (not revLanguage[i+1] == "$"):
                        revLanguage[i] = revLanguage[i+1]
                    else:
                        revLanguage[i] = ""
            continue
        elif (peek()[0] == "skip"):
            stackList.pop()
            print("found epsilon!")
        else:
            # print("Error: language is not LL(1) parsable...?")
            print("REJECT") # acutal place where language is rejected                               # actual rejection spot
            flag = False
            break

    # test if not a terminal value
    if (peek()[0].isupper()):  # if (true)
        
        # find current row and column (token) in table
        row = stackList.pop()
        column = peekLang()

        # replace stack top with next grammer rule
        r = indexRow(row)           # get the row in the table list
        c = indexColumn(column)     # get the column in the table list
        if ((str(type(r)) == "<type 'NoneType'>") | (str(type(c)) == "<type 'NoneType'>")):
            print("REJECT")
            break
        elif ((int(r) == 1) & (int(c) == indexColumn("$"))):  # check if the stack and language are both $'s and accept the language to be LL(1) top down recusrive decent parsable!
            print("")       # print visuals for developer
            printStack()    # print visuals for developer
            print("ACCEPT")
            flag = False
            break
        else:
            push(table[r][c])
    else:
        # print("Error: language is not LL(1) parsable...?")
        print("REJECT")
        flag = False
        break

    # # display testing error
    # print("Error: " + str(peek()[0]) + " is not recognized as upper [" + str(peek()[0].isupper) + "] or lower [" + str(peek()[0].islower) + "]")
    # print("or continue doesn't reset while loop")
    # print("or end of stack? " + str(stackList) + "        " + str(language))

    # display visuals to developer
    print("")
    printStack()

    turns += 1
    if (turns == 25):
        flag = False
        break






