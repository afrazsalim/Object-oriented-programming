from tkinter import *
import random

#Firts Random value by initialization
randomValue = random.randint(1,7)
#Initialization of all the models
def initialize():
    # called once when the game is started (main() executed)
    # [ put your own model/representation
    # initialization here ]

   return {"dimensions":(10,20), "T-Shape": {"x1": 5, "y1": 0, "x2": 6, "x3": 7,"y2":1,"y3":-1,"state":1},#
               "square": {"x": 6, "y": 0, "z": 5, "b": 1,"state":1},#
               "LShape": {"x1": 5, "y1": 0,"x2":6, "y2": 1,"x3":-1,"y3":2,"state":1},
               "L": {"x": 5, "y": 0,"xx":6,"x3":7, "yy": 1,"yyy":2,"state":1},#
               "LL": {"x1": 5, "y1": 0,"x2":6, "y2": 1,"x3":7,"y3":2,"state":2},
               "Half": {"x1": 5, "y1": 0,"x2":6, "y2": 1,"x3":7,"y3":2,"state":1},
               "Line": {"x": 3,"x1":-1,"x2":-1,"x3":-1,"x4":-1,"y": 0,"yy":1, "yyy": 2,"yo":3,"state":1},#
               "i":randomValue}
    # the data structure returned from this method
    # is passed as parameter ''model'' to the functions
    # draw(), onkey() and onloop() below

#draws the lines at the side of the Frame
def draw_lines(canvas):
    canvas.create_line(240, 0, 240, canvas_dimensions[1]-15, fill="blue", width=5)
    canvas.create_line(0, 0, 0, 485, fill="blue", width=10)
    canvas.create_line(0, 485, 240, 485, fill='red', width=6)

#Return True if the array cell is filled with a value greater than 0.It mean that the
#current piece can,t overlap that piece.
def isMarked(x,y,record,i):
    if(record[x][y] > 0):
        return True
    else:
        return False
#Return True if the array cell is filled with a value greater than 0.It mean that the
#current piece can,t overlap that piece.
def isSaved(x,y,record,i):
       i =2
       if(record[y][x] > 0):
           return True
       else:
           return False

#Return True if the co-ordinates are equal to the square design and also checks for the
#which model is being used
def isEqualSquare(x,y,square,i):
    if(square["state"] == 1):
           if(x == square["x"]  and y == square["y"] and square["y"] >= 0 and square["x"] >= 0 ):
               return True
           if(x == square["x"] and y == square["b"] and square["b"] >=0 and square["x"] >= 0 ):
               return True
           if(x == square["z"] and y == square["y"] and square["z"] >= 0 and square["y"]  >= 0 ):
               return True
           if(x == square["z"] and y == square["b"] and square["b"] >= 0 and square["z"] >= 0 ):
               return True


#Return True if the co-ordinates are equal to the LShape design and also checks for the
#which model is being used
def isEqualL(x,y,square,i):
    if(square["state"] == 1):
            if(x == square["x"]  and y == square["y"] ):
               return True
            elif(x == square["x"] and y == square["yy"] ):
               return True
            elif(x == square["x"] and y == square["yyy"]):
               return True
            elif(x == square["xx"] and y == square["yyy"]):
               return True
    elif(square["state"] == 2):
            if(x == square["x"]  and y == square["y"] ):
               return True
            elif(x == square["x"] and y == square["yy"]):
               return True
            elif(x == square["xx"] and y == square["y"] ):
               return True
            elif(x == square["x3"] and y == square["y"]):
               return True
    elif(square["state"] == 3):
            if(x == square["xx"]  and y == square["y"] ):
               return True
            elif(x == square["x3"] and y == square["y"] ):
               return True
            elif(x == square["x3"] and y == square["yy"] ):
               return True
            elif(x == square["x3"] and y == square["yyy"] ):
               return True
    elif(square["state"] == 4):
            if(x == square["x"]  and y == square["yyy"] ):
               return True
            elif(x == square["xx"] and y == square["yyy"] ):
               return True
            elif(x == square["x3"] and y == square["yyy"]):
               return True
            elif(x == square["x3"] and y == square["yy"]):
               return True

