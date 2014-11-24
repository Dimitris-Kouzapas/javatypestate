PDFLATEX = pdflatex # -file-line-error -halt-on-error

# Can't have a target with the same name as a folder.
default: java-integration

java-integration:
	$(PDFLATEX) java-integration
	bibtex java-integration
	$(PDFLATEX) java-integration
	$(PDFLATEX) java-integration
	rm -f *.aux *.dvi *.log *.bbl *.blg *.out
	evince java-integration.pdf &
