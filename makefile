# makefile
# John Van Note
# 2016-01-09
#
# Resume makefile
#

.SILENT: clean compile test run resume view

resume_name=JohnVanNoteResume
resume_src=./out/$(resume_name).tex
resume_target=$(resume_name).pdf
build_pdf=pdflatex
mvn=mvn -q

clean :
	echo "Cleaning up..."
	$(mvn) clean

compile : clean
	echo "Compiling from source..."
	$(mvn) compile

test : compile
	echo "Running automated tests..."
	$(mvn) test

run : test
	echo "Building resume..."
	$(mvn) exec:java -Dexec.mainClass="com.jvn.resume.Main" -Dexec.args="$(properties)"

resume : run
	echo "Converting $(resume_src) to a PDF..."
	$(build_pdf) $(resume_src)

view : resume
	echo "Opening $(resume_target)..."
	open $(resume_target)