#Return True if the co-ordinates are equal to the TShape design and also checks for the
#which model is being used
def isEqualTShape(x,y,square,i):
    if(square["state"] == 1):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
            elif(x == square["x3"] and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y2"] ):
               return True
    elif(square["state"] == 2):
            if(x == square["x1"]  and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y3"]):
               return True
            elif(x == square["x2"] and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y2"]):
               return True
    elif(square["state"] == 3):
            if(x == square["x1"]  and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y1"]):
               return True
            elif(x == square["x3"] and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y3"]):
               return True
    elif(square["state"] == 4):
            if(x == square["x2"]  and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y3"]):
               return True
            elif(x == square["x3"] and y == square["y1"]):
               return True
            elif(x == square["x2"] and y == square["y2"]):
               return True

#Return True if the co-ordinates are equal to the opposite L design and also checks for the
#which model is being used
def isEqualToInverseL(x,y,square,i):
    if(square["state"] == 1):
            if(x == square["x1"]  and y == square["y3"]):
               return True
            elif(x == square["x2"] and y == square["y3"]):
               return True
            elif(x == square["x2"] and y == square["y2"] ):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
    elif(square["state"] == 2):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            elif(x == square["x1"] and y == square["y2"]):
               return True
            elif(x == square["x2"] and y == square["y2"] ):
               return True
            elif(x == square["x3"] and y == square["y2"]  and square["x2"] >= 0 ):
               return True
    elif(square["state"] == 3):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            elif(x == square["x1"] and y == square["y2"]):
               return True
            elif(x == square["x1"] and y == square["y3"] ):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
    elif(square["state"] == 4):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
            elif(x == square["x3"] and y == square["y1"]):
               return True
            elif(x == square["x3"] and y == square["y2"]):
               return True



#Return True if the co-ordinates are equal to the Half square design and also checks for the
#which model is being used
def isEqualToLL(x,y,square,i):
     if(square["state"] == 1):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y2"] ):
               return True
            elif(x == square["x3"] and y == square["y2"]):
               return True
     elif(square["state"] == 2):
            if(x == square["x1"]  and y == square["y2"] ):
               return True
            elif(x == square["x1"] and y == square["y3"]):
               return True
            elif(x == square["x2"] and y == square["y1"] ):
               return True
            elif(x == square["x2"] and y == square["y2"] ):
               return True


#This main function is being called every time and it checks which model is being used or the
#co-ordinates are equal to that model
def isEqual(x,y,square,i):
   if(i == 2):
       if(isEqualSquare(x,y,square,i)):
           return True
   elif(i == 1):
       if(isEqualTShape(x,y,square,i)):
           return True
   elif(i == 4):
       if(isEqualL(x,y,square,i)):
           return True
   elif(i == 3):
            if(isEqualToInverseL(x,y,square,i)):
                return True
   elif(i == 5):
            if(isEqualToLL(x,y,square,i)):
                return True
   elif(i == 6):
           if(isEqualToHalf(x,y,square,i)):
               return True
   elif(i == 7):
          if(isMarkedLine(square,x,y,i)):
             return True
          else:
               return False


#Return True if the co-ordinates are equal to the oppsite Half square design and also checks for the
#which model is being used
def isEqualToHalf(x,y,square,i):
    if(square["state"] == 1):
            if(x == square["x1"]  and y == square["y2"] ):
               return True
            if(x == square["x2"] and y == square["y1"] ):
               return True
            if(x == square["x2"] and y == square["y2"]):
               return True
            if(x == square["x3"] and y == square["y1"] ):
               return True
    elif(square["state"] == 2):
            if(x == square["x1"]  and y == square["y1"] ):
               return True
            if(x == square["x1"] and y == square["y2"]):
               return True
            if(x == square["x2"] and y == square["y2"]):
               return True
            if(x == square["x2"] and y == square["y3"]):
               return True





#Return True if the co-ordinates are equal to the Line design and also checks for the
#which model is being used
def isMarkedLine(square,x,y,i):
            if(x == square["x"]  and y == square["y"] and square["x"] >= 0 ):
               return True
            if(x == square["x"] and y == square["yy"] and square["x"]>= 0 and square["yy"] >= 0 ):
               return True
            if(x == square["x"] and y == square["yyy"] and square["x"] >= 0 and square["yyy"] >= 0 ):
               return True
            if(x == square["x"] and y == square["yo"] and square["x"] >= 0 and square["yo"] >= 0 ):
               return True
            if(x == square["x1"]  and y == square["y"] and square["x1"] >= 0 ):
               return True
            if(x == square["x2"]  and y == square["y"] and square["x2"] >= 0):
               return True
            if(x == square["x3"] and y == square["y"] and square["x3"]>= 0):
               return True
            if(x == square["x4"]  and y == square["y"] and square["x4"] >= 0):
                return True



#The drawing method to draw all the contents and frame.
def draw(model, canvas):
    # called after onkey() and onloop(), so every
    # X milliseconds and after each time the user
    # presses a key
    canvas.delete(ALL)
    # clear canvas
    block_height = 20
    block_margin = 4
    dimensions = model["dimensions"]
    i = model["i"]
    if(i == 1):
        square = model["T-Shape"]
    elif(i==2):
        square = model["square"]
    elif(i==3):
        square = model["LShape"]
    elif(i == 4):
        square = model["L"]
    elif(i == 5):
        square = model["LL"]
    elif(i == 6):
        square = model["Half"]
    elif(i == 7):
        square = model["Line"]
    for x in range(dimensions[0]):
        for y in range(dimensions[1]):
            draw_lines(canvas)
            # default color of empty block
            if(isEqual(x,y,square,i)):
                    color = getColor(i)
            else:
                c = getValue(x,y,record,i)
                color = getColor(c)
                # color of filled block
            rect = canvas.create_rectangle(
                -1+ x * block_height + (x + 1) * block_margin,
                -1+y * block_height + (y + 1) * block_margin,
                (x + 1) * block_height + (x + 1) * block_margin,
                (y + 1) * block_height + (y + 1) * block_margin,
                fill=color, outline=color)
            # draws a rectangle
            # draws rectangle grid



#Return the color according to the number which this method gets as parameter.
def getColor(i):
    if(i == 1):
        return "navy"
    elif(i == 2):
        return "magenta"
    elif(i == 3):
        return "green"
    elif(i == 4):
        return "black"
    elif(i == 5):
        return "brown"
    elif(i == 6):
        return "grey"
    elif(i == 7):
        return "olive"
    elif(i == 0):
        return "#f2f2f2"


#Return the value stored in record so that the color of this value can be achieved from
#get color method
def getValue(x,y,record,i):
    a = record[y][x]
    return a



#Pre-condition, it checks whether the L design can rotate to its secodn state.
def canChangeLToStateTwo(square,dim,i):
    if(square["x"]+2 < dim[0] and not(isSaved(square["x"]+1,square["y"],record,i)
                                      and not(isSaved(square["x"]+2,square["y"],record,i)))):
        return True


#If the pre-condition is fullfilled the L rotates it self to the second state.
def changeLToStateTwo(square,dim):
      square["yyy"] = -1
      square["xx"] = square["x"]+1
      square["x3"] = square["xx"]+1
      square["state"] = 2


#Pre-condition, it checks whether the L design can rotate to its Thirdstate.
def canChangeLToStateThree(square,dim,i):
       if(square["y"]+2 < dim[1] and not(isSaved(square["x3"],square["y"]+1,record,i))
             and not(isSaved(square["x3"],square["y"]+2,record,i))):
           return True


#If the pre-condition is fullfilled the L rotates it self to the Thirdstate.
def changeLToStateThree(square):
    square["x"] = -1
    square["yyy"] = square["yy"]+1
    square["state"] = 3


#checks whether the square can move to the left side.
def canMoveLeftSquare(x,xx,width,square,i):
   if (x+2 <= width and xx+2 <= width and not(isSaved(square["z"]+1,square["b"],record,i))
       and not(isSaved(square["x"]+1,square["b"],record,i))
            and not(isSaved(square["z"]+1,square["y"],record,i))and not(isSaved(square["x"]+1,square["y"],record,i))):
         return True
   else:
       return False



#Pre-condition, it checks whether the L design can rotate to its State four.
def canChangeLToStateFour(square,dim,i):
    if(square["xx"] -1 >= 0 and not(isSaved(square["x3"]-2,square["yyy"],record,i))
               and not(isSaved(square["x3"]-1,square["yyy"],record,i))):
        return True



#if the pre-condition is fullfilled the L can move to state four.
def changeLToStateFour(square):
    square["y"] = -1
    square["xx"] = square["x3"]-1
    square["x"]= square["xx"]-1
    square["state"] = 4


#Pre-condition, it checks whether the L design can rotate to its State one.
def canChangeLToStateOne(square,dim,i):
     if(not (isSaved(square["x"],square["yyy"]-1,record,i)) and not(isSaved(square["x"],square["yyy"]-2,record,i))):
       return True


#if the pre-condition is fullfilled the L can move to state one.
def changeLToStateOne(square):
    square["x3"] = 7
    square["yy"] = square["yyy"]-1
    square["y"] = square["yy"]-1
    square["state"] = 1



#Pre- checks if the L design can move to the right side and
#there are no blocks already saved there if they then the pre condition return false.
def canMoveLToRight(square,dim,i):
    if(square["state"] == 1):
        if(square["xx"]+1 < dim[0] and not(isSaved(square["xx"]+1,square["yyy"],record,i)) and not(isSaved(square["x"]+1,square["yyy"],record,i))
           and not(isSaved(square["x"]+1,square["yy"],record,i)) and not(isSaved(square["x"]+1,square["y"],record,i))):
            return True
    elif(square["state"] == 2):
          if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y"],record,i)) and not(isSaved(square["xx"]+1,square["y"],record,i))
           and not(isSaved(square["x"]+1,square["y"],record,i)) and not(isSaved(square["x"]+1,square["yy"],record,i))):
            return True
    elif(square["state"] == 3):
          if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["yyy"],record,i)) and not(isSaved(square["x3"]+1,square["yy"],record,i))
           and not(isSaved(square["x3"]+1,square["y"],record,i)) and not(isSaved(square["xx"]+1,square["y"],record,i))):
            return True
    elif(square["state"] == 4):
          if(square["xx"]+1 < dim[0] and not(isSaved(square["x"]+1,square["y"],record,i)) and not(isSaved(square["x"]+1,square["yy"],record,i))
           and not(isSaved(square["x"]+1,square["yyy"],record,i)) and not(isSaved(square["xx"]+1,square["yyy"],record,i))):
            return True


#if the pre-condition is fullfilled the L design can move to the right side.
def moveLToRight(square):
   if(square["state"] == 1):
     square["xx"] += 1
     square["x"] += 1
   elif(square["state"] == 2):
     square["x3"] += 1
     square["xx"] += 1
     square["x"] += 1
   elif(square["state"] == 3):
     square["x3"] += 1
     square["xx"] += 1
   elif(square["state"] == 4):
     square["x3"] += 1
     square["xx"] += 1
     square["x"] += 1


#The main method which is being called everytime we have an active L design and we press a key
#then this method determines which key has been pressed and can this operation be done or not.
def moveL(square,keycode,dim,i):
    if(keycode == 38):
        if(square["state"] == 1):
           if(canChangeLToStateTwo(square,dim,i)):
            changeLToStateTwo(square,dim)
        elif(square["state"] == 2):
            if(canChangeLToStateThree(square,dim,i)):
                changeLToStateThree(square)
        elif(square["state"] == 3):
            if(canChangeLToStateFour(square,dim,i)):
                changeLToStateFour(square)
        elif(square["state"] == 4):
            if(canChangeLToStateOne(square,dim,i)):
                changeLToStateOne(square)
    elif(keycode == 39):
            if(canMoveLToRight(square,dim,i)):
                moveLToRight(square)
    elif(keycode == 37):
           if(canMoveLRToLeft(square,dim,i)):
               moveLToLeft(square)
    elif(keycode == 40):
        if(canMoveDownL(square,dim,i)):
            moveDownL(square)


#pre-checks whether the L design can be moved to left side or not.
def canMoveLRToLeft(square,dim,i):
    if(square["state"] == 1):
         if(square["x"]-1 >= 0 and not(isSaved(square["xx"]-1,square["yyy"],record,i)) and not(isSaved(square["x"]-1,square["yyy"],record,i))
           and not(isSaved(square["x"]-1,square["yy"],record,i)) and not(isSaved(square["x"]-1,square["y"],record,i))):
            return True
    elif(square["state"] == 2):
         if(square["x"]-1 >= 0 and not(isSaved(square["x"]-1,square["y"],record,i)) and not(isSaved(square["xx"]-1,square["y"],record,i))
           and not(isSaved(square["x"]-1,square["yy"],record,i)) and not(isSaved(square["x3"]-1,square["y"],record,i))):
            return True
    elif(square["state"] == 3):
         if(square["xx"]-1 >= 0 and not(isSaved(square["xx"]-1,square["y"],record,i)) and not(isSaved(square["x3"]-1,square["y"],record,i))
           and not(isSaved(square["x3"]-1,square["yy"],record,i)) and not(isSaved(square["x3"]-1,square["yyy"],record,i))):
            return True
    elif(square["state"] == 4):
          if(square["x"]-1 >= 0 and not(isSaved(square["x"]-1,square["yyy"],record,i)) and not(isSaved(square["xx"]-1,square["yyy"],record,i))
           and not(isSaved(square["x3"]-1,square["yyy"],record,i)) and not(isSaved(square["x3"]-1,square["yy"],record,i))):
            return True

#if the pre- is fullfilled then L design is moved to the left.
def moveLToLeft(square):
    if(square["state"] == 1):
      square["x"] -= 1
      square["xx"] -= 1
    elif(square["state"] == 2):
      square["x"] -= 1
      square["xx"] -= 1
      square["x3"] -= 1
    elif(square["state"] == 3):
      square["xx"] -= 1
      square["x3"] -= 1
    elif(square["state"] == 4):
      square["x"] -= 1
      square["xx"] -= 1
      square["x3"] -= 1


#OnKey Method, every time we press a key this method is being called without determining ,
#which key was pressed.
def onkey(model, keycode):
    # called when user presses a key
    # [ put your own code here ]
    dim = model["dimensions"]
    i = model["i"]
    if(i == 2 ):
       square = model["square"]
       rotateSquare(square,keycode,dim,i)
    if(i == 7):
        square = model["Line"]
        rotateLine(square,keycode,dim,i)
    if(i == 4):
        square = model["L"]
        moveL(square,keycode,dim,i)
    if(i == 1):
        square = model["T-Shape"]
        rotateTShape(square,keycode,dim,i)
    if(i == 3):
        square = model["LShape"]
        rotateLShape(square,keycode,dim,i)
    if(i == 5):
        square = model["LL"]
        rotateLL(square,keycode, dim,i)
    if(i == 6):
        square = model["Half"]
        rotateHalf(square,keycode,dim,i)


#checks if the half design can be set to state one ==> rotate.
def changeHalfToStateOne(square,dim,i):
 if(square["x2"]+1 < dim[0] and square["x1"]-1 > 0):
    square["x3"] = square["x2"]+1
    square["y3"]= -1
    square["state"] = 1

#The design is set to the state two.
def changeToStateTwoHalf(square,dim,i):
   if(canRotateHalf(square,dim,i)):
       square["y3"] = square["y2"]+1
       square["state"] = 2

#checks if the half design can rotate.
def canRotateHalf(square,dim,i):
    if(square["y1"]-1 >= 0 and square["x1"]-1 > 0 and not(isSaved(square["x2"],square["y2"]+1,record,i))):
        return True

#Roatets the half design but there are also some pre condition which should be fullfilled.
def rotateHalf(square,keycode,dim,i):
     if(keycode == 38 or keycode == 8320768):
         if(square["state"] == 1):
             changeToStateTwoHalf(square,dim,i)

         elif(square["state"] == 2):
             changeHalfToStateOne(square,dim,i)
     elif(keycode == 39 or keycode == 8189699):
         if(canMoveHalfToRight(square,dim,i)):
             moveHalfToRight(square)
     elif(keycode == 37 or keycode == 8124162):
         if(canMoveHalfToLeft(square,dim,i)):
             moveHalfToLeft(square)
     elif(keycode == 40):
         if(canMoveDownHalf(square,dim,i)):
             moveDownHalf(square)

#if can move to the left side then this method moves the design to the left.
def moveHalfToLeft(square):
    if(square["state"] == 1):
        square["x1"] -= 1
        square["x2"] -= 1
        square["x3"] -= 1
    elif(square["state"] == 2):
        square["x1"] -= 1
        square["x2"] -= 1


#pre-conditon checks if they half design can be moved left.
def canMoveHalfToLeft(square,dim,i):
     if(square["state"] == 1):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y2"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i))and not(isSaved(square["x2"]-1,square["y2"],record,i))
           and not(isSaved(square["x3"]-1,square["y1"],record,i))):
            return True
     elif(square["state"] == 2):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x1"]-1,square["y2"],record,i))and not(isSaved(square["x2"]-1,square["y2"],record,i))
           and not(isSaved(square["x2"]-1,square["y3"],record,i))):
            return True

