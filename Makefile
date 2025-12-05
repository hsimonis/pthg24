all: Pthg24Fx-1.0.exe

Pthg24Fx-1.0.exe: package.bat
	mvn clean package
	./package.bat

clean:
	rm -f *.exe

