CMPZ 0
SUB #1
JMPZ F
CMPL 0
SUB #1
JMPZ #E
LOD 0
STO 1
LOD 0 
SUB DATA #1
STO 0
CMPZ 0
SUB #1
JMPZ data 6
LOD 0
MUDataL 1
JUMP -9	
NOT
STO 1
HALT
DATA
0 8