#if can move to the left side then this method moves the design to the right.
def moveHalfToRight(square):
    if(square["state"] == 1):
        square["x3"] += 1
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 2):
        square["x2"] += 1
        square["x1"] += 1
#pre-conditon checks if they half design can be moved Right.
def canMoveHalfToRight(square,dim,i):
     if(square["state"] == 1):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y1"],record,i))and not(isSaved(square["x2"]+1,square["y2"],record,i))
           and not(isSaved(square["x1"]+1,square["y2"],record,i))):
            return True
     elif(square["state"] == 2):
        if(square["x2"]+1 < dim[0] and not(isSaved(square["x2"]+1,square["y2"],record,i))
           and not(isSaved(square["x2"]+1,square["y3"],record,i))and not(isSaved(square["x1"]+1,square["y1"],record,i))
           and not(isSaved(square["x1"]+1,square["y2"],record,i))):
            return True

#This method will be called whenever we have a LL design and we press a key
#this method determines which key was pressed and what opeartion should be done.
def rotateLL(square,keycode, dim,i):
    if(keycode == 38 or keycode == 8320768):
        if(square["state"] == 1):
            changeLLStateToTwo(square,i,dim)
        elif(square["state"] == 2):
            changeLLStateToOne(square,i,dim)
    elif(keycode == 39 or keycode == 8124162):
        if(canMoveLLtoRight(square,i,dim)):
            moveLLtoRight(square)
    elif(keycode == 37 or keycode == 8189699):
        if(canMoveLLtoLeft(square,i,dim)):
            moveLLtoLeft(square)
    elif(keycode == 40):
        if(canMoveDownLL(square,dim,i)):
            moveDownLL(square)


