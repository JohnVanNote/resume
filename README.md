# Resume

This the source code for my resume in LaTeX and also the functionality to support a cover letter.

## Build Process

In order to build the resume from source, execute `make resume` which will build the resume from 
source. You can open build and open the file via `make view`. 

This will only works on Mac OS, but Linux/Windows support should be a pretty easy integration and 
the primary driver for building the resume is Apache Maven.

## Properties

Each build is dependent on a properties file, which should contain the following entries:
```properties
filename=MyResume.json #The name of the resume source file, located in the data directory.
filetype=json #The resume source file type (XML and JSON currently supported).
outputfilename=MyResume.tex #The output file name, located in the out directory.
templatefilename=MyResume.vm #The template the resume will be based on, located in the template directory.
```

The default properties file is `resume.properties` in the root of this project. However another 
properties file can be passed to the `make run`, `make resume`, or `make view` target using the 
properties argument, for example:

```commandline
make view properties=other.resume.properties
``` 

## Prerequisites

There are a few prerequisites that need to be installed/configured to complete the build process:

* [Java](https://www.java.com/en/ "Duh")
* [Apache Maven](https://maven.apache.org/ "Apache Maven")
* [GNU Make](https://www.gnu.org/software/make/ "GNU Make")
* [pdflatex](http://www.math.rug.nl/~trentelman/jacob/pdflatex/pdflatex.html "pdflatex")

## Technologies Used

### Apache Maven

I use Maven to build the Java modules of the project. For more on Maven, see 
[here](https://maven.apache.org/ "Apache Maven")

### GNU Make

I am using a makefile to control the build process for the entire build cycle of the resume 
(cleaning, building from source, converting to a PDF). For more info on makefiles, check 
[here](https://www.gnu.org/software/make/ "GNU Make").

### The Jackson Project

The Jackson Project is used to parse JSON (and XML) data and bind it to POJO Resume objects to 
de-couple the data and its implementation. For more information on the Jackson Project see 
[here](https://github.com/FasterXML/jackson "The Jackson Project") 

### Project Lombok

Project Lombok is a build tool used to reduce boilerplate code in java, see
[here](https://projectlombok.org/ "Project Lombok"). I'm a little iffy on if I should use it because
it requires a plugin for IntelliJ to prevent my IDE from yelling at me. But for now, it's part of 
the project.

### The LaTeX Project

LaTeX is a document preparation system that uses plain text and translates into formatted text, see 
[here](https://www.latex-project.org/ "The LaTex Project"). This way I can build the resume PDF 
programmatically, and have the implementation be independent of the resume itself.

To be transparent, the LaTeX modules included in this project are largely ripped (all credit due) 
from here [here](https://www.sharelatex.com/templates/cv-or-resume?&nocdn=true "ShareLaTeX").


### Travis CI

Travis CI is a continuous integration service that can be found 
[here](https://travis-ci.org/ "Travis CI").

I use Travis CI to automate the testing process and enforce a uniform set of tasks to be executed 
whenever a new commit is made on the project.