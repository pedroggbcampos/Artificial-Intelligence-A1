JFLAGS = -g
JC = javac
JVM = java
PCK = matrices

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	Matrix.java \
	Functions.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