#Moves the LL design to the left side
def  moveLLtoLeft(square):
    if(square["state"] == 1):
        square["x3"] -= 1
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 2):
        square["x2"] -= 1
        square["x1"] -= 1


#checks if the LL design can be moved to the left.
def canMoveLLtoLeft(square,i,dim):
     if(square["state"] == 1):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i))and not(isSaved(square["x2"]-1,square["y2"],record,i))
           and not(isSaved(square["x3"]-1,square["y2"],record,i))):
            return True
     elif(square["state"] == 2):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y2"],record,i))
           and not(isSaved(square["x1"]-1,square["y3"],record,i))and not(isSaved(square["x2"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y2"],record,i))):
            return True

#Moves the LL design to the right if the pre condition is fullfilled.
def  moveLLtoRight(square):
    if(square["state"] == 1):
        square["x3"] += 1
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 2):
        square["x2"] += 1
        square["x1"] += 1

#pre-condtion check if the LL design can be moved to the right side.
def canMoveLLtoRight(square,i,dim):
     if(square["state"] == 1):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y2"],record,i) and square["y2"]+2 < dim[1])
           and not(isSaved(square["x2"]+1,square["y1"],record,i))and not(isSaved(square["x2"]+1,square["y2"],record,i))
           and not(isSaved(square["x1"]+1,square["y1"],record,i))):
            return True
     elif(square["state"] == 2):
        if(square["x2"]+1 < dim[0] and not(isSaved(square["x2"]+1,square["y1"],record,i) and square["y"]+1 <dim[1] )
           and not(isSaved(square["x2"]+1,square["y2"],record,i))and not(isSaved(square["x1"]+1,square["y2"],record,i))
           and not(isSaved(square["x1"]+1,square["y3"],record,i))):
            return True


#Change the LL shape design to state one.
def changeLLStateToOne(square,i,dim):
    if(square["x2"]+1 < dim[0] and square["y2"]+1 < dim[1] and not(isSaved(square["x2"]+1,square["y2"],record,i))
       and square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))):
        square["x3"] = square["x2"]+1
        square["state"] = 1

#Changes the LL Shape Design to the second state by giving it proper values.
def changeLLStateToTwo(square,i,dim):
    if(square["x2"]+1 < dim[0] and square["y2"]+1 < dim[1] and not isSaved(square["x1"]+2,square["y2"],record,i)
       and not isSaved(square["x2"]+1,square["y2"],record,i)and not isSaved(square["x1"]+1,square["y1"],record,i)):
     square["x3"] = -1
     square["y3"] = square["y2"]+1
     square["state"] = 2

#The main method when L shape is active ,this method is being called and checked which key
#is being used
def rotateLShape(square,keycode,dim,i):
    if(keycode == 38 or keycode == 8320768):
        if(square["state"] == 1):
         changeLShapeToStateTwo(square,i,dim)
        elif(square["state"] == 2):
         changeLShapeToStateThree(square,i,dim)
        elif(square["state"] == 3):
         changeLShapeToStateFour(square,i,dim)
        elif(square["state"] == 4):
         changeLShapeToStateOne(square,i,dim)
    elif(keycode == 39 or keycode == 8124162):
        if(canMoveLShapeToRight(square,i,dim)):
            moveLShapeRight(square,dim,i)
    elif(keycode == 37 or keycode == 8189699):
        if(canMoveLShapeToLeft(square,i,dim)):
            moveLShapeToLeft(square,i,dim)
    elif(keycode == 40):
        if(canMoveLShapeDown(square,dim,i)):
            moveDownLShape(square)

#This method Moves the L Shape design to the left side whenever we press the left key.
def moveLShapeToLeft(square,i,dim):
    if(square["state"] == 1):
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 2):
        square["x3"] -= 1
        square["x2"] -=1
        square["x1"] -= 1
    elif(square["state"] == 3):
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 4):
        square["x3"] -= 1
        square["x2"] -=1
        square["x1"] -= 1


def canMoveLShapeToLeft(square,i,dim):
    if(square["state"] == 1):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y3"],record,i))
           and not(isSaved(square["x2"]-1,square["y2"],record,i))and not(isSaved(square["x2"]-1,square["y3"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i))):
            return True
    elif(square["state"] == 2):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x1"]-1,square["y2"],record,i))and not(isSaved(square["x2"]-1,square["y2"],record,i))
           and not(isSaved(square["x3"]-1,square["y2"],record,i))):
            return True
    elif(square["state"] == 3):
        if(square["x1"]-1  >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x1"]-1,square["y2"],record,i))and not(isSaved(square["x1"]-1,square["y3"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i))):
            return True
    elif(square["state"] == 4):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i))and not(isSaved(square["x3"]-1,square["y1"],record,i))
           and not(isSaved(square["x3"]-1,square["y2"],record,i))):
            return True

def moveLShapeRight(square,dim,i):
    if(square["state"] == 1):
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 2):
        square["x3"] += 1
        square["x2"] +=1
        square["x1"] += 1
    elif(square["state"] == 3):
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 4):
        square["x3"] += 1
        square["x2"] +=1
        square["x1"] += 1

def canMoveLShapeToRight(square,i,dim):
    if(square["state"] == 1):
        if(square["x2"]+1 < dim[0] and not(isSaved(square["x2"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y2"],record,i))and not(isSaved(square["x2"]+1,square["y3"],record,i))
           and not(isSaved(square["x1"]+1,square["y3"],record,i))):
            return True
    elif(square["state"] == 2):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y2"],record,i))
           and not(isSaved(square["x2"]+1,square["y2"],record,i))and not(isSaved(square["x1"]+1,square["y2"],record,i))
           and not(isSaved(square["x1"]+1,square["y1"],record,i))):
            return True
    elif(square["state"] == 3):
        if(square["x2"]+1 < dim[0] and not(isSaved(square["x2"]+1,square["y1"],record,i))
           and not(isSaved(square["x1"]+1,square["y1"],record,i))and not(isSaved(square["x1"]+1,square["y2"],record,i))
           and not(isSaved(square["x1"]+1,square["y3"],record,i))):
            return True
    elif(square["state"] == 4):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y1"],record,i))and not(isSaved(square["x1"]+1,square["y1"],record,i))
           and not(isSaved(square["x3"]+1,square["y2"],record,i))):
            return True

def  changeLShapeToStateOne(square,i,dim):
    if(square["y2"]+1 < dim[1] and not(isSaved(square["x2"],square["y1"]+2,record,i))
                         and not(isSaved(square["x1"],square["y1"]+2,record,i))):
       square["x2"] = square["x1"]+1
       square["y2"] = square["y1"]+1
       square["y3"] = square["y2"]+1
       square["state"] = 1

def changeLShapeToStateFour(square,i,dim):
     if(square["x2"]+1 < dim[0] and square["x1"]-1 >= 0 and not(isSaved(square["x2"]+1 ,square["y2"],record,i))):
         square["x3"] = square["x2"]+1
         square["state"] = 4

def changeLShapeToStateThree(square,i,dim):
        square["y3"] = square["y2"]+1
        square["x3"] = -1
        square["state"] = 3

def  changeLShapeToStateTwo(square,i,dim):
      if(square["x2"] +1 < dim[0] and square["x1"]-1 >= 0):
          square["x3"] = square["x2"]+1
          square["state"] = 2
          square["y3"] = -1

def rotateTShape(square,keycode,dim,i):
    if(keycode == 38 or keycode == 8320768):
        if(square["state"] == 1):
            changeTtoStateTwo(square,i,dim)
        elif(square["state"] == 2):
            changeTStateThree(square,i,dim)
        elif(square["state"] == 3):
            changeTStateFour(square,i,dim)
        elif(square["state"] == 4):
            changeTstateToOne(square,i,dim)
    elif(keycode == 39 or keycode == 8124162):
        if(canMoveTtoRight(square,i,dim)):
           moveTtoRight(square,i,dim)
    elif(keycode == 37 or keycode == 8189699):
        if(canMoveTtoLeft(square,i,dim)):
            moveTtoLeft(square,i,dim)
    elif(keycode == 40):
        if(canMoveDownT(square,dim,i)):
            moveDownT(square)

def moveTtoLeft(square,i,dim):
    if(square["state"] == 1):
        square["x3"] -= 1
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 2):
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 3):
        square["x3"] -= 1
        square["x2"] -= 1
        square["x1"] -= 1
    elif(square["state"] == 4):
        square["x3"] -= 1
        square["x2"] -= 1

