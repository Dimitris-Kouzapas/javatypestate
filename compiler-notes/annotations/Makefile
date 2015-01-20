PDFLATEX = pdflatex # -file-line-error -halt-on-error

# Can't have a target with the same name as a folder.
default: main

main:
	$(PDFLATEX) main
	bibtex main
	$(PDFLATEX) main
	$(PDFLATEX) main
	rm -f *.aux *.dvi *.log *.bbl *.blg *.out
	evince main.pdf &
