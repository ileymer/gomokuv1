CC = javac

SRC_PATH = ./src/
CLS_PATH = ./classes/
 
SRC_NAME = Main.java Algorithm.java Listener.java  AlgorithmHelper.java  Visual.java Eval.java
CLS_NAME = $(SRC_NAME:.java=.class)

SRC = $(addprefix $(SRC_PATH),$(SRC_NAME))
CLS = $(addprefix $(CLS_PATH),$(CLS_NAME))

$(CLS_PATH)%.class: $(SRC_PATH)%.java
	
all : $(CLS)
	mkdir $(CLS_PATH)
	$(CC) -d $(CLS_PATH) $(SRC)
	
clean:
	rm -rf $(CLS_PATH)

re: clean all

.PHONY : all clean re