def canMoveTtoLeft(square,i,dim):
    if(square["state"] == 1):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y1"],record,i)) and not (isSaved(square["x3"]-1,square["y1"],record,i))
           and not (isSaved(square["x2"]-1,square["y2"],record,i))):
            return True
    elif(square["state"] == 2):
         if(square["x1"]-1 >= 0 and not(isSaved(square["x1"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y3"],record,i)) and not (isSaved(square["x2"]-1,square["y1"],record,i))
           and not (isSaved(square["x2"]-1,square["y1"],record,i))):
            return True
    elif(square["state"] == 3):
        if(square["x1"]-1 >= 0 and not(isSaved(square["x3"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y3"],record,i)) and not (isSaved(square["x2"]-1,square["y1"],record,i))
           and not (isSaved(square["x1"]-1,square["y1"],record,i))):
            return True
    elif(square["state"] == 4):
        if(square["x2"]-1 >= 0 and not(isSaved(square["x3"]-1,square["y1"],record,i))
           and not(isSaved(square["x2"]-1,square["y3"],record,i)) and not (isSaved(square["x2"]-1,square["y1"],record,i))
           and not (isSaved(square["x2"]-1,square["y2"],record,i))):
            return True

def moveTtoRight(square,i,dim):
    if(square["state"] == 1):
        square["x3"] += 1
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 2):
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 3):
        square["x3"] += 1
        square["x2"] += 1
        square["x1"] += 1
    elif(square["state"] == 4):
        square["x3"] += 1
        square["x2"] += 1

def canMoveTtoRight(square,i,dim):
    if(square["state"] == 1):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x1"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y1"],record,i)) and not (isSaved(square["x3"]+1,square["y1"],record,i))
           and not (isSaved(square["x2"]+1,square["y2"],record,i))):
            return True
    elif(square["state"] == 2):
         if(square["x2"]+1 < dim[0] and not(isSaved(square["x1"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y3"],record,i)) and not (isSaved(square["x2"]+1,square["y1"],record,i))
           and not (isSaved(square["x2"]+1,square["y1"],record,i))):
            return True
    elif(square["state"] == 3):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y3"],record,i)) and not (isSaved(square["x2"]+1,square["y1"],record,i))
           and not (isSaved(square["x1"]+1,square["y1"],record,i))):
            return True
    elif(square["state"] == 4):
        if(square["x3"]+1 < dim[0] and not(isSaved(square["x3"]+1,square["y1"],record,i))
           and not(isSaved(square["x2"]+1,square["y3"],record,i)) and not (isSaved(square["x2"]+1,square["y1"],record,i))
           and not (isSaved(square["x2"]+1,square["y2"],record,i))):
            return True

def changeTstateToOne(square,i,dim):
    if(square["x2"]-1 > 0):
      square["x1"] = square["x2"]-1
      square["y3"] = -1
      square["state"] = 1

def changeTStateFour(square,i,dim):
  if(square["y2"]+1 < dim[0] and square["y1"]+1 < dim[1] and not isSaved(square["x2"],square["y2"]+1,record,i) ):
    square["x1"] = -1
    square["y2"] = square["y1"]+1
    square["state"] = 4

def changeTStateThree(square,i,dim):
     if(square["y1"]-1 >= 0 and square["x2"]+1 < dim[0]):
       square["x3"] = square["x2"]+1
       square["y2"] = -1
       square["state"] = 3

def canChangetStateTwo(square,i,dim):
    if(square["x1"]-1 >= 0 and square["y1"]+1 < dim[1]and not(isSaved(square["x1"]-1,square["y1"],record,i)) and not(isSaved(square["x1"],square["y1"]+1,record,i))and not(isSaved(square["x1"]-1,square["y1"]-1,record,i)) ):
        return True

def changeTtoStateTwo(square,i,dim):
    if(canChangetStateTwo(square,i,dim)):
      square["x3"] = -1
      square["y3"] = square["y1"]-1
      square["state"] = 2

def canMoveLineLeft(square,dim,i):
    if(square["state"] == 1):
      x = square["x"]
      if (x-1 >= 0 and x-1 >= 0 and not(isSaved(square["x"]-1,square["y"],record,i)) and not(isSaved(square["x"]-1,square["yy"],record,i))
            and not(isSaved(square["x"]-1,square["yyy"],record,i))and not(isSaved(square["x"]-1,square["yo"],record,i))):
         return True
    elif(square["state"] == 2):
         x = square["x1"]
         xx = square["x2"]
         x3 = square["x3"]
         x4 = square["x4"]
         if (x-1 >= 0 and xx-1 >= 0 and x3-1 >= 0 and x4-1 >= 0 and not(isSaved(x-1,square["yo"],record,i))
             and not(isSaved(xx-1,square["yo"],record,i))
            and not(isSaved(x3-1,square["yo"],record,i))and not(isSaved(x4-1,square["yo"],record,i))):
          return True

def moveLineLeft(square,i):
    if(square["state"] == 1):
        square["x"] -= 1
    elif(square["state"] == 2):
        square["x1"] -= 1
        square["x2"] -= 1
        square["x3"] -= 1
        square["x4"] -= 1

def canMoveLineRight(square,dim,i):
    if(square["state"] == 1):
        x = square["x"]
        if (x+1 < dim[0] and not(isSaved(square["x"]+1,square["y"],record,i))
            and not(isSaved(square["x"]+1,square["yy"],record,i))
            and not(isSaved(square["x"]+1,square["yyy"],record,i))and not(isSaved(square["x"]+1,square["yo"],record,i))):
         return True
    elif(square["state"] == 2):
         x = square["x4"]
         x3 = square["x3"]
         x2 = square["x2"]
         if (x+1 < dim[0] and x3 < dim[0] and x2+1 < dim[0] and  not(isSaved(square["x"]+1,square["y"],record,i))
            and not(isSaved(square["x"]+1,square["y"],record,i))
            and not(isSaved(square["x3"]+1,square["y"],record,i))and not(isSaved(square["x4"]+1,square["y"],record,i))):
          return True

def moveLineRight(square):
      if(square["state"] == 1):
          square["x"] += 1
      elif(square["state"] == 2):
          square["x1"] += 1
          square["x2"] += 1
          square["x3"] += 1
          square["x4"] += 1

def rotateLine(square,keycode,dim,i):
     if(keycode == 38 or keycode == 8320768):
        if(square["state"] == 1):
            changeToStateTwoLine(square,i)
        elif(square["state"] == 2):
            changeToStateOneLine(square,record,i)
     elif(keycode ==37 or keycode == 8189699):
        if(canMoveLineLeft(square,dim,i)):
             moveLineLeft(square,i)
     elif(keycode == 39 or keycode == 8124162):
         if(canMoveLineRight(square,dim,i)):
             moveLineRight(square)
     elif(keycode == 40):
         if(canMoveLine(square,dim,i)):
             moveDownLine(square)

def rotateSquare(square,keycode,dim,i):
       if(keycode == 39 or keycode == 8124162):
        if(canMoveLeftSquare(square["x"],square["z"],dim[0],square,i)):
         square["x"] += 1
         square["z"] += 1
       elif(keycode == 37 or keycode  == 8189699):
           if(canMoveRightSquare(square["x"],square["z"],dim[0],square,i)):
               square["x"] -= 1
               square["z"] -= 1
       elif(keycode == 40):
         if(canMoveSquare(square,dim,i)):
           moveDownSquare(square)

def changeToStateOneLine(square,record,i):
            temp = square["x"]
            if(canChangeToStateOneLine(square,record,temp,i)):
              square["x"] = square["x1"]
              square["x1"] = -1
              square["x2"] = -1
              square["x3"] = -1
              square["x4"] = -1
              square["state"] = 1
              square["y"] = square["y"]
              square["yy"] = square["y"]-1
              square["yyy"] = square["yy"]-1
              square["yo"] = square["yyy"]-1
              square["state"] = 1

def canChangeToStateOneLine(square,record,temp,i):
    if(( not isSaved(temp,square["y"],record,i)
         and not(isSaved(temp,square["yy"],record,i))and not(isSaved(temp,square["yyy"],record,i))
                and not(isSaved(temp,square["yo"],record,i)) and not(isSaved(temp,square["y"]-1,record,i))
                and not(isSaved(temp,square["y"]-2,record,i)) and not(isSaved(temp,square["y"]-3,record,i))
                    and (square["y"]-3 >= -1)and (square["y"]-3 >= -1))):
           return True

def canChangeToStateTwoLine(square,record,i):
    if(( not isSaved(square["x"],square["yo"],record,i)
         and not(isSaved(square["x"]+1,square["yo"],record,i))and not(isSaved(square["x"]+2,square["yo"],record,i))
                and not(isSaved(square["x"]+3,square["yo"],record,i))
                    and (square["x"]+3 <= 10)and (square["x"]+3 <= 10))):
           return True

def changeToStateTwoLine(square,i):
    if canChangeToStateTwoLine(square,record,i):
              square["x1"] = square["x"]
              square["x2"] = square["x"]+1
              square["x3"] = square["x2"]+1
              square["x4"] = square["x3"]+1
              square["x"] = -1
              square["state"] = 2

def canMoveRightSquare(x,xx,widht,square,i):
     if (x-1 >= 0 and xx-1 >= 0 and not(isSaved(square["z"]-1,square["b"],record,i)) and not(isSaved(square["x"]-1,square["b"],record,i))
            and not(isSaved(square["z"]-1,square["y"],record,i))and not(isSaved(square["x"]-1,square["y"],record,i))):
         return True

def notOutOfFrame(y, yy, height):
    if (y < height - 1 and yy < height - 1):
        return True

def saveState(x, y,record,i):
   if(y == 0):
    sys.exit()
   else:
    record[y][x] = i
    return

def  setInitialTVal(square):
    square["y3"] = -1
    square["state"] = 1

def  setInitialValT(square,i):
     if(i == 1):
         square["x1"] = 5
         square["y1"] = 0
         square["x2"] = 6
         square["x3"] = 7
         square["y2"] = 1
         square["y3"] = -1
         square["state"] = 1
         setInitialTVal(square)
     if(i == 2):
         square["x"] = 6
         square["y"] = 0
         square["z"] = 5
         square["b"] = 1
     if(i == 3):
        square["x1"] = 5
        square["y1"] = 0
        square["x2"] = 6
        square["y2"] = 1
        square["x3"] = -1
        square["y3"] = 2
        square["state"] = 1
     if(i == 4):
         square["x"] = 5
         square["y"] = 0
         square["xx"] = 6
         square["x3"] = 7
         square["yy"] = 1
         square["yyy"] = 2
         square["state"] = 1
     if(i == 5):
         square["x"] = 6
         square["y"] = 0
         square["xx"] = 5
         square["yy"] = 1
         square["yyy"] = 2
     if(i == 6):
         square["x"] = 5
         square["y"] = 0
         square["xx"] = 6
         square["yy"] = 1
         square["xxx"] = 7
     if(i == 7):
         square["x"] = 6
         square["y"] = 0
         square["yy"] = 1
         square["yyy"] = 2
         square["yo"] = 3
         setInitialDesign(square)

     return

def setInitialDesign(square):
         square["x1"] = -1
         square["x2"] = -1
         square["x3"] = -1
         square["x4"] = -1
         square["state"] = 1

def canMoveSquare(square,dim,i):
       if(notOutOfFrame(square["x"],square["y"],dim[1]) and notOutOfFrame(square["x"],square["b"],dim[1])
                   and notOutOfFrame(square["z"],square["y"],dim[1]) and notOutOfFrame(square["z"],square["b"],dim[1])
                     and (not isSaved(square["x"],square["b"]+1,record,i) and(not isSaved(square["z"],square["b"]+1,record,i)
                                    and (not isSaved(square["x"],square["y"],record,i)
                                                 and (not isSaved(square["z"],square["y"],record,i)) and (square["b"]+1 < dim[1]))))):
           return True
       else:
           return False

def moveDownSquare(square):
      square["b"] += 1
      square["y"] += 1

def saveSquare(i,square):
     saveState(square["x"],square["y"],record,i)
     saveState(square["z"],square["y"],record,i)
     saveState(square["x"],square["b"],record,i)
     saveState(square["z"],square["b"],record,i)


def saveStateOfL(square,i):
    if(square["state"] == 1):
        saveState(square["x"],square["y"],record,i)
        saveState(square["x"],square["yy"],record,i)
        saveState(square["x"],square["yyy"],record,i)
        saveState(square["xx"],square["yyy"],record,i)
    elif(square["state"] == 2):
        saveState(square["x"],square["y"],record,i)
        saveState(square["x"],square["yy"],record,i)
        saveState(square["xx"],square["y"],record,i)
        saveState(square["x3"],square["y"],record,i)
    elif(square["state"] == 3):
        saveState(square["xx"],square["y"],record,i)
        saveState(square["x3"],square["y"],record,i)
        saveState(square["x3"],square["yy"],record,i)
        saveState(square["x3"],square["yyy"],record,i)
    elif(square["state"] == 4):
        saveState(square["x"],square["yyy"],record,i)
        saveState(square["xx"],square["yyy"],record,i)
        saveState(square["x3"],square["yyy"],record,i)
        saveState(square["x3"],square["yy"],record,i)

def saveStatesOfT(square,i):
        if(square["state"] == 4):
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y3"],record,i)
         saveState(square["x3"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)
        elif(square["state"] == 3):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x3"],square["y1"],record,i)
         saveState(square["x2"],square["y3"],record,i)
        elif(square["state"] == 2):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x2"],square["y3"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)
        elif(square["state"] == 1):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x3"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)

def saveLShape(square,i):
        if(square["state"] == 4):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x3"],square["y1"],record,i)
         saveState(square["x3"],square["y2"],record,i)
        elif(square["state"] == 3):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x1"],square["y2"],record,i)
         saveState(square["x1"],square["y3"],record,i)
         saveState(square["x2"],square["y1"],record,i)
        elif(square["state"] == 2):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x1"],square["y2"],record,i)
         saveState(square["x2"],square["y2"],record,i)
         saveState(square["x3"],square["y2"],record,i)
        elif(square["state"] == 1):
         saveState(square["x1"],square["y3"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)
         saveState(square["x2"],square["y3"],record,i)


def saveStateOfBoard(i,square):
    if(i == 1):
     saveStatesOfT(square,i)
    elif(i == 2):
        saveSquare(i,square)
    elif(i == 3):
        saveLShape(square,i)
    elif( i == 4):
        saveStateOfL(square,i)
    elif(i == 5):
         saveStateOfLL(square,i)
    elif(i == 6):
        saveStateOfHalf(square,i)
    elif(i == 7):
        saveStateOfLineShape(square,i)


def saveStateOfHalf(square,i):
    if(square["state"] == 1):
         saveState(square["x1"],square["y2"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)
         saveState(square["x3"],square["y1"],record,i)
    elif(square["state"] == 2):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x1"],square["y2"],record,i)
         saveState(square["x2"],square["y2"],record,i)
         saveState(square["x2"],square["y3"],record,i)


#saves the state of LL design if the movement is not possible anymore.
def saveStateOfLL(square,i):
    if(square["state"] == 1):
         saveState(square["x1"],square["y1"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)
         saveState(square["x3"],square["y2"],record,i)
    elif(square["state"] == 2):
         saveState(square["x1"],square["y2"],record,i)
         saveState(square["x1"],square["y3"],record,i)
         saveState(square["x2"],square["y1"],record,i)
         saveState(square["x2"],square["y2"],record,i)

#if the design can not move down then this method will be called and the co-ordintates
#will be saved
def saveStateOfLineShape(square,i):
        if(square["state"] == 1):
         saveState(square["x"],square["y"],record,i)
         saveState(square["x"],square["yy"],record,i)
         saveState(square["x"],square["yyy"],record,i)
         saveState(square["x"],square["yo"],record,i)
        elif(square["state"] == 2):
         saveState(square["x1"],square["y"],record,i)
         saveState(square["x2"],square["y"],record,i)
         saveState(square["x3"],square["y"],record,i)
         saveState(square["x4"],square["y"],record,i)

#if the pre-condition is fullfilled then L shape design would be moved to down.
def moveDownL(square):
    if(square["state"] == 1):
        square["yyy"] += 1
        square["yy"] += 1
        square["y"] += 1
    if(square["state"] == 2):
        square["yy"] += 1
        square["y"] += 1
    if(square["state"] == 3):
        square["yyy"] += 1
        square["yy"] += 1
        square["y"] += 1
    if(square["state"] == 4):
        square["yyy"] += 1
        square["yy"] += 1

#Pre checks if the l Shape design can move to the down side.
def canMoveDownL(square,dim,i):
    if(square["state"] == 1):
        if(square["yyy"]+ 1 < dim[1] and not(isSaved(square["x"],square["yyy"]+1,record,i)) and not(isSaved(square["x"],square["yy"]+1,record,i))
           and not(isSaved(square["x"],square["y"]+1,record,i)) and not(isSaved(square["xx"],square["yyy"]+1,record,i))):
            return True
        else:
            return False
    elif(square["state"] == 2):
        if(square["yy"]+1 < dim[1] and not(isSaved(square["x"],square["yy"]+1,record,i)) and not(isSaved(square["x"],square["y"]+1,record,i))
           and not(isSaved(square["xx"],square["y"]+1,record,i)) and not(isSaved(square["x3"],square["y"]+1,record,i))):
            return True
    elif(square["state"] == 3):
        if(square["yyy"]+1 < dim[1] and not (isSaved(square["x3"],square["yyy"]+1,record,i))
           and not(isSaved(square["x3"],square["yy"]+1,record,i))
           and not(isSaved(square["xx"],square["y"]+1,record,i)) and not(isSaved(square["x3"],square["y"]+1,record,i))):
            return True
    elif(square["state"] == 4):
        if(square["yyy"]+1 < dim[1] and not (isSaved(square["x3"],square["yyy"]+1,record,i))
           and not(isSaved(square["x3"],square["yy"]+1,record,i))
           and not(isSaved(square["xx"],square["yyy"]+1,record,i)) and not(isSaved(square["x"],square["yyy"]+1,record,i))):
            return True
        else:
            return False


#calls the dell method.
def isMatched():
     dell()


#checks if the line is completed.
def dell():
    for i in range(len(record)-1,2,-1):
        for j in range(0,len(record[0])):
            if(j < len(record[0]) and record[i][j] == 0):
                break
            elif(j == len(record[0])-1):
                doit(i)
                Regain(i)

#After deleting the line this regain method Moves upper line one move to down.
def Regain(i):
    for k in range(len(record)-1,2,-1):
      for j in range(0,len(record[0])):
          record[i][j] = record[i-1][j]
      if(i > 1):
       i -= 1

#If the line is complete in horizantal then the line would be deleted.
def doit(i):
    for j in range(0,len(record[0])):
        record[i][j]= 0


#Loop Method if the game is not finished then the loop keeps going.
def onloop(model,record):
    # called every X milliseconds
    # [ put your own code here ]
    dim = model["dimensions"]
    i = model["i"]
    isMatched()
    if(i == 2):
      square = model["square"]
      if(canMoveSquare(square,dim,i)):
            moveDownSquare(square)
      else:
          saveStateOfBoard(i,square)
          setInitialValT(square,i)
          model["i"] = random.randint(1,7)
          return
    elif(i == 7):
        square = model["Line"]
        if(canMoveLine(square,dim,i)):
            moveDownLine(square)
        else:
            saveStateOfBoard(i,square)
            model["i"] = random.randint(1,7)
            setInitialValT(square,i)
    elif(i == 4):
        square = model["L"]
        if(canMoveDownL(square,dim,i)):
            moveDownL(square)
        else:
         saveStateOfBoard(i,square)
         model["i"] = random.randint(1,7)
         setInitialValT(square,i)
    elif(i == 1):
        square = model["T-Shape"]
        if(canMoveDownT(square,dim,i)):
            moveDownT(square)
        else:
            saveStateOfBoard(i,square)
            setInitialValT(square,i)
            model["i"] = random.randint(1,7)
    elif(i == 3):
        square = model["LShape"]
        if(canMoveLShapeDown(square,dim,i)):
            moveDownLShape(square)
        else:
            saveStateOfBoard(i,square)
            setInitialValT(square,i)
            model["i"] = random.randint(1,7)
    elif(i == 5):
        square = model["LL"]
        if(canMoveDownLL(square,dim,i)):
            moveDownLL(square)
        else:
            saveStateOfBoard(i,square)
            setInitialValT(square,i)
            model["i"] = random.randint(1,7)
    elif(i == 6):
        square = model["Half"]
        if(canMoveDownHalf(square,dim,i)):
            moveDownHalf(square)
        else:
            saveStateOfBoard(i,square)
            setInitialValT(square,i)
            model["i"] = random.randint(1,7)


#post; if the pre condition is fullfilled the method moves the Half shape design to the down side
#by assigning the proper values.
def moveDownHalf(square):
    if(square["state"] == 1):
        square["y2"] += 1
        square["y1"] += 1
    elif(square["state"] == 2):
        square["y3"] += 1
        square["y2"] += 1
        square["y1"] += 1

#Pre-, Return True if and only if the Half shape design can be Moves to the down side.
def canMoveDownHalf(square,dim,i):
     if(square["state"] == 1):
        if(square["y2"]+ 1 < dim[1] and not(isSaved(square["x1"],square["y2"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x3"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y2"]+1,record,i))):
            return True
        else:
            return False
     elif(square["state"] == 2):
        if(square["y3"]+1 < dim[1] and not(isSaved(square["x1"],square["y1"]+1,record,i)) and not(isSaved(square["x1"],square["y2"]+1,record,i))
           and not(isSaved(square["x2"],square["y2"]+1,record,i)) and not(isSaved(square["x2"],square["y3"]+1,record,i))):
            return True


#Moves the LL shape design to the down side.
def moveDownLL(square):
    if(square["state"] == 1):
        square["y2"] += 1
        square["y1"] += 1
    if(square["state"] == 2):
        square["y3"] += 1
        square["y2"] += 1
        square["y1"] += 1

#Returns true if anf only if the LL Shape design can be moved to the Down side.
def canMoveDownLL(square,dim,i):
    if(square["state"] == 1):
        if(square["y2"]+ 1 < dim[1] and not(isSaved(square["x1"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x3"],square["y2"]+1,record,i)) and not(isSaved(square["x2"],square["y2"]+1,record,i))):
            return True
        else:
            return False
    elif(square["state"] == 2):
        if(square["y3"]+1 < dim[1] and not(isSaved(square["x1"],square["y2"]+1,record,i)) and not(isSaved(square["x1"],square["y3"]+1,record,i))
           and not(isSaved(square["x2"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y2"]+1,record,i))):
            return True

#Moves the LShape design to the down side.
def moveDownLShape(square):
    if(square["state"] == 1):
        square["y3"] += 1
        square["y2"] += 1
        square["y1"] += 1
    if(square["state"] == 2):
        square["y2"] += 1
        square["y1"] += 1
    if(square["state"] == 3):
        square["y3"] += 1
        square["y2"] += 1
        square["y1"] += 1
    if(square["state"] == 4):
        square["y2"] += 1
        square["y1"] += 1


#Pre-condition, if the LSHape design can be moved to the down side
#it returns true.
def canMoveLShapeDown(square,dim,i):
    if(square["state"] == 1):
        if(square["y3"]+ 1 < dim[1] and not(isSaved(square["x1"],square["y3"]+1,record,i)) and not(isSaved(square["x2"],square["y3"]+1,record,i))
           and not(isSaved(square["x2"],square["y2"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))):
            return True
        else:
            return False
    elif(square["state"] == 2):
        if(square["y2"]+1 < dim[1] and not(isSaved(square["x1"],square["y2"]+1,record,i)) and not(isSaved(square["x1"],square["y1"]+1,record,i))
           and not(isSaved(square["x2"],square["y2"]+1,record,i)) and not(isSaved(square["x3"],square["y2"]+1,record,i))):
            return True
    elif(square["state"] == 3):
        if(square["y3"]+1 < dim[1] and not (isSaved(square["x1"],square["y3"]+1,record,i))
           and not(isSaved(square["x1"],square["y2"]+1,record,i))
           and not(isSaved(square["x1"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))):
            return True
    elif(square["state"] == 4):
        if(square["y2"]+1 < dim[1] and not (isSaved(square["x1"],square["y1"]+1,record,i))
           and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x3"],square["y1"]+1,record,i)) and not(isSaved(square["x3"],square["y2"]+1,record,i))):
            return True
        else:
            return False


#Moves the T-Shape design to the down side.
def moveDownT(square):
    if(square["state"] == 1):
        square["y2"] += 1
        square["y1"] += 1
    if(square["state"] == 2):
        square["y2"] += 1
        square["y1"] += 1
        square["y3"] += 1
    if(square["state"] == 3):
        square["y1"] += 1
        square["y3"] += 1
    if(square["state"] == 4):
        square["y2"] += 1
        square["y1"] += 1
        square["y3"] += 1

#Returns true if and only if the T-Shape design can be moved to the down side.
def canMoveDownT(square,dim,i):
    if(square["state"] == 1):
        if(square["y2"]+ 1 < dim[1] and not(isSaved(square["x1"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x3"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y2"]+1,record,i))):
            return True
        else:
            return False
    elif(square["state"] == 2):
        if(square["y2"]+1 < dim[1] and not(isSaved(square["x1"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x2"],square["y2"]+1,record,i)) and not(isSaved(square["x2"],square["y3"]+1,record,i))):
            return True
    elif(square["state"] == 3):
        if(square["y1"]+1 < dim[1] and not (isSaved(square["x1"],square["y1"]+1,record,i))
           and not(isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x3"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y3"]+1,record,i))):
            return True
    elif(square["state"] == 4):
        if(square["y1"]+2 < dim[1] and not (isSaved(square["x2"],square["y1"]+1,record,i))
           and not(isSaved(square["x2"],square["y3"]+1,record,i))
           and not(isSaved(square["x3"],square["y1"]+1,record,i)) and not(isSaved(square["x2"],square["y2"]+1,record,i))):
            return True
        else:
            return False


#Moves the Line shape design to the down side whenever we press a key.
def moveDownLine(square):
    if(square["state"] == 1):
     square["yo"] += 1
     square["yyy"] += 1
     square["yy"] += 1
     square["y"] += 1
    if(square["state"] == 2):
     square["y"] += 1

#Returns true if and only if the Line shape design can be moved.
def canMoveLine(square,dim,i):
    if(square["state"] == 1):
     if(notOutOfFrame(square["x"],square["y"],dim[1]) and notOutOfFrame(square["x"],square["yy"],dim[1])
                   and notOutOfFrame(square["x"],square["yyy"],dim[1]) and notOutOfFrame(square["x"],square["yo"],dim[1])
                     and (not isSaved(square["x"],square["y"]+1,record,i) and(not isSaved(square["x"],square["yy"]+1,record,i)
                                    and (not isSaved(square["x"],square["yyy"]+1,record,i)
                                                 and (not isSaved(square["x"],square["yo"]+1,record,i))) ))):
        return True
     else:
        return False
    elif(square["state"] == 2):
         if(notOutOfFrame(square["x1"],square["y"],dim[1]) and notOutOfFrame(square["x2"],square["y"],dim[1])
                   and notOutOfFrame(square["x3"],square["y"],dim[1]) and notOutOfFrame(square["x4"],square["y"],dim[1])
                     and (not isSaved(square["x1"],square["y"]+1,record,i) and(not isSaved(square["x2"],square["y"]+1,record,i)
                                    and (not isSaved(square["x3"],square["y"]+1,record,i)
                                                 and (not isSaved(square["x4"],square["y"]+1,record,i))) ))):
          return True
    else:
         return False

#By pressing the down key it moves the active model to the down side.
def moveDownModel(square):
    square["yy"] += 1
    square["y"] += 1


#Pre-condition, returns True if and only if the Model can be moved to the right side.
def canMoveModel(square,dim):
    if(notOutOfFrame(square["x"],square["yy"],dim[1]) and notOutOfFrame(square["x"],square["y"],dim[1])
                   and notOutOfFrame(square["xx"],square["yy"],dim[1]) and notOutOfFrame(square["xxx"],square["y"],dim[1])
                     and (not isSaved(square["x"],square["yy"]+1,record) and(not isSaved(square["xx"],square["yy"]+1,record)
                                    and (not isSaved(square["x"],square["y"]+1,record)
                                                 and (not isSaved(square["xxx"],square["y"]+1,record))) ))):
       return True
    else:
        return False





###########################################################
# normally, you would not need to change anything in main #
def main(update_interval, canvas_dimensions,record):
    def keypress(event, model, canvas):
        onkey(model, event.keycode)
        draw(model, canvas)
    def gameloop(X, model, master, canvas):
        master.after(X, gameloop, X, model, master, canvas)
        onloop(model,record)
        draw(model, canvas)

    model = initialize()
    # initialize your model
    master = Tk()
    # initialize top level widget
    canvas = Canvas(master, width=canvas_dimensions[0],
                    height=canvas_dimensions[1], background="white")
    # initialize canvas
    canvas.pack()
    master.bind("<Key>", lambda e: keypress(e, model, canvas))
    # bind the keypress() function to a key press event
    # while passing the model and the canvas as arguments too
    gameloop(update_interval, model, master, canvas)
    # start the gameloop
    master.mainloop()
    # enables event handling etc. by tkinter

############################################################




if __name__ == "__main__":
    update_interval = 500
    canvas_dimensions = (300, 500)
    # [ you might want to adjust these settings ]
    record = [[0 for x in range(10)]for x in range(20)]

    main(update_interval, canvas_dimensions,record)

