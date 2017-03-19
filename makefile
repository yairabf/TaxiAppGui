bin:
	mkdir bin
compile: bin
	find src | grep .java > files_to_compile.txt
	javac -d bin @files_to_compile.txt
jar:
	jar cfm taxi_app_gui.jar manifest.mf -C bin . -C resources .
run-jar:
	java -jar taxi_app_gui.jar $(W) $(H)
run:
	java -cp bin Main